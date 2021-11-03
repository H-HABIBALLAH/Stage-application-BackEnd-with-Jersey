package service;

import dao.offre.OffreDao;
import dao.offre.OffreDaoImpl;
import entities.Offre;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/offres")
public class OffreService {

    OffreDao offreDaoImpl = new OffreDaoImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllOffre() throws SQLException {
        return offreDaoImpl.getAll();
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
