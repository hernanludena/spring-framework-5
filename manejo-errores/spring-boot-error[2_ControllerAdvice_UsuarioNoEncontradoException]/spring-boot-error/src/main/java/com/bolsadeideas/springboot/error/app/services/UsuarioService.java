package com.bolsadeideas.springboot.error.app.services;

import java.util.List;
import java.util.Optional;

import com.bolsadeideas.springboot.error.app.models.domain.Usuario;

public interface UsuarioService {
	
	public List<Usuario> listar();
	public Usuario obtenerPorId(Integer id);
	
	//Metodo usando el API Optional de java 8
	public Optional<Usuario> obtenerPorIdOptional(Integer id);

}
