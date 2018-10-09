
package com.kardex.persistencia.dao.impl;

import javax.ejb.Stateless;

import com.kardex.persistencia.entidades.Producto;

/**
 * The Class ProductoDao.
 */
@Stateless
public class ProductoDao extends BaseDao<Producto,Long> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5131314393837732172L;

	/**
	 * Instantiates a new producto dao.
	 *
	 * @param type the type
	 */
	public ProductoDao() {
		super(Producto.class);
	}

}
