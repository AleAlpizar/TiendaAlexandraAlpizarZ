/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service.impl;

/**
 *
 * @author 11alp
 */
import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
class CategoriaServiceImpl implements CategoriaService { 
    
    @Autowired    
    private CategoriaDao categoriaDao;    
    @Override    @Transactional(readOnly=true)    
    public List<Categoria> getCategorias(boolean activos) {        
        var lista=categoriaDao.findAll();      
        if (activos) {           
            lista.removeIf(e -> !e.isActivo());        
        }        
        return lista;    
    }
}