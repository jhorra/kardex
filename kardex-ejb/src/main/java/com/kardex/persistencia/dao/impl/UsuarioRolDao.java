
package com.kardex.persistencia.dao.impl;

import javax.ejb.Stateless;

import com.kardex.persistencia.entidades.UsuarioRol;

/**
 * The Class UsuarioRolDao.
 */
@Stateless
public class UsuarioRolDao extends BaseDao<UsuarioRol,Long> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9181964070860346228L;

	/**
	 * Instantiates a new usuariorol dao.
	 *
	 * @param type the type
	 */
	public UsuarioRolDao() {
		super(UsuarioRol.class);
	}

}
