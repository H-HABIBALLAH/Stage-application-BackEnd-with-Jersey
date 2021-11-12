package service;

import com.google.gson.Gson;
import dao.etudiant.EtudiantDao;
import dao.etudiant.EtudiantDaoImpl;
import entities.Etudiant;
import org.glassfish.jersey.media.multipart.FormDataParam;
import util.MD5Hash;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@Path("/login" )
public class Login {

    EtudiantDao edao = new EtudiantDaoImpl();
    Etudiant etudiant = null;
    Gson gson = new Gson();

    @POST
    public Response authenticate(@FormDataParam("email") String email, @FormDataParam("password") String password) throws SQLException, NoSuchAlgorithmException {
        etudiant = gson.fromJson(edao.getByEmail(email), Etudiant.class);
        String passwordHashed = MD5Hash.hash(password);

        if (etudiant == null || !etudiant.getPassword().equals(passwordHashed))
            return Response.status(Response.Status.UNAUTHORIZED).entity("Veuillez vérifier votre email et password").build();

        else {
            return Response.status(Response.Status.OK).entity(etudiant).build();
        }
    }
}
