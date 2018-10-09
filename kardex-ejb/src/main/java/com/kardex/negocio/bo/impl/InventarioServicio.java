
package com.kardex.negocio.bo.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kardex.persistencia.dao.impl.InventarioDao;
import com.kardex.persistencia.dao.impl.ProductoDao;
import com.kardex.persistencia.entidades.Inventario;
import com.kardex.persistencia.entidades.Producto;

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

	/** The producto dao. */
	@EJB
	private ProductoDao productoDao;

	/**
	 * Insertar inventario.
	 *
	 * @param inventario the inventario
	 * @throws Exception the exception
	 */
	public void insertarInventario(Inventario inventario) throws Exception {
		log.info("Insercion de " + inventario.getId().getProductoId() + " " + inventario.getCantidad() + " "
				+ inventario.getId().getSucursalId());
		validateCantidades(inventario);
		inventarioDao.insertar(inventario);
	}

	/**
	 * Validate cantidades.
	 *
	 * @param inventario the inventario
	 * @throws Exception the exception
	 */
	private void validateCantidades(Inventario inventario) throws Exception {
		Producto producto = productoDao.recuperar(inventario.getId().getProductoId());
		if (inventario.getCantidad() == null || inventario.getCantidadSaliente() == null) {
			throw new Exception("Cantidades no permitidas");
		}
		if (inventario.getCantidadSaliente() != null
				&& inventario.getCantidadSaliente().compareTo(inventario.getCantidad()) > 0) {
			throw new Exception("Cantidad Saliente no puede ser mayor a la cantidad entrante");
		}
		BigDecimal cantidadtovalidate = inventario.getCantidad().subtract(inventario.getCantidadSaliente());
		if (cantidadtovalidate != null && cantidadtovalidate.compareTo(producto.getCantidad()) > 0) {
			throw new Exception("Cantidad no puede ser mayor al total del producto");
		}
		producto.setCantidad(cantidadtovalidate);
		productoDao.actualizar(producto);
	}

	/**
	 * Eliminar inventario.
	 *
	 * @param inventario the inventario
	 * @throws Exception the exception
	 */
	public void eliminarInventario(Inventario inventario) throws Exception {
		log.info("Insercion de " + inventario.getId().getProductoId() + " " + inventario.getCantidad() + " "
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
		log.info("Insercion de " + inventario.getId().getProductoId() + " " + inventario.getCantidad() + " "
				+ inventario.getId().getSucursalId());
		validateCantidades(inventario);
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
