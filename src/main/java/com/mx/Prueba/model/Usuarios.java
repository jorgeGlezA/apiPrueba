package com.mx.Prueba.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
CREATE TABLE USUARIO(
ID NUMBER PRIMARY KEY,
NOMBRE VARCHAR2 (100) NOT NULL,
PATERNO VARCHAR2 (100) NOT NULL,
MATERNO VARCHAR2 (50),
FECHA_NACIMIENTO DATE NOT NULL,
GENERO VARCHAR2 (100) NOT NULL,
CURP VARCHAR2 (100) NOT NULL,
RFC VARCHAR2 (50) NOT NULL
);
 */

@Entity
@Table(name="USUARIO")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuarios {


	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "PATERNO")
	private String app;
	
	@Column(name = "MATERNO")
	private String apm;
	
	@Column(name = "FECHA_NACIMIENTO")
	private Date fecha;
	
	@Column(name = "GENERO")
	private String genero;
	
	@Column(name = "CURP")
	private String curp;
	
	@Column(name = "RFC")
	private String rfc;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL) //mappedBy -- Define el lado de referencia, el lado de propiedad
	@JsonIgnore  
	List<Direccion> lista = new ArrayList<>();
}
