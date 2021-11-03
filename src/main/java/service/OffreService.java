package service;

import dao.offre.OffreDao;
import dao.offre.OffreDaoImpl;
import entities.Offre;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.SQLException;

@XmlRootElement
class MyJaxBean { @XmlElement
public String param1; @XmlElement public String param2; }

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
//    @POST
//    @Path("/save/{titre}/{contenu}/{competences}/{entrepriseName}")
//    public void saveOffre(@PathParam("titre")String titre,@PathParam("contenu")String contenu,@PathParam("competences")String competences,@PathParam("entrepriseName")String entrepriseName) throws SQLException {
//        offreDaoImpl.save(new Offre(titre,null,contenu,competences,entrepriseName));
//    }

    @POST
    @Path("/save")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Offre saveOffre(final Offre newOffre) throws SQLException {
        System.out.println("called");
        offreDaoImpl.save(new Offre(newOffre.getTitre(), newOffre.getConfirme(), newOffre.getContenu(), newOffre.getCompetences(), newOffre.getEntrepriseName()));
        return newOffre;
    }

    @POST
    @Consumes("application/json")
    @Path("/create")
    public void create(final MyJaxBean input) {
        System.out.println("param1 = " + input.param1);
        System.out.println("param2 = " + input.param2);
    }
}
