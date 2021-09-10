package com.twt.curso.AccesoDatos;

import com.twt.curso.entidades.Usuario;

public interface DaoUsuario extends Dao<Usuario>{
	Usuario obtenerPorEmail(String email);
}
