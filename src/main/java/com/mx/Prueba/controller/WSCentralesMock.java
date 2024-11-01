package com.mx.Prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Prueba.model.Direccion;
import com.mx.Prueba.model.Usuarios;
import com.mx.Prueba.service.Implementacion;

@RestController
@RequestMapping("WSCentralesMock/api/v1")
@CrossOrigin
public class WSCentralesMock {

	@Autowired
	Implementacion imp;

	// http://localhost:9000/WSCentralesMock/api/v1/listar
	@GetMapping("listar")
	public List<Usuarios> listar() {
		return imp.listar();
	}

	// http://localhost:9000/WSCentralesMock/api/v1/listar2
	@GetMapping("listar2")
	public List<Direccion> listar2() {
		return imp.listar2();
	}
	
	//  http://localhost:9000/WSCentralesMock/api/v1/usuarios
	@PostMapping(path = "/usuarios")
	public ResponseEntity<?> guardar(@RequestBody Direccion direccion) {
		String mensaje = imp.guardarDireccion(direccion);
		
		if (mensaje.equals("ExisteId")) {
			return new ResponseEntity<>("Ese ID de direccion ya existe, no se puede guardar", HttpStatus.OK);
		} else if (mensaje.equals("idUsuNoExiste")) {
			return new ResponseEntity<>("Error, ese usuario no existe", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(direccion, HttpStatus.CREATED);
		}
	}
	
	
	// http://localhost:9000/WSCentralesMock/api/v1/usuarios/1
	@GetMapping(path = "/usuarios/{idDireccion}")
	public Direccion buscar(@PathVariable("idDireccion") Long idDireccion) {
		return imp.buscar(idDireccion);
	}
	
	// http://localhost:9000/WSCentralesMock/api/v1/usuario/editar
	 @PostMapping("/usuario/editar")
	 public ResponseEntity<?> editar (@RequestBody Direccion direccion){
		 String mensaje = imp.editar(direccion);
		 
		 if (mensaje.equals("idUsuarioNoExiste")) {
			 return new ResponseEntity<>("Error, no existe ID_USUARIO", HttpStatus.OK);
		 } else if (mensaje.equals("idDireccionNoExiste")) {
			 return new ResponseEntity<>("Error, no existe ID_DIRECCION", HttpStatus.OK);
		 } else {
			 return new ResponseEntity<>(direccion, HttpStatus.CREATED);
		 }
	 }
	 
	 // http://localhost:9000/WSCentralesMock/api/v1/usuarios/2
	 @DeleteMapping("/usuarios/{idDireccion}")
	 public ResponseEntity<String> eliminar (@PathVariable("idDireccion") Long id){
		 boolean bandera = imp.eliminar(id);
		 
		 if (bandera == false)
			 return new ResponseEntity<>("No existe el id a eliminar", HttpStatus.OK);
		 else 
			 return new ResponseEntity<>("Se elimino con exito", HttpStatus.OK);
	 }

}
