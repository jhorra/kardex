
package com.kardex.negocio.bo.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kardex.persistencia.dao.impl.RolDao;
import com.kardex.persistencia.entidades.Rol;

/**
 * The Class RolServicio.
 */
@Stateless
public class RolServicio {

	/** The Constant log. */
	protected static final Logger log = LoggerFactory.getLogger(EmpresaServicio.class);


	/** The rol dao. */
	@EJB
	private RolDao rolDao;

	/**
	 * Insertar rol.
	 *
	 * @param rol the rol
	 * @throws Exception the exception
	 */
	public void insertarRol(Rol rol) throws Exception {
		log.info("Insercion de " + rol.getNombre());
		rolDao.insertar(rol);
	}

	/**
	 * Eliminar rol.
	 *
	 * @param rol the rol
	 * @throws Exception the exception
	 */
	public void eliminarRol(Rol rol) throws Exception {
		log.info("Elimiinacion de " + rol.getNombre());
		rolDao.eliminar(rol);
	}

	/**
	 * Actualizar rol.
	 *
	 * @param rol the rol
	 * @throws Exception the exception
	 */
	public void actualizarRol(Rol rol) throws Exception {
		log.info("Actualizacion de " + rol.getNombre());
		rolDao.actualizar(rol);
	}

	/**
	 * Buscar todos los roles.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Rol> buscarTodosLosRoles() throws Exception {
		log.info("Buscar todos los roles ");
		return rolDao.buscarTodos();
	}

	/**
	 * Buscar roles por parametros.
	 *
	 * @param parameteros the parameteros
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Rol> buscarRolesPorParametros(Map<String, Object> parameteros) throws Exception {
		log.info("Buscar roles por parametros ");
		return rolDao.buscarPorParametros(parameteros);
	}

}
