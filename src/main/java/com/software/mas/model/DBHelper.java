package com.software.mas.model;



import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private final static String ip="jdbc:mysql://localhost:3306/mas", username ="root", password ="";
    private final static String req = "http://localhost:3000/serverside/upload_photo.jsp";
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(ip,username,password);
    }
    private static final OkHttpClient client = new OkHttpClient();
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image");
    private static void uploadImage (String email, String password, String type, File file ){

        String imageEnding = file.toString().split("\\.")[1];


        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("email", email)
                .addFormDataPart("password", password)
                .addFormDataPart("type",type)
                .addFormDataPart("image", "idk."+imageEnding, RequestBody.create(MEDIA_TYPE_PNG,file))
                .build();

        Request request = new Request.Builder()
                .url("http://localhost/upload_image/test.php")
                .post(requestBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) throw new IOException("Unexpected code ::=> " + response);

            System.out.println(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void setProfilePhoto(String email, String password, File file){
       DBHelper.uploadImage(email,password,"set_profile_photo",file);
    }
    public static void addImageSlide(String email, String password, File file){
        DBHelper.uploadImage(email,password,"add_image_slide",file);

    }
    public static void setMainServiceImage(String email , String password, File file){
        DBHelper.uploadImage(email,password,"set_main_service_image",file);

    }


}
