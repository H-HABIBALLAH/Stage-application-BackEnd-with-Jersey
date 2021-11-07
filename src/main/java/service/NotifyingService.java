package service;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import dao.etudiant.EtudiantDao;
import dao.etudiant.EtudiantDaoImpl;
import dao.offre.OffreDao;
import dao.offre.OffreDaoImpl;
import entities.Etudiant;
import entities.Offre;
import util.EmailSender;

import javax.mail.MessagingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("/notify")
public class NotifyingService {

    Gson gson = new Gson();
    Offre offreConfirme = null;
    OffreDao odao = new OffreDaoImpl();
    List<Etudiant> studentList = new ArrayList<>();
    EtudiantDao edao = new EtudiantDaoImpl();
    EmailSender emailSender = new EmailSender();

    @GET
    @Path("/{id}")
    public String sendEmail(@PathParam("id") Long id) throws MessagingException, SQLException, IOException {

        offreConfirme = gson.fromJson(odao.getById(id),Offre.class);

        String student_Having_Competences = edao.getByCompetences(offreConfirme.getCompetences());
        Type studentListType = new TypeToken<ArrayList<Etudiant>>(){}.getType();

        studentList = gson.fromJson(student_Having_Competences, studentListType);

//        for(Etudiant student : studentList){
//            emailSender.sendEmail(student.getMail(),offreConfirme.getEntrepriseName(),offreConfirme.getCompetences());
//        }

        emailSender.sendEmail(studentList,offreConfirme.getEntrepriseName(),offreConfirme.getCompetences());

        return gson.toJson(offreConfirme);
    }
}
