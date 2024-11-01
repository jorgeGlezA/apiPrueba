package com.mx.Prueba.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Prueba.model.Usuarios;

public interface UsuariosDao extends JpaRepository<Usuarios, Long> {

}
