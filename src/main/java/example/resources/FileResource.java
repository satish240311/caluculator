package example.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;

@Path("file")
@Api(value = "file")
public class FileResource {

    private static final String SERVER_UPLOAD_LOCATION_FOLDER = "/Users/shauvik/tmp/";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "List of files")
    public Bean fileList(){
        return new Bean("List of files...tbd");
    }

    /**
     * Upload a File
     */

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @ApiOperation(value = "Upload a file")
    public Bean uploadFile(
            @ApiParam(required = true) @FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition contentDispositionHeader) {

        String fileName = String.format("%s_%s",
                System.currentTimeMillis(),
                contentDispositionHeader.getFileName());

        String filePath = SERVER_UPLOAD_LOCATION_FOLDER + fileName;

        // save the file to the server
        saveFile(fileInputStream, filePath);

        return new Bean(fileName);

    }

    // save uploaded file to a defined location on the server
    private void saveFile(InputStream uploadedInputStream,
                          String serverLocation) {

        try {
            OutputStream outputStream = null;
            int read = 0;
            byte[] bytes = new byte[1024];

            outputStream = new FileOutputStream(new File(serverLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            if(outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
