
package com.kardex.persistencia.entidades;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@SequenceGenerator(name = "USUARIO_SEQ_GEN", sequenceName = "USUARIO_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ_GEN")
	private Long id;

	/** The apellido. */
	private String apellido;

	/** The contrasena. */
	private String contrasena;

	/** The estado. */
	private String estado;

	/** The fecha creacion. */
	@Column(name = "FECHA_CREACION")
	private Timestamp fechaCreacion;

	/** The fecha expiracion. */
	@Column(name = "FECHA_EXPIRACION")
	private Timestamp fechaExpiracion;

	/** The nombre. */
	private String nombre;

	/** The usuario. */
	private String usuario;

	/** The rols. */
	//bi-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(name = "USUARIO_ROL", joinColumns = { @JoinColumn(name = "USUARIO_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROL_ID") })
	private List<Rol> rols;

	/**
	 * Instantiates a new usuario.
	 */
	public Usuario() {
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
	 * Gets the apellido.
	 *
	 * @return the apellido
	 */
	public String getApellido() {
		return this.apellido;
	}

	/**
	 * Sets the apellido.
	 *
	 * @param apellido the new apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Gets the contrasena.
	 *
	 * @return the contrasena
	 */
	public String getContrasena() {
		return this.contrasena;
	}

	/**
	 * Sets the contrasena.
	 *
	 * @param contrasena the new contrasena
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
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
	 * Gets the fecha creacion.
	 *
	 * @return the fecha creacion
	 */
	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	/**
	 * Sets the fecha creacion.
	 *
	 * @param fechaCreacion the new fecha creacion
	 */
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Gets the fecha expiracion.
	 *
	 * @return the fecha expiracion
	 */
	public Timestamp getFechaExpiracion() {
		return this.fechaExpiracion;
	}

	/**
	 * Sets the fecha expiracion.
	 *
	 * @param fechaExpiracion the new fecha expiracion
	 */
	public void setFechaExpiracion(Timestamp fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
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
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	public String getUsuario() {
		return this.usuario;
	}

	/**
	 * Sets the usuario.
	 *
	 * @param usuario the new usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Gets the rols.
	 *
	 * @return the rols
	 */
	public List<Rol> getRols() {
		return this.rols;
	}

	/**
	 * Sets the rols.
	 *
	 * @param rols the new rols
	 */
	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

}