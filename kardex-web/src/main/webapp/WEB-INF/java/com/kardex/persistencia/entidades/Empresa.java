
package com.kardex.persistencia.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the EMPRESA database table.
 * 
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@SequenceGenerator(name = "EMPRESA_SEQ_GEN", sequenceName = "EMPRESA_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPRESA_SEQ_GEN")
	private Long id;

	/** The estado. */
	private String estado;

	/** The nombre. */
	private String nombre;

	/** The sucursals. */
	//bi-directional many-to-one association to Sucursal
	@OneToMany(mappedBy = "empresa")
	private List<Sucursal> sucursals;

	/**
	 * Instantiates a new empresa.
	 */
	public Empresa() {
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
	 * Gets the sucursals.
	 *
	 * @return the sucursals
	 */
	public List<Sucursal> getSucursals() {
		return this.sucursals;
	}

	/**
	 * Sets the sucursals.
	 *
	 * @param sucursals the new sucursals
	 */
	public void setSucursals(List<Sucursal> sucursals) {
		this.sucursals = sucursals;
	}

	/**
	 * Adds the sucursal.
	 *
	 * @param sucursal the sucursal
	 * @return the sucursal
	 */
	public Sucursal addSucursal(Sucursal sucursal) {
		getSucursals().add(sucursal);
		sucursal.setEmpresa(this);

		return sucursal;
	}

	/**
	 * Removes the sucursal.
	 *
	 * @param sucursal the sucursal
	 * @return the sucursal
	 */
	public Sucursal removeSucursal(Sucursal sucursal) {
		getSucursals().remove(sucursal);
		sucursal.setEmpresa(null);

		return sucursal;
	}

}