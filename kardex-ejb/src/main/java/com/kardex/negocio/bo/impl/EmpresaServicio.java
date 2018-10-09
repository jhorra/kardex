
package com.kardex.negocio.bo.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kardex.persistencia.dao.impl.EmpresaDao;
import com.kardex.persistencia.entidades.Empresa;

/**
 * The Class EmpresaServicio.
 */
@Stateless
public class EmpresaServicio {

	/** The Constant log. */
	protected static final Logger log = LoggerFactory.getLogger(EmpresaServicio.class);


	/** The empresa dao. */
	@EJB
	private EmpresaDao empresaDao;

	/**
	 * Insertar empresa.
	 *
	 * @param empresa the empresa
	 * @throws Exception the exception
	 */
	public void insertarEmpresa(Empresa empresa) throws Exception {
		log.info("Insercion de " + empresa.getNombre());
		empresaDao.insertar(empresa);
	}

	/**
	 * Eliminar empresa.
	 *
	 * @param empresa the empresa
	 * @throws Exception the exception
	 */
	public void eliminarEmpresa(Empresa empresa) throws Exception {
		log.info("Elimiinacion de " + empresa.getNombre());
		empresaDao.eliminar(empresa);
	}

	/**
	 * Actualizar empresa.
	 *
	 * @param empresa the empresa
	 * @throws Exception the exception
	 */
	public void actualizarEmpresa(Empresa empresa) throws Exception {
		log.info("Actualizacion de " + empresa.getNombre());
		empresaDao.actualizar(empresa);
	}

	/**
	 * Buscar todas las empresa.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Empresa> buscarTodasLasEmpresa() throws Exception {
		log.info("Buscar todas las empresas ");
		return empresaDao.buscarTodos();
	}

	/**
	 * Buscar empresas por parametros.
	 *
	 * @param parameteros the parameteros
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Empresa> buscarEmpresasPorParametros(Map<String, Object> parameteros) throws Exception {
		log.info("Buscar empresas por parametros ");
		return empresaDao.buscarPorParametros(parameteros);
	}
}
