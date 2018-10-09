
package com.kardex.persistencia.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the SUCURSAL database table.
 * 
 */
@Entity
@Table(name = "sucursal")
public class Sucursal implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@SequenceGenerator(name = "SUCURSAL_SEQ_GEN", sequenceName = "SUCURSAL_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUCURSAL_SEQ_GEN")
	private Long id;

	/** The estado. */
	private String estado;

	/** The nombre. */
	private String nombre;

	/** The inventarios. */
	//bi-directional many-to-one association to Inventario
	@OneToMany(mappedBy = "sucursal")
	private List<Inventario> inventarios;

	/** The empresa. */
	//bi-directional many-to-one association to Empresa
	@ManyToOne
	private Empresa empresa;

	/**
	 * Instantiates a new sucursal.
	 */
	public Sucursal() {
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
	 * Gets the inventarios.
	 *
	 * @return the inventarios
	 */
	public List<Inventario> getInventarios() {
		return this.inventarios;
	}

	/**
	 * Sets the inventarios.
	 *
	 * @param inventarios the new inventarios
	 */
	public void setInventarios(List<Inventario> inventarios) {
		this.inventarios = inventarios;
	}

	/**
	 * Adds the inventario.
	 *
	 * @param inventario the inventario
	 * @return the inventario
	 */
	public Inventario addInventario(Inventario inventario) {
		getInventarios().add(inventario);
		inventario.setSucursal(this);

		return inventario;
	}

	/**
	 * Removes the inventario.
	 *
	 * @param inventario the inventario
	 * @return the inventario
	 */
	public Inventario removeInventario(Inventario inventario) {
		getInventarios().remove(inventario);
		inventario.setSucursal(null);

		return inventario;
	}

	/**
	 * Gets the empresa.
	 *
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return this.empresa;
	}

	/**
	 * Sets the empresa.
	 *
	 * @param empresa the new empresa
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}