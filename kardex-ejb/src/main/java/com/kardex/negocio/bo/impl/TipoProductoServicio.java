
package com.kardex.negocio.bo.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kardex.persistencia.dao.impl.TipoProductoDao;
import com.kardex.persistencia.entidades.TipoProducto;

/**
 * The Class TipoProductoServicio.
 */
@Stateless
public class TipoProductoServicio {

	/** The Constant log. */
	protected static final Logger log = LoggerFactory.getLogger(EmpresaServicio.class);


	/** The tipo producto dao. */
	@EJB
	private TipoProductoDao tipoProductoDao;

	/**
	 * Insertar tipo producto.
	 *
	 * @param tipoProducto the tipo producto
	 * @throws Exception the exception
	 */
	public void insertarTipoProducto(TipoProducto tipoProducto) throws Exception {
		log.info("Insercion de " + tipoProducto.getNombre());
		tipoProductoDao.insertar(tipoProducto);
	}

	/**
	 * Eliminar tipo producto.
	 *
	 * @param tipoProducto the tipo producto
	 * @throws Exception the exception
	 */
	public void eliminarTipoProducto(TipoProducto tipoProducto) throws Exception {
		log.info("Elimiinacion de " + tipoProducto.getNombre());
		tipoProductoDao.eliminar(tipoProducto);
	}

	/**
	 * Actualizar tipo producto.
	 *
	 * @param tipoProducto the tipo producto
	 * @throws Exception the exception
	 */
	public void actualizarTipoProducto(TipoProducto tipoProducto) throws Exception {
		log.info("Actualizacion de " + tipoProducto.getNombre());
		tipoProductoDao.actualizar(tipoProducto);
	}

	/**
	 * Buscar todos los tipos productos.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<TipoProducto> buscarTodosLosTiposProductos() throws Exception {
		log.info("Buscar todos los tipos de productos ");
		return tipoProductoDao.buscarTodos();
	}

	/**
	 * Buscar tipos productos por parametros.
	 *
	 * @param parameteros the parameteros
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<TipoProducto> buscarTiposProductosPorParametros(Map<String, Object> parameteros) throws Exception {
		log.info("Buscar tipos de productos por parametros ");
		return tipoProductoDao.buscarPorParametros(parameteros);
	}
}
