
package com.kardex.persistencia.dao.impl;

import javax.ejb.Stateless;

import com.kardex.persistencia.entidades.Empresa;

/**
 * The Class EmpresaDao.
 */
@Stateless
public class EmpresaDao extends BaseDao<Empresa> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4517019477776820877L;

	/**
	 * Instantiates a new empresa dao.
	 */
	public EmpresaDao() {
		super(Empresa.class);
	}
}