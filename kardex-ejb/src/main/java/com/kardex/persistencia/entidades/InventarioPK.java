
package com.kardex.persistencia.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the INVENTARIO database table.
 * 
 */
@Embeddable
public class InventarioPK implements Serializable {

	/** The Constant serialVersionUID. */
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	/** The sucursal id. */
	@Column(name = "SUCURSAL_ID", insertable = false, updatable = false)
	private long sucursalId;

	/** The producto id. */
	@Column(name = "PRODUCTO_ID", insertable = false, updatable = false)
	private long productoId;

	/**
	 * Instantiates a new inventario PK.
	 */
	public InventarioPK() {
	}

	/**
	 * Gets the sucursal id.
	 *
	 * @return the sucursal id
	 */
	public long getSucursalId() {
		return this.sucursalId;
	}

	/**
	 * Sets the sucursal id.
	 *
	 * @param sucursalId the new sucursal id
	 */
	public void setSucursalId(long sucursalId) {
		this.sucursalId = sucursalId;
	}

	/**
	 * Gets the producto id.
	 *
	 * @return the producto id
	 */
	public long getProductoId() {
		return this.productoId;
	}

	/**
	 * Sets the producto id.
	 *
	 * @param productoId the new producto id
	 */
	public void setProductoId(long productoId) {
		this.productoId = productoId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InventarioPK)) {
			return false;
		}
		InventarioPK castOther = (InventarioPK) other;
		return (this.sucursalId == castOther.sucursalId) && (this.productoId == castOther.productoId);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.sucursalId ^ (this.sucursalId >>> 32)));
		hash = hash * prime + ((int) (this.productoId ^ (this.productoId >>> 32)));

		return hash;
	}
}