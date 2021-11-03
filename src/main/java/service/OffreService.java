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
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllOffre() throws SQLException {
        return offreDaoImpl.getAll();
    }

    @GET
    @Path("/all/{competences}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllOffre(@PathParam("competences") String competences) throws SQLException {
        return offreDaoImpl.getByCompetences(competences);
    }
    @POST
    @Path("/save/{titre}/{contenu}/{competences}/{entrepriseName}")
    public void saveOffre(@PathParam("titre")String titre,@PathParam("contenu")String contenu,@PathParam("competences")String competences,@PathParam("entrepriseName")String entrepriseName) throws SQLException {
        offreDaoImpl.save(new Offre(titre,null,contenu,competences,entrepriseName));
    }
}
