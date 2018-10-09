
package com.kardex.persistencia.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * The persistent class for the INVENTARIO database table.
 * 
 */
@Entity

@Table(name = "inventario")
public class Inventario implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@EmbeddedId
	private InventarioPK id;

	/** The cantidad. */
	@NotNull(message = "Cantidad es requerido")
	private BigDecimal cantidad;

	/** The cantidad saliente. */
	@NotNull(message = "Cantidad saliente es requerido")
	@Column(name = "CANTIDAD_SALIENTE")
	private BigDecimal cantidadSaliente;

	/** The producto. */
	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name = "PRODUCTO_ID", insertable = false, updatable = false)
	private Producto producto;

	/** The sucursal. */
	//bi-directional many-to-one association to Sucursal
	@ManyToOne
	@JoinColumn(name = "SUCURSAL_ID", insertable = false, updatable = false)
	private Sucursal sucursal;

	/**
	 * Instantiates a new inventario.
	 */
	public Inventario() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public InventarioPK getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(InventarioPK id) {
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
	 * Gets the producto.
	 *
	 * @return the producto
	 */
	public Producto getProducto() {
		return this.producto;
	}

	/**
	 * Sets the producto.
	 *
	 * @param producto the new producto
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * Gets the sucursal.
	 *
	 * @return the sucursal
	 */
	public Sucursal getSucursal() {
		return this.sucursal;
	}

	/**
	 * Sets the sucursal.
	 *
	 * @param sucursal the new sucursal
	 */
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Gets the cantidad saliente.
	 *
	 * @return the cantidad saliente
	 */
	public BigDecimal getCantidadSaliente() {
		return cantidadSaliente;
	}

	/**
	 * Sets the cantidad saliente.
	 *
	 * @param cantidadSaliente the new cantidad saliente
	 */
	public void setCantidadSaliente(BigDecimal cantidadSaliente) {
		this.cantidadSaliente = cantidadSaliente;
	}

}