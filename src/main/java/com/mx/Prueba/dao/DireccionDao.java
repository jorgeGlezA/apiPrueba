package com.mx.Prueba.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Prueba.model.Direccion;

public interface DireccionDao extends JpaRepository<Direccion, Long> {

}
