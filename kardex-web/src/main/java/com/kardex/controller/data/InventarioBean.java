package com.kardex.controller.data;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.kardex.persistencia.entidades.Inventario;

/**
 * The Class InventarioBean.
 */
@ManagedBean
@ViewScoped
public class InventarioBean implements Cloneable, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2909030587461033087L;

	/** The inventario. */
	private Inventario inventario;

	/** The producto id. */
	private Long productoId;

	/** The sucursal id. */
	private Long sucursalId;

	/** The total. */
	private BigDecimal total;

	/**
	 * Gets the inventario.
	 *
	 * @return the inventario
	 */
	public Inventario getInventario() {
		return inventario;
	}

	/**
	 * Sets the inventario.
	 *
	 * @param inventario the new inventario
	 */
	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	/**
	 * Gets the producto id.
	 *
	 * @return the producto id
	 */
	public Long getProductoId() {
		return productoId;
	}

	/**
	 * Sets the producto id.
	 *
	 * @param productoId the new producto id
	 */
	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	/**
	 * Gets the sucursal id.
	 *
	 * @return the sucursal id
	 */
	public Long getSucursalId() {
		return sucursalId;
	}

	/**
	 * Sets the sucursal id.
	 *
	 * @param sucursalId the new sucursal id
	 */
	public void setSucursalId(Long sucursalId) {
		this.sucursalId = sucursalId;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}