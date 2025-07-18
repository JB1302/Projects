package com.caso1.service;

import com.google.auth.Credentials;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.cloud.storage.Storage.SignUrlOption;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FirebaseStorageService {

    //El BuketName es el <id_del_proyecto> + ".firebasestorage.app"
    final String BucketName = "techshop-25fa5.firebasestorage.app";

    
    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "caso";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";

    //El nombre del archivo Json
    final String archivoJsonFile = "techshop-25fa5-firebase-adminsdk-fbsvc-2e12c9a251"+".json";

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id) {
        try {
            // El nombre original del archivo local del cliene
            String extension = archivoLocalCliente.getOriginalFilename();

            // Se genera el nombre según el código del articulo. 
            String fileName = "img" + sacaNumero(id) + extension;

            // Se convierte/sube el archivo a un archivo temporal
            File file = this.convertToFile(archivoLocalCliente);

            // se copia a Firestore y se obtiene el url válido de la imagen (por 10 años) 
            String URL = this.uploadFile(file, carpeta, fileName);

            // Se elimina el archivo temporal cargado desde el cliente
            file.delete();

            return URL;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String uploadFile(File file, String carpeta, String fileName) throws IOException {
        //Se define el lugar y acceso al archivo .jasper
        ClassPathResource json = new ClassPathResource(rutaJsonFile + File.separator + archivoJsonFile);
        BlobId blobId = BlobId.of(BucketName, rutaSuperiorStorage + "/" + carpeta + "/" + fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();

        Credentials credentials = GoogleCredentials.fromStream(json.getInputStream());
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        String url = storage.signUrl(blobInfo, 3650, TimeUnit.DAYS, SignUrlOption.signWith((ServiceAccountSigner) credentials)).toString();
        return url;
    }

    //Método utilitario que convierte el archivo desde el equipo local del usuario a un archivo temporal en el servidor
    private File convertToFile(MultipartFile archivoLocalCliente) throws IOException {
        File tempFile = File.createTempFile("img", null);
        try (
                FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(archivoLocalCliente.getBytes());
        }

        return tempFile;
    }

    //Método utilitario para obtener un string con ceros....
    private String sacaNumero(long id) {
        return String.format("%019d", id);
    }
}