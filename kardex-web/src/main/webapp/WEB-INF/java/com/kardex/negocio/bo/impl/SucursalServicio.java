
package com.kardex.negocio.bo.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kardex.persistencia.dao.impl.SucursalDao;
import com.kardex.persistencia.entidades.Sucursal;

/**
 * The Class SucursalServicio.
 */
@Stateless
public class SucursalServicio {

	/** The Constant log. */
	protected static final Logger log = LoggerFactory.getLogger(EmpresaServicio.class);

	/** The sucursal dao. */
	@EJB
	private SucursalDao sucursalDao;

	/**
	 * Insertar sucursal.
	 *
	 * @param sucursal the sucursal
	 * @throws Exception the exception
	 */
	public void insertarSucursal(Sucursal sucursal) throws Exception {
		log.info("Insercion de " + sucursal.getNombre());
		sucursalDao.insertar(sucursal);
	}

	/**
	 * Eliminar sucursal.
	 *
	 * @param sucursal the sucursal
	 * @throws Exception the exception
	 */
	public void eliminarSucursal(Sucursal sucursal) throws Exception {
		log.info("Elimiinacion de " + sucursal.getNombre());
		sucursalDao.eliminar(sucursal);
	}

	/**
	 * Actualizar sucursal.
	 *
	 * @param sucursal the sucursal
	 * @throws Exception the exception
	 */
	public void actualizarSucursal(Sucursal sucursal) throws Exception {
		log.info("Actualizacion de " + sucursal.getNombre());
		sucursalDao.actualizar(sucursal);
	}

	/**
	 * Buscar todos las marcas.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Sucursal> buscarTodosLasSucursales() throws Exception {
		log.info("Buscar todas las sucursales ");
		return sucursalDao.buscarTodos();
	}

	/**
	 * Buscar marcas por parametros.
	 *
	 * @param parameteros the parameteros
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Sucursal> buscarSucursalesPorParametros(Map<String, Object> parameteros) throws Exception {
		log.info("Buscar sucursales por parametros ");
		return sucursalDao.buscarPorParametros(parameteros);
	}
}
