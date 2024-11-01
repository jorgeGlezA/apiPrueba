package com.mx.Prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Prueba.dao.DireccionDao;
import com.mx.Prueba.dao.UsuariosDao;
import com.mx.Prueba.model.Direccion;
import com.mx.Prueba.model.Usuarios;

@Service
public class Implementacion {

	@Autowired
	UsuariosDao usuarioDao;

	@Autowired
	DireccionDao direcDao;

	public List<Usuarios> listar() {
		return usuarioDao.findAll();
	}

	public List<Direccion> listar2() {
		return direcDao.findAll();
	}

	public Direccion buscar(Long ID) {
		return direcDao.findById(ID).orElse(null);
	}

	public String guardarDireccion(Direccion direccion) {
		String mensaje = "";
		boolean banderaUsu = false;
		boolean banderaDirec = false;

		for (Usuarios u : usuarioDao.findAll()) {
			if (u.getId().equals(direccion.getUsuario().getId())) {
				banderaUsu = true;

				for (Direccion d : direcDao.findAll()) {
					if (d.getId().equals(direccion.getId())) {
						mensaje = "ExisteId";
						banderaDirec = true;
						break;
					}
				}
				break;
			}
		}
		
		if (banderaUsu == false) {
			mensaje = "idUsuNoExiste";
			banderaDirec = true;
		} else {
			direcDao.save(direccion);
		}
		
		return mensaje;
	}

	public String editar(Direccion direccion) {
		String mensaje = "";
		boolean banderaUsu = false;
		boolean banderaDirec = false;

		for (Usuarios u : usuarioDao.findAll()) {
			if (u.getId().equals(direccion.getUsuario().getId())) {
				banderaUsu = true;

				for (Direccion d : direcDao.findAll()) {
					if (d.getId().equals(direccion.getId())) {
						direcDao.save(direccion);
						banderaDirec = true;
						break;
					}
				}
				break;
			}
		}

		if (banderaUsu == false)
			mensaje = "idUsuarioNoExiste";
		else if (banderaDirec == false)
			mensaje = "idDireccionNoExiste";

		return mensaje;
	}

	public boolean eliminar(Long id) {
		boolean bandera = false;
		for (Direccion d : direcDao.findAll()) {
			if (d.getId().equals(id)) {
				bandera = true;
				break;
			}
		}
		if (bandera == true)
			direcDao.deleteById(id);
		return bandera;
	}

}
