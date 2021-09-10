package com.twt.curso.service;

import java.util.List;

import com.twt.curso.entidades.Producto;

public interface ProductoService {

	List<Producto> getTodosProductos();

	List<Producto> getProductosPorCategoria(String categoria);

	Producto getProductoPorId(String idProducto);

	void crearProducto(Producto producto);

}
