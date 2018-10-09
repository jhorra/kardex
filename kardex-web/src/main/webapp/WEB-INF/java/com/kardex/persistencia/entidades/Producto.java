
package com.kardex.persistencia.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * The persistent class for the PRODUCTO database table.
 * 
 */
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@SequenceGenerator(name = "PRODUCTO_SEQ_GEN", sequenceName = "PRODUCTO_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTO_SEQ_GEN")
	private Long id;

	/** The cantidad. */
	@NotNull(message = "Cantidad es requerido")
	private BigDecimal cantidad;

	/** The estado. */
	private String estado;

	/** The nombre. */
	@NotNull(message = "Nombre es requerido")
	private String nombre;

	/** The precio. */
	@NotNull(message = "Precio es requerido")
	private BigDecimal precio;

	/** The inventarios. */
	//bi-directional many-to-one association to Inventario
	@OneToMany(mappedBy = "producto")
	private List<Inventario> inventarios;

	/** The marca. */
	//bi-directional many-to-one association to Marca
	@ManyToOne
	private Marca marca;

	/** The tipo producto. */
	//bi-directional many-to-one association to TipoProducto
	@ManyToOne
	@JoinColumn(name = "TIPO_PRODUCTO_ID")
	private TipoProducto tipoProducto;

	/**
	 * Instantiates a new producto.
	 */
	public Producto() {
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
	 * Gets the cantidad.
	 *
	 * @return the cantidad
	 */
	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	/**
	 * Sets the cantidad.
	 *
	 * @param cantidad the new cantidad
	 */
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
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
	 * Gets the precio.
	 *
	 * @return the precio
	 */
	public BigDecimal getPrecio() {
		return this.precio;
	}

	/**
	 * Sets the precio.
	 *
	 * @param precio the new precio
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
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
		inventario.setProducto(this);

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
		inventario.setProducto(null);

		return inventario;
	}

	/**
	 * Gets the marca.
	 *
	 * @return the marca
	 */
	public Marca getMarca() {
		return this.marca;
	}

	/**
	 * Sets the marca.
	 *
	 * @param marca the new marca
	 */
	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	/**
	 * Gets the tipo producto.
	 *
	 * @return the tipo producto
	 */
	public TipoProducto getTipoProducto() {
		return this.tipoProducto;
	}

	/**
	 * Sets the tipo producto.
	 *
	 * @param tipoProducto the new tipo producto
	 */
	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

}