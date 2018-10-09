
package com.kardex.persistencia.dao.impl;

import javax.ejb.Stateless;

import com.kardex.persistencia.entidades.Marca;

/**
 * The Class MarcaDao.
 */
@Stateless
public class MarcaDao extends BaseDao<Marca,Long> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -913654579315511838L;

	/**
	 * Instantiates a new marca dao.
	 *
	 * @param type the type
	 */
	public MarcaDao() {
		super(Marca.class);
	}
}
