
package com.kardex.negocio.bo.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kardex.persistencia.dao.impl.ProductoDao;
import com.kardex.persistencia.entidades.Producto;

/**
 * The Class ProductoServicio.
 */
@Stateless
public class ProductoServicio {

	/** The Constant log. */
	protected static final Logger log = LoggerFactory.getLogger(ProductoServicio.class);

	/** The producto dao. */
	@EJB
	private ProductoDao productoDao;

	/**
	 * Insertar producto.
	 *
	 * @param producto the producto
	 * @throws Exception the exception
	 */
	public void insertarProducto(Producto producto) throws Exception {
		log.info("Insercion de " + producto.getNombre());
		productoDao.insertar(producto);
	}

	/**
	 * Eliminar producto.
	 *
	 * @param producto the producto
	 * @throws Exception the exception
	 */
	public void eliminarProducto(Producto producto) throws Exception {
		log.info("Elimiinacion de " + producto.getNombre());
		productoDao.eliminar(producto);
	}

	/**
	 * Actualizar producto.
	 *
	 * @param producto the producto
	 * @throws Exception the exception
	 */
	public void actualizarProducto(Producto producto) throws Exception {
		log.info("Actualizacion de " + producto.getNombre());
		productoDao.actualizar(producto);
	}

	/**
	 * Buscar todos los productos.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Producto> buscarTodosLosProductos() throws Exception {
		log.info("Buscar todos los productos ");
		return productoDao.buscarTodos();
	}

	/**
	 * Buscar productos por parametros.
	 *
	 * @param parameteros the parameteros
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Producto> buscarProductosPorParametros(Map<String, Object> parameteros) throws Exception {
		log.info("Buscar productos por parametros ");
		return productoDao.buscarPorParametros(parameteros);
	}

}
