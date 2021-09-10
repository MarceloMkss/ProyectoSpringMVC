
package com.twt.curso.Exception;

public class GestionProductoException 
    extends RuntimeException {

   
	private static final long serialVersionUID = 5332703785065073526L;
	
private String idProducto;
   private String claveMensaje;

    public GestionProductoException(String idProducto) {
        this.idProducto = idProducto;
        this.claveMensaje = "";
    }

    public GestionProductoException(String idProducto, String claveMensaje) {
        this.idProducto = idProducto;
        this.claveMensaje = claveMensaje;
    }
    
    
    

    public String getIdProducto() {
        return idProducto;
    }

    public String getClaveMensaje() {
        return claveMensaje;
    }
    
    
   
   
}
