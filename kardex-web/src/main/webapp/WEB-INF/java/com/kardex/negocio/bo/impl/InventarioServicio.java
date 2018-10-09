
package com.kardex.negocio.bo.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kardex.persistencia.dao.impl.InventarioDao;
import com.kardex.persistencia.entidades.Inventario;

/**
 * The Class InventarioServicio.
 */
@Stateless
public class InventarioServicio {

	/** The Constant log. */
	protected static final Logger log = LoggerFactory.getLogger(EmpresaServicio.class);

	/** The inventario dao. */
	@EJB
	private InventarioDao inventarioDao;

	/**
	 * Insertar inventario.
	 *
	 * @param inventario the inventario
	 * @throws Exception the exception
	 */
	public void insertarInventario(Inventario inventario) throws Exception {
		log.info("Insercion de " + inventario.getId().getProductoId() + " " + inventario.getCantidad() + " "
				+ inventario.getId().getSucursalId());
		inventarioDao.insertar(inventario);
	}

	/**
	 * Eliminar inventario.
	 *
	 * @param inventario the inventario
	 * @throws Exception the exception
	 */
	public void eliminarInventario(Inventario inventario) throws Exception {
		log.info("Eliminacion de " + inventario.getId().getProductoId() + " " + inventario.getCantidad() + " "
				+ inventario.getId().getSucursalId());
		inventarioDao.eliminar(inventario);
	}

	/**
	 * Actualizar inventario.
	 *
	 * @param inventario the inventario
	 * @throws Exception the exception
	 */
	public void actualizarInventario(Inventario inventario) throws Exception {
		log.info("Actualizacion de " + inventario.getId().getProductoId() + " " + inventario.getCantidad() + " "
				+ inventario.getId().getSucursalId());
		inventarioDao.actualizar(inventario);
	}

	/**
	 * Buscar todos los inventarios.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Inventario> buscarTodosLosInventarios() throws Exception {
		log.info("Buscar todos los inventarios ");
		return inventarioDao.buscarTodos();
	}

	/**
	 * Buscar inventarios por parametros.
	 *
	 * @param parameteros the parameteros
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Inventario> buscarInventariosPorParametros(Map<String, Object> parameteros) throws Exception {
		log.info("Buscar inventarios por parametros ");
		return inventarioDao.buscarPorParametros(parameteros);
	}
}
