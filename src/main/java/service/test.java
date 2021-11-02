package service;

import dao.administrateur.AdministrateurDao;
import dao.administrateur.AdministrateurDaomImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import entities.Administrateur;


@Path("/admin")
public class test {

    Gson gson = new Gson();
    AdministrateurDao adminDao = new AdministrateurDaomImpl();

    @GET
    @Path("/{id}")
    public String getAdmin(@PathParam("id") Long id)
    {
        return gson.toJson(adminDao.getAdminById(id));
    }

    @POST
    @Path("/{nom}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAdmin(@PathParam("nom")String nom){
        adminDao.saveAdmin(new Administrateur(nom,"Sadou","Sadou@ensibs.fr","abcde"));
//        return gson.toJson(administrateur);
    }
}
