package service;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.*;

@Path("/file")
public class FiletTestService { 
    @POST
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.MULTIPART_FORM_DATA})
    public void saveFile1(@FormDataParam("file1") InputStream fileInputStream1,
                         @FormDataParam("file1") FormDataContentDisposition fileMetaData1,
                          @FormDataParam("file2") InputStream fileInputStream2,
                          @FormDataParam("file2") FormDataContentDisposition fileMetaData2) throws IOException {
//        System.out.println(fileMetaData.getName());
        byte[] bytes= new byte[1024];
        int read = 0;

        File f = new File("C:\\Users\\admin\\Desktop\\Desktop\\ENSIBS\\S7\\AppStage\\test.pdf");

        OutputStream os = new FileOutputStream(f);

        while ((read = fileInputStream1.read())!=-1){
            os.write(read);
            os.flush();
        }

        os.close();
        System.out.println("stop");
        fileInputStream1.close();

    }

}
