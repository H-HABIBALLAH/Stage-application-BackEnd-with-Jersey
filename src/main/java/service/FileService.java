package service;

import com.google.gson.Gson;
import dao.fichier.FichierDao;
import dao.fichier.FichierDaoImpl;
import entities.Fichier;
import org.apache.commons.lang3.ArrayUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("/file")
public class FileService {

    Gson gson = new Gson();
    FichierDao fdao = new FichierDaoImpl();

    @POST
    @Path("/new")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.APPLICATION_JSON})
    public String saveFile1(@FormDataParam("file1") InputStream fileInputStream1,
                            @FormDataParam("file1") FormDataContentDisposition fileMetaData1,
                            @FormDataParam("type") String type,
                            @FormDataParam("title") String title) throws IOException, SQLException {
//       + System.out.println(fileMetaData.getName());
        int read = 0;

        Fichier newFile = new Fichier();
        List<Byte> byteList = new ArrayList<>();
//
        File f = new File("C:\\Users\\admin\\Desktop\\Desktop\\ENSIBS\\S7\\AppStage\\test.pdf");

        OutputStream os = new FileOutputStream(f);

        while ((read = fileInputStream1.read()) != -1) {
            byteList.add((byte) read);
            os.write(read);
        }

        Byte[] byteArray = new Byte[byteList.size()];

        byte[] primitiveBytArray = ArrayUtils.toPrimitive(byteList.toArray(byteArray));

        newFile.setData(primitiveBytArray);
        newFile.setTitle(title);
        newFile.setType(type);

        os.close();
        System.out.println("stop");
        fileInputStream1.close();

        fdao.save(newFile);

        return gson.toJson(newFile);
    }

//    @GET
//    @Path("/get/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getById(@PathParam("id") Long id) throws SQLException {
//        return fdao.getById(id);
//    }

//    @GET
//    @Path("/file/download")
//    @Produces("application/pdf")
//    public Response downloadFile(){
//        File f = new File("C:\\Users\\admin\\Desktop\\Desktop\\ENSIBS\\S7\\AppStage\\test.pdf");
//        Response.ResponseBuilder response = Response.ok((Object) f);
//        response.header("Content-Disposition", "attachment; filename=\"testDownloaded.pdf\"");
//        return response.build();
//    }

@GET
@Path("/download/{id}")
@Produces("application/pdf")
public Response downloadFile(@PathParam("id")Long id) throws IOException, SQLException {
    File f = new File("D:\\temp.pdf");
    f.createNewFile();
    OutputStream os = new FileOutputStream(f);

    Fichier dbFile = gson.fromJson(fdao.getById(id), Fichier.class);

    byte[] dbFile_byte_array = dbFile.getData();

    for(int i=0; i<dbFile_byte_array.length; i++){
        os.write(dbFile_byte_array[i]);
    }
    os.close();

    Response.ResponseBuilder response = Response.ok((Object) f);
    response.header("Content-Disposition", "attachment; filename=\"CV.pdf\"");
    return response.build();
}

}
