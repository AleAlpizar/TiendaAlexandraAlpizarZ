/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

/**
 *
 * @author 11alp
 */
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import com.tienda.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var Categoria = CategoriaService.getCategoria(false);
        model.addAttribute("categorias", Categoria);
        model.addAttribute("totalCategorias", Categorias.size());
        return "/categoria/listado";
    }
    @GetMapping("/nuevo")
    public String categoriaNuevo(Categoria categoria){
        return "/categoria/modifica";
    }
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    @PostMapping("/guardar")
    public String categoriaGuardar(Categoria Categoria,
            @RequestParam("imagenFile")MultipartFile imagenFile){
        if (!imagenFile.isEmpty()){
            CategoriaService.save(Categoria);
            Categoria.setRutaImagen(
                                   firebaseStorageService.cargaImagen(imagenFile,
                                           "categoria", Categoria.getIdCategoria()));
        }
        categoriaService.save(Categoria);
        return "redirect:/categoria/listado";
    }
    @GetMapping("/eliminar/idCategoria")
    public String categoriaEliminar(Categoria categoria){
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }
    @GetMapping("/eliminar/idCategoria")
    public String categoriaModificar(Categoria categoria, Model model){
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
    }
}