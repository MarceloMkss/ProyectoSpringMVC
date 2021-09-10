
package com.twt.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twt.curso.Exception.GestionProductoException;
import com.twt.curso.entidades.Producto;
import com.twt.curso.repositorios.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	private ProductoRepository productoRepositorio;

	public ProductoServiceImpl() {
		System.out.println("........... intanciando ProductoServiceImpl");
	}

	@Override
	public List<Producto> getTodosProductos() {
		return productoRepositorio.getAllProductos();
	}

	@Override
	public List<Producto> getProductosPorCategoria(String categoria) {
		return productoRepositorio.getProductosPoCategoria(categoria);
	}

	@Override
	public Producto getProductoPorId(String idProducto) {

		Producto producto = productoRepositorio.getProductoPorId(idProducto);

		return producto;
	}

	@Override
	public void crearProducto(Producto producto) {
		try {
			productoRepositorio.crearProducto(producto);
			throw new GestionProductoException(producto.getIdProducto(), "No pudo crear . ya existe el producto con id");
		} catch (IllegalArgumentException e) { // el id no existe

			// correcto como no hay creo
			productoRepositorio.crearProducto(producto);

		}
	}

}
