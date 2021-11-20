package service;

import com.google.gson.Gson;
import dao.etudiant.EtudiantDao;
import dao.etudiant.EtudiantDaoImpl;
import entities.Etudiant;
import org.apache.commons.lang3.ArrayUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import util.MD5Hash;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("/etudiants")
public class EtudiantService {

    Gson gson = new Gson();
    EtudiantDao etudiantDaoImpl = new EtudiantDaoImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllEtudiant() throws SQLException {
        return etudiantDaoImpl.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEtudiantById(@PathParam("id") Long id) throws SQLException {
        return etudiantDaoImpl.getById(id);
    }

    @GET
    @Path("/competences/{competences}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllEtudiant(@PathParam("competences") String competences) throws SQLException {
        return etudiantDaoImpl.getByCompetences(competences);
    }

    @POST
    @Path("/save")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.MULTIPART_FORM_DATA})
    public Response saveStudent(@FormDataParam("nom") String nom,
                                @FormDataParam("prenom") String prenom,
                                @FormDataParam("mail") String mail,
                                @FormDataParam("password") String password,
                                @FormDataParam("noEtudiant") String noEtudiant,
                                @FormDataParam("LinkedIn") String linkedIn,
                                @FormDataParam("description") String description,
                                @FormDataParam("competences") String competences,
                                @FormDataParam("cv") InputStream cvInputStream,
                                @FormDataParam("cv") FormDataContentDisposition cvMetaData,
                                @FormDataParam("lm") InputStream lmInputStream,
                                @FormDataParam("lm") FormDataContentDisposition lmMetaData) throws SQLException, IOException, NoSuchAlgorithmException {
        Etudiant newStudent= new Etudiant(null,nom,prenom,mail,password,noEtudiant,null,null,linkedIn,description,competences,null,null);
        int read = 0;
        Byte[] byteArray;
        byte[] primitiveBytArray;
        List<Byte> byteList = new ArrayList<>();
        String passwordHashed = null;

        while ((read = cvInputStream.read()) != -1) {
            byteList.add((byte) read);
//            System.out.print(read + ",");
        }
        byteArray = new Byte[byteList.size()];
        primitiveBytArray = ArrayUtils.toPrimitive(byteList.toArray(byteArray));
        newStudent.setCv(primitiveBytArray);

        byteList.clear();

        while ((read = lmInputStream.read()) != -1) {
            byteList.add((byte) read);
//            System.out.print(read + ",");
        }
        byteArray = new Byte[byteList.size()];
        primitiveBytArray = ArrayUtils.toPrimitive(byteList.toArray(byteArray));
        newStudent.setLm(primitiveBytArray);

        passwordHashed = MD5Hash.hash(password);

        newStudent.setPassword(passwordHashed);

        etudiantDaoImpl.save(newStudent);

        if(etudiantDaoImpl.getByEmail(newStudent.getMail()) == null)
            return Response.status(Response.Status.REQUEST_TIMEOUT).build();

        return Response.seeOther(URI.create("http://localhost:8080/etudiants")).build();

    }

    @GET
    @Path("/{id}/cv")
    @Produces("application/pdf")
    public Response downloadCv(@PathParam("id")Long id) throws IOException, SQLException {
        File f = new File("D:\\temp.pdf");
        f.createNewFile();
        OutputStream os = new FileOutputStream(f);

        Etudiant etudiant = gson.fromJson(etudiantDaoImpl.getById(id), Etudiant.class);

        byte[] dbFile_byte_array = etudiant.getCv();

        for(int i=0; i<dbFile_byte_array.length; i++){
            os.write(dbFile_byte_array[i]);
        }
        os.close();

        Response.ResponseBuilder response = Response.ok((Object) f);
        response.header("Content-Disposition", "attachment; filename=\"CV.pdf\"");
        return response.build();
    }

    @GET
    @Path("/{id}/lm")
    @Produces("application/pdf")
    public Response downloadLm(@PathParam("id")Long id) throws IOException, SQLException {
        File f = new File("D:\\temp.pdf");
        f.createNewFile();
        OutputStream os = new FileOutputStream(f);

        Etudiant etudiant = gson.fromJson(etudiantDaoImpl.getById(id), Etudiant.class);

        byte[] dbFile_byte_array = etudiant.getLm();

        for(int i=0; i<dbFile_byte_array.length; i++){
            os.write(dbFile_byte_array[i]);
        }
        os.close();

        Response.ResponseBuilder response = Response.ok((Object) f);
        response.header("Content-Disposition", "attachment; filename=\"LM.pdf\"");
        return response.build();
    }

//    @POST
//    @Path("/save")
//    @Consumes({MediaType.MULTIPART_FORM_DATA})
//    @Produces({MediaType.APPLICATION_JSON})
//    public String saveStudent(@FormDataParam("student") final Etudiant newStudent,
//                                @FormDataParam("cv") InputStream cvInputStream,
//                                @FormDataParam("cv") FormDataContentDisposition cvMetaData,
//                                @FormDataParam("lm") InputStream lmInputStream,
//                                @FormDataParam("lm") FormDataContentDisposition lmMetaData) throws SQLException, IOException {
//        int read = 0;
//        Byte[] byteArray;
//        byte[] primitiveBytArray;
//        List<Byte> byteList = new ArrayList<>();
//
//        while ((read = cvInputStream.read()) != -1) {
//            byteList.add((byte) read);
////            System.out.print(read + ",");
//        }
//        byteArray = new Byte[byteList.size()];
//        primitiveBytArray = ArrayUtils.toPrimitive(byteList.toArray(byteArray));
//        newStudent.setCv(primitiveBytArray);
//
//        byteList.clear();
//
//        while ((read = lmInputStream.read()) != -1) {
//            byteList.add((byte) read);
////            System.out.print(read + ",");
//        }
//        byteArray = new Byte[byteList.size()];
//        primitiveBytArray = ArrayUtils.toPrimitive(byteList.toArray(byteArray));
//        newStudent.setLm(primitiveBytArray);
//
//        etudiantDaoImpl.save(new Etudiant(newStudent.getNom(), newStudent.getPrenom(), newStudent.getMail(), newStudent.getPassword(),newStudent.getNoEtudiant(), newStudent.getInscrit(), newStudent.getFormation(), newStudent.getLinkedInLink(), newStudent.getDescription(), newStudent.getCompetences(), newStudent.getCv(), newStudent.getLm()));
//        return gson.toJson(newStudent);
//    }
}
