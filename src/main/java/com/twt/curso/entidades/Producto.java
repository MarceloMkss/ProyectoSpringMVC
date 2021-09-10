package com.twt.curso.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

public class Producto implements Serializable {


	private static final long serialVersionUID = 6781802536139715417L;
	
	private String idProducto;
	private String nombre;
	private BigDecimal precioUnitario;
	private String descripcion;
	private String fabricante;
	private String categoria;
	private long unidadesEnStock;
	private long unidadesEnPedido;
	private boolean disponible;
	private String condiciones;

	// cosntructores

	public Producto(String idProducto, String nombre, BigDecimal precioUnitario) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precioUnitario = precioUnitario;
	}

	public Producto() {
	}

	// getters y setters
	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecionUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public long getUnidadesEnStock() {
		return unidadesEnStock;
	}

	public void setUnidadesEnStock(long unidadesEnStock) {
		this.unidadesEnStock = unidadesEnStock;
	}

	public long getUnidadesEnPedido() {
		return unidadesEnPedido;
	}

	public void setUnidadesEnPedido(long unidadesEnPedido) {
		this.unidadesEnPedido = unidadesEnPedido;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(String condiciones) {
		this.condiciones = condiciones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((condiciones == null) ? 0 : condiciones.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + (disponible ? 1231 : 1237);
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + ((idProducto == null) ? 0 : idProducto.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precioUnitario == null) ? 0 : precioUnitario.hashCode());
		result = prime * result + (int) (unidadesEnPedido ^ (unidadesEnPedido >>> 32));
		result = prime * result + (int) (unidadesEnStock ^ (unidadesEnStock >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (condiciones == null) {
			if (other.condiciones != null)
				return false;
		} else if (!condiciones.equals(other.condiciones))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (disponible != other.disponible)
			return false;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (idProducto == null) {
			if (other.idProducto != null)
				return false;
		} else if (!idProducto.equals(other.idProducto))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precioUnitario == null) {
			if (other.precioUnitario != null)
				return false;
		} else if (!precioUnitario.equals(other.precioUnitario))
			return false;
		if (unidadesEnPedido != other.unidadesEnPedido)
			return false;
		if (unidadesEnStock != other.unidadesEnStock)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", precioUnitario=" + precioUnitario
				+ ", descripcion=" + descripcion + ", fabricante=" + fabricante + ", categoria=" + categoria
				+ ", unidadesEnStock=" + unidadesEnStock + ", unidadesEnPedido=" + unidadesEnPedido + ", disponible="
				+ disponible + ", condiciones=" + condiciones + "]";
	}

	

	

}
