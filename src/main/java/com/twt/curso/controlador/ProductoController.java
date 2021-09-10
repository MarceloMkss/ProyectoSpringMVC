package com.twt.curso.controlador;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.twt.curso.Exception.GestionProductoException;
import com.twt.curso.Exception.ProductosNoEncontradosPorCategoriaException;
import com.twt.curso.entidades.Producto;
import com.twt.curso.service.ProductoService;

import lombok.extern.java.Log;

@Controller
@RequestMapping("comercio")
@Log
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	public ProductoController() {
		System.out.println("... iniciando ProductController");
	}

	@RequestMapping("/productos")
	public String list(Model model) {

		model.addAttribute("productos", productoService.getTodosProductos());

		return "productos";
	}

	@RequestMapping("/productos/{categoria}")
	public String getProductosPorCategoria(Model model, @PathVariable("categoria") String categoriaProducto) {

		List<Producto> productos = productoService.getProductosPorCategoria(categoriaProducto);
        if (productos == null || productos.isEmpty()) {
            throw new ProductosNoEncontradosPorCategoriaException();
        }
        
		model.addAttribute("productos", productoService.getProductosPorCategoria(categoriaProducto));
		return "productos";
	}

	@RequestMapping("/producto")
	public String getProductoPorId(@RequestParam("id") String productId, Model model) {
		model.addAttribute("producto", productoService.getProductoPorId(productId));
		return "producto";
	}

	// PRACTICA 7 // mostra el fomulario
	@RequestMapping(value = "/productos/nuevo", method = RequestMethod.GET)
	public String getCrearNuevoProductoFormulario(Model model) {
		Producto nuevoProducto = new Producto();
		model.addAttribute("nuevoProducto", nuevoProducto);
		return "crear-producto";
	}

	// tratara los datos recibidos del formulariom
	@RequestMapping(value = "/productos/nuevo", method = RequestMethod.POST)
	public String procesarCrearNuevoProductoFormulario(@ModelAttribute("nuevoProducto")
	@Valid Producto nuevoProducto,
			BindingResult bindingResult, HttpServletRequest request) {
	
		//obtener fichero
        MultipartFile imagenProducto = nuevoProducto.getImagenProducto();
        

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        
        if (imagenProducto != null && !imagenProducto.isEmpty()) {
            System.out.println("... hay imagen");
            try {
                imagenProducto.transferTo(new File(rootDirectory + "resources/imagenes/"
                        + nuevoProducto.getIdProducto() + ".png"));
            } catch (Exception e) {
                throw new RuntimeException("Ha fallado la creación del nuevo Producto", e);
            }
        }
        
//		if (bindingResult.hasErrors()) {
//			log.info("error" + bindingResult.getErrorCount());
//			return "redirect:/comercio/productos/nuevo";
//		}

		productoService.crearProducto(nuevoProducto);

		// model.addAttribute("productos",
		// productoService.getTodosProductos());
		// return "productos";
		return "redirect:/comercio/productos";
	}

	@ExceptionHandler(GestionProductoException.class)
	public ModelAndView handleError(HttpServletRequest req, GestionProductoException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("idProductoNoEncontrado", exception.getIdProducto());
		mav.addObject("calveMensage", exception.getClaveMensaje());
		mav.setViewName("producto-exception");
		return mav;
	}

}
