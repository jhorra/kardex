package com.kardex.controller.data;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.kardex.persistencia.entidades.Producto;

/**
 * The Class ProductoBean.
 */
@ManagedBean
@ViewScoped
public class ProductoBean implements Cloneable, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2909030587461033087L;

	/** The producto. */
	private Producto producto;

	/** The marca id. */
	private Long marcaId;

	/** The tipo producto id. */
	private Long tipoProductoId;

	/**
	 * Gets the producto.
	 *
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * Gets the marca id.
	 *
	 * @return the marca id
	 */
	public Long getMarcaId() {
		return marcaId;
	}

	/**
	 * Sets the marca id.
	 *
	 * @param marcaId the new marca id
	 */
	public void setMarcaId(Long marcaId) {
		this.marcaId = marcaId;
	}

	/**
	 * Gets the tipo producto id.
	 *
	 * @return the tipo producto id
	 */
	public Long getTipoProductoId() {
		return tipoProductoId;
	}

	/**
	 * Sets the tipo producto id.
	 *
	 * @param tipoProductoId the new tipo producto id
	 */
	public void setTipoProductoId(Long tipoProductoId) {
		this.tipoProductoId = tipoProductoId;
	}

	/**
	 * Sets the producto.
	 *
	 * @param producto the new producto
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}