package com.twt.curso.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus; 
 
@ResponseStatus(value=HttpStatus.NOT_FOUND,
        reason="No se han econtrado producto bajo la categoría dada") 
public class ProductosNoEncontradosPorCategoriaException extends RuntimeException {


	private static final long serialVersionUID = -1355581586933504353L;
    
}
