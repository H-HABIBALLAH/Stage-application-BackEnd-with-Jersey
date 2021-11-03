package service;

import dao.etudiant.EtudiantDao;
import dao.etudiant.EtudiantDaoImpl;
import entities.Etudiant;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/etudiants")
public class EtudiantService {

    EtudiantDao etudiantDaoImpl = new EtudiantDaoImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllEtudiant() throws SQLException {
        return etudiantDaoImpl.getAll();
    }

    @GET
    @Path("/competences/{competences}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllEtudiant(@PathParam("competences") String competences) throws SQLException {
        return etudiantDaoImpl.getByCompetences(competences);
    }

    @POST
    @Path("/save")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Etudiant saveStudent(final Etudiant newStudent) throws SQLException {
        System.out.println("called");
        etudiantDaoImpl.save(new Etudiant(newStudent.getNom(), newStudent.getPrenom(), newStudent.getMail(), newStudent.getPassword(),newStudent.getNoEtudiant(), newStudent.getInscrit(), newStudent.getFormation(), newStudent.getLinkedInLink(), newStudent.getDescription(), newStudent.getCompetences(),null));
        return newStudent;
    }
}
