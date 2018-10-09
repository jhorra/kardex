
package com.kardex.persistencia.dao.impl;

import javax.ejb.Stateless;

import com.kardex.persistencia.entidades.Inventario;

/**
 * The Class InventarioDao.
 */
@Stateless
public class InventarioDao extends BaseDao<Inventario> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1443598858124340359L;

	/**
	 * Instantiates a new inventario dao.
	 */
	public InventarioDao() {
		super(Inventario.class);
	}

}
