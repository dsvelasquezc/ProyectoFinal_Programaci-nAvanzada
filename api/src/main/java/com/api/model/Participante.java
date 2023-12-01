package com.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DataBase$") // Asegúrate de que el nombre coincida con el nombre de tu tabla en la base de datos
public class Participante {

    public Participante(Long id, String nombre, Integer edad, String talla, String sede, String puntoDeSalida) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.talla = talla;
		this.sede = sede;
		this.puntoDeSalida = puntoDeSalida;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "talla")
    private String talla;

    @Column(name = "sede")
    private String sede;

    @Column(name = "punto_de_salida")
    private String puntoDeSalida;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getPuntoDeSalida() {
		return puntoDeSalida;
	}

	public void setPuntoDeSalida(String PuntoDeSalida) {
		this.puntoDeSalida = PuntoDeSalida;
	}
	
	public Participante() {
    }

 
}
