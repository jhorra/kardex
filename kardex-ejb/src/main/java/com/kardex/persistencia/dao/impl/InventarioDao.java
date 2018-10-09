
package com.kardex.persistencia.dao.impl;

import javax.ejb.Stateless;

import com.kardex.persistencia.entidades.Inventario;
import com.kardex.persistencia.entidades.InventarioPK;

/**
 * The Class InventarioDao.
 */
@Stateless
public class InventarioDao extends BaseDao<Inventario,InventarioPK> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1443598858124340359L;

	/**
	 * Instantiates a new inventario dao.
	 *
	 * @param type the type
	 */
	public InventarioDao() {
		super(Inventario.class);
	}

}
