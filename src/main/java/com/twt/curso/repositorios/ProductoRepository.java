
package com.twt.curso.repositorios;

import java.util.List;

import com.twt.curso.entidades.Producto;

public interface ProductoRepository {
    
    List <Producto> getAllProductos();
    Producto getProductoPorId(String idProducto);
    List<Producto> getProductosPoCategoria(String categoria);
    void crearProducto(Producto producto) ;
}
