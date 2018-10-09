
package com.kardex.persistencia.dao.impl;

import javax.ejb.Stateless;

import com.kardex.persistencia.entidades.Usuario;

/**
 * The Class UsuarioDao.
 */
@Stateless
public class UsuarioDao extends BaseDao<Usuario> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3327424708495812515L;

	/**
	 * Instantiates a new usuario dao.
	 */
	public UsuarioDao() {
		super(Usuario.class);
	}

}
