
package com.kardex.persistencia.dao.impl;

import javax.ejb.Stateless;

import com.kardex.persistencia.entidades.TipoProducto;

/**
 * The Class TipoProductoDao.
 */
@Stateless
public class TipoProductoDao extends BaseDao<TipoProducto,Long> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2226673674199460603L;

	/**
	 * Instantiates a new tipoproducto dao.
	 *
	 * @param type the type
	 */
	public TipoProductoDao() {
		super(TipoProducto.class);
	}

}
