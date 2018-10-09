
package com.kardex.persistencia.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the ROL database table.
 * 
 */
@Entity
@Table(name = "rol")
public class Rol implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@SequenceGenerator(name = "ROL_SEQ_GEN", sequenceName = "ROL_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROL_SEQ_GEN")
	private Long id;

	/** The estado. */
	private String estado;

	/** The nombre. */
	private String nombre;

	/** The usuarios. */
	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy = "rols")
	private List<Usuario> usuarios;

	/**
	 * Instantiates a new rol.
	 */
	public Rol() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Sets the estado.
	 *
	 * @param estado the new estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the usuarios.
	 *
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	/**
	 * Sets the usuarios.
	 *
	 * @param usuarios the new usuarios
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}