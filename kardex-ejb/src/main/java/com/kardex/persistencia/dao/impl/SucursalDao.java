
package com.kardex.persistencia.dao.impl;

import javax.ejb.Stateless;

import com.kardex.persistencia.entidades.Sucursal;

/**
 * The Class SucursalDao.
 */
@Stateless
public class SucursalDao extends BaseDao<Sucursal,Long> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5939452970568412356L;

	/**
	 * Instantiates a new sucursal dao.
	 *
	 * @param type the type
	 */
	public SucursalDao() {
		super(Sucursal.class);
	}

}
