
package com.kardex.negocio.bo.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kardex.persistencia.dao.impl.MarcaDao;
import com.kardex.persistencia.entidades.Marca;

/**
 * The Class MarcaServicio.
 */
@Stateless
public class MarcaServicio {

	/** The Constant log. */
	protected static final Logger log = LoggerFactory.getLogger(EmpresaServicio.class);


	/** The marca dao. */
	@EJB
	private MarcaDao marcaDao;

	/**
	 * Insertar marca.
	 *
	 * @param marca the marca
	 * @throws Exception the exception
	 */
	public void insertarMarca(Marca marca) throws Exception {
		log.info("Insercion de " + marca.getNombre());
		marcaDao.insertar(marca);
	}

	/**
	 * Eliminar marca.
	 *
	 * @param marca the marca
	 * @throws Exception the exception
	 */
	public void eliminarMarca(Marca marca) throws Exception {
		log.info("Elimiinacion de " + marca.getNombre());
		marcaDao.eliminar(marca);
	}

	/**
	 * Actualizar marca.
	 *
	 * @param marca the marca
	 * @throws Exception the exception
	 */
	public void actualizarMarca(Marca marca) throws Exception {
		log.info("Actualizacion de " + marca.getNombre());
		marcaDao.actualizar(marca);
	}

	/**
	 * Buscar todos las marcas.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Marca> buscarTodosLasMarcas() throws Exception {
		log.info("Buscar todas las marcas ");
		return marcaDao.buscarTodos();
	}

	/**
	 * Buscar marcas por parametros.
	 *
	 * @param parameteros the parameteros
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Marca> buscarMarcasPorParametros(Map<String, Object> parameteros) throws Exception {
		log.info("Buscar marcas por parametros ");
		return marcaDao.buscarPorParametros(parameteros);
	}
}
