
package com.kardex.negocio.bo.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kardex.persistencia.dao.impl.UsuarioRolDao;
import com.kardex.persistencia.entidades.UsuarioRol;

/**
 * The Class UsuarioRolServicio.
 */
@Stateless
public class UsuarioRolServicio {

	/** The Constant log. */
	protected static final Logger log = LoggerFactory.getLogger(EmpresaServicio.class);

	/** The usuario rol dao. */
	@EJB
	private UsuarioRolDao usuarioRolDao;

	/**
	 * Insertar usuario rol.
	 *
	 * @param usuarioRol the usuario rol
	 * @throws Exception the exception
	 */
	public void insertarUsuarioRol(UsuarioRol usuarioRol) throws Exception {
		log.info("Insercion de " + usuarioRol.getRol() + " " + usuarioRol.getUsuario());
		usuarioRolDao.insertar(usuarioRol);
	}

	/**
	 * Eliminar usuario rol.
	 *
	 * @param usuarioRol the usuario rol
	 * @throws Exception the exception
	 */
	public void eliminarUsuarioRol(UsuarioRol usuarioRol) throws Exception {
		log.info("Elimiinacion de " + usuarioRol.getRol() + " " + usuarioRol.getUsuario());
		usuarioRolDao.eliminar(usuarioRol);
	}

	/**
	 * Actualizar usuario rol.
	 *
	 * @param usuarioRol the usuario rol
	 * @throws Exception the exception
	 */
	public void actualizarUsuarioRol(UsuarioRol usuarioRol) throws Exception {
		log.info("Actualizacion de " + usuarioRol.getRol() + " " + usuarioRol.getUsuario());
		usuarioRolDao.actualizar(usuarioRol);
	}

	/**
	 * Buscar todos las marcas.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<UsuarioRol> buscarTodosLasMarcas() throws Exception {
		log.info("Buscar todas los roles de usuario ");
		return usuarioRolDao.buscarTodos();
	}

	/**
	 * Buscar marcas por parametros.
	 *
	 * @param parameteros the parameteros
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<UsuarioRol> buscarMarcasPorParametros(Map<String, Object> parameteros) throws Exception {
		log.info("Buscar roles de usuario por parametros ");
		return usuarioRolDao.buscarPorParametros(parameteros);
	}
}
