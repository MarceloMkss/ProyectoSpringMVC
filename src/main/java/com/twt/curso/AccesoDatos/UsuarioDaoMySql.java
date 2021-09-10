package com.twt.curso.AccesoDatos;

import com.twt.curso.entidades.Usuario;



public class UsuarioDaoMySql implements DaoUsuario {

	private static final String SQL_EMAIL = "SELECT * FROM usuarios u LEFT JOIN clientes c ON u.clientes_id = c.id WHERE email = ?";

	@Override
	public Usuario obtenerPorEmail(String email) {
		
			
			Usuario usuario = null;
			return usuario;
			
			


	}

}
