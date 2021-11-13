package service;

import com.google.gson.Gson;
import dao.administrateur.AdministrateurDao;
import dao.administrateur.AdministrateurDaomImpl;
import dao.offre.OffreDao;
import dao.offre.OffreDaoImpl;
import entities.Administrateur;
import entities.Offre;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@Path("/offres")
public class OffreService {

    OffreDao offreDaoImpl = new OffreDaoImpl();
    AdministrateurDao adao = new AdministrateurDaomImpl();
    Administrateur administrateur = null;
    Gson gson = new Gson();

    @GET
    @Path("/all")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOffre(@FormDataParam("username") String username,
                              @FormDataParam("password") String password) throws SQLException, NoSuchAlgorithmException {
        administrateur = gson.fromJson(adao.getAdmin(), Administrateur.class);

//        String passwordHashed = MD5Hash.hash(password);

        if (administrateur == null || !administrateur.getPassword().equals(password) || !administrateur.getMail().equals(username))
            return Response.status(Response.Status.UNAUTHORIZED).entity("Veuillez vérifier votre email et password").build();

        else {
            return Response.status(Response.Status.OK).entity(offreDaoImpl.getAll()).build();
        }
    }

    @PUT
    @Path("/confirm/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response confirmOffre(@PathParam("id") Long id) throws SQLException {
        offreDaoImpl.edit_offre_confirm(id);
        return Response.seeOther(URI.create("http://localhost:8080/notify/"+id)).build();
    }

    @GET
    @Path("/confirmes")
    @Produces(MediaType.APPLICATION_JSON)
    public String getOffresConfirmes() throws SQLException {
        String offresConfirmes = offreDaoImpl.getOffresConfirmes();
        return offresConfirmes;
    }

    @GET
    @Path("/competences/{competences}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllOffre(@PathParam("competences") String competences) throws SQLException {
        return offreDaoImpl.getByCompetences(competences);
    }

    @POST
    @Path("/save")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Offre saveOffre(final Offre newOffre) throws SQLException {
        System.out.println("called");
        offreDaoImpl.save(new Offre(newOffre.getTitre(), newOffre.getConfirme(), newOffre.getContenu(), newOffre.getCompetences(), newOffre.getEntrepriseName()));
        return newOffre;
    }
}
