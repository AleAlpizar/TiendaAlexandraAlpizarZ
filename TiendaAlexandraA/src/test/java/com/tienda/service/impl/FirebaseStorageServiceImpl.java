/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service.impl;

import com.google.auth. Credentials;
import com.google. auth.ServiceAccountSigner;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud. storage.*;
import com. google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.SignUrlOption;
import com.google.cloud.storage.StorageOptions;
import com.Tienda.demo.service.FirebaseStorageService;
import com.tienda.service.FirebaseStorageService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException; 
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;
import org.springtramework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FirebaseStorageServiceImpl implements FirebaseStorageService {
    
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id) {
        try {
            String extension = archivoLocalCliente.getOriginalFilename();
            String fileName = "img" + sacaNumero(id) + extension;
            File file this.convertTofile(archivoLocalCliente);
            String URL = this.uploadFile(file, carpeta, fileName);
            file.delete();
           return URL;
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
    private String uploadFile(File file,
            String carpeta, 
            String fileName) throws IOException {
        //Se define el lugar y acceso al archivo •jasper
        ClassPathResource json = new ClassPathResource (rutaJsonFile + File.separator + archivoJsonFile);
        BlobId blobId = BlobId.of ( BucketName,
                rutaSuperiorStorage + "/" + carpeta + "/"+ fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder (blobId)
                .setContentType ( "media").build();
        
        Credentials credentials = GoogleCredentials
                .fromStream(credentialsStream: json.getInputStream()) ;
        Storage storage = StorageOptions.newBuilder()
                .setCredentials(credentials).build().getService ();
        storage.create( blobInfo, bytes: Files.readAllBytes ( file.toPath()));
        String url = storage.signUrl ( blobInfo,
                1: 3650,
                tu: TimeUnit. DAYS,
                suos: SignUrlOption signWith((ServiceAccountSigner) credentials))
                .tostring ();
        return url;
    }
    //Método utilitario que convierte el archivo desde el equipo local
    // del usuario a un archivo temporal en el servidor
    private File convertIoFile (MultipartFile archivoLocalCliente) throws IOException {
    File tempFile = File.createTempFile( "img", null);
    try (FileOutputStream fos = new FileOutputStream ( tempFile)) {
        fos.write ( archivoLocalCliente.getBytes ()) ;
        fos.close ();
    }
    return tempFile;
    }
    //Método utilitario para obtener un string con ceros....
    private String sacaNumero (long id) {
    return String.format ("4019d", id);
    }
}   
