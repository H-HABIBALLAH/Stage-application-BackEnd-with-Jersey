package service;

import com.google.gson.Gson;
import dao.offre.OffreDao;
import dao.offre.OffreDaoImpl;
import entities.Offre;
import util.EmailSender;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.sql.SQLException;

@Path("/offres")
public class OffreService {

    OffreDao offreDaoImpl = new OffreDaoImpl();
    Gson gson = new Gson();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllOffre() throws SQLException {
        return offreDaoImpl.getAll();
    }

    @PUT
    @Path("/confirme/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response confirmOffre(@PathParam("id") Long id) throws SQLException {
        offreDaoImpl.edit_offre_confirm(id);
        return Response.seeOther(URI.create("http://localhost:8080/notify/"+id)).build();
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
