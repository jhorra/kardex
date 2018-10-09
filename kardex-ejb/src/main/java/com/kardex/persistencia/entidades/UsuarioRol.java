
package com.kardex.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the USUARIO_ROL database table.
 * 
 */
@Entity
@Table(name = "usuario_rol")
public class UsuarioRol implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@SequenceGenerator(name = "ROL_SEQ_GEN", sequenceName = "ROL_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROL_SEQ_GEN")
	private Long id;

	/** The rol. */
	//bi-directional many-to-one association to Rol
	@ManyToOne
	private Rol rol;

	/** The usuario. */
	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	/**
	 * Instantiates a new usuario rol.
	 */
	public UsuarioRol() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the rol.
	 *
	 * @return the rol
	 */
	public Rol getRol() {
		return this.rol;
	}

	/**
	 * Sets the rol.
	 *
	 * @param rol the new rol
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * Sets the usuario.
	 *
	 * @param usuario the new usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}