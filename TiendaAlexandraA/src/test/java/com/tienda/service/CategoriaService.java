/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

/**
 *
 * @author 11alp
 */
import com.tienda.domain.Categoria;
import java.util.List;
public interface CategoriaService {        

// Se obtiene un listado de categorias en un List    
    public List<Categoria> getCategorias(boolean activos); 
    public Categoria getCategoria(Categoria categoria);
    public void save(Categoria categoria);
    public void delete(Categoria categoria);
    
    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria Categoria){
        return CategoriaDao.findById(Categoria.getIdCategoria()).orElse(null);
    }
    @Override
    @Transactional
    public void save(Categoria Categoria){
        CategoriaDao.save(Categoria);
    }
    
    @Override
    @Transactional
    public void delete(Categoria Categoria){
        CategoriaDao.delete(Categoria);
    }
}
