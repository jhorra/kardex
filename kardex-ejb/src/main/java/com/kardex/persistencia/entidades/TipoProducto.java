
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
 * The persistent class for the TIPO_PRODUCTO database table.
 * 
 */
@Entity
@Table(name = "tipo_producto")
public class TipoProducto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@SequenceGenerator(name = "TIPOPRODUCTO_SEQ_GEN", sequenceName = "TIPOPRODUCTO_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPOPRODUCTO_SEQ_GEN")
	private Long id;

	/** The estado. */
	private String estado;

	/** The nombre. */
	private String nombre;

	/** The productos. */
	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy = "tipoProducto")
	private List<Producto> productos;

	/**
	 * Instantiates a new tipo producto.
	 */
	public TipoProducto() {
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
	 * Gets the productos.
	 *
	 * @return the productos
	 */
	public List<Producto> getProductos() {
		return this.productos;
	}

	/**
	 * Sets the productos.
	 *
	 * @param productos the new productos
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	/**
	 * Adds the producto.
	 *
	 * @param producto the producto
	 * @return the producto
	 */
	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setTipoProducto(this);

		return producto;
	}

	/**
	 * Removes the producto.
	 *
	 * @param producto the producto
	 * @return the producto
	 */
	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setTipoProducto(null);

		return producto;
	}

}