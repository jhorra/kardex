
package com.kardex.persistencia.dao.impl;

import javax.ejb.Stateless;

import com.kardex.persistencia.entidades.Rol;

/**
 * The Class RolDao.
 */
@Stateless
public class RolDao extends BaseDao<Rol> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7750756994418094459L;

	/**
	 * Instantiates a new rol dao.
	 */
	public RolDao() {
		super(Rol.class);
	}

}
