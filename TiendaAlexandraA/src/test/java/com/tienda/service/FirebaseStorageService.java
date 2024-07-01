/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author 11alp
 */
@Service
public interface FirebaseStorageService {
    public String cargalmagen (MultipartFile archivoLocalCliente,
    //El BuketName es el cid_del_proyectos + ".appspot.com#
    final String BucketName = "techshop-70262.appspot.com";
    //Esta es la ruta básica de este proyecto Techshop
    final String rucasuperiorstozage = "techshop";
    //Ubicación donde se encuentra el archivo de configuración
    final String rutaJsonFile = "firebase" ;
    //El nombre del archivo Json
    final String archivoJsonFile = "techshop-70262-firebase-adminsdk-ftnwx-0442f8d411.json;
    
}
