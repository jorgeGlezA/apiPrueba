package com.mx.Prueba.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
CREATE TABLE DIRECCION (
ID NUMBER PRIMARY KEY,
CALLE VARCHAR2 (100) NOT NULL,
NUM_INT NUMBER NOT NULL,
NUM_EXT NUMBER,
COLONIA VARCHAR2 (100) NOT NULL,
CP VARCHAR2 (100) NOT NULL,
MUNICIPIO VARCHAR2 (100) NOT NULL,
ESTADO VARCHAR2 (100) NOT NULL,
PAIS VARCHAR2 (100) NOT NULL,
ID_USUARIO NUMBER NOT NULL,
FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID)
);
 */

@Entity
@Table(name = "DIRECCION")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Direccion {
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "CALLE")
	private String calle;
	
	@Column(name = "NUM_INT")
	private Integer numeroInt;
	
	@Column(name = "NUM_EXT")
	private Integer numeroExt;
	
	@Column(name = "COLONIA")
	private String colonia;
	
	@Column(name = "CP")
	private String cp;
	
	@Column(name = "MUNICIPIO")
	private String municipio;
	
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "PAIS")
	private String pais;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USUARIO")
	Usuarios usuario;
}
