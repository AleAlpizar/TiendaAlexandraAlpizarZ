/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;
import com.tienda.domain.Producto;
import java.util.List;
/**
 *
 * @author 11alp
 */
public interface ProductoService {
    public List<Producto> getProductos(boolean activo);

    public Producto getProducto(Producto producto);
    
    public void save(Producto producto);
    
    public void delete(Producto producto);
}
