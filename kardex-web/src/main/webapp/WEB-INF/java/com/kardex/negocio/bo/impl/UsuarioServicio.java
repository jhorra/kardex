
package com.kardex.negocio.bo.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kardex.persistencia.dao.impl.UsuarioDao;
import com.kardex.persistencia.entidades.Usuario;

/**
 * The Class UsuarioServicio.
 */
@Stateless
public class UsuarioServicio {

	/** The Constant log. */
	protected static final Logger log = LoggerFactory.getLogger(EmpresaServicio.class);

	/** The usuario dao. */
	@EJB
	private UsuarioDao usuarioDao;

	/**
	 * Insertar usuario.
	 *
	 * @param usuario the usuario
	 * @throws Exception the exception
	 */
	public void insertarUsuario(Usuario usuario) throws Exception {
		log.info("Insercion de " + usuario.getNombre());
		usuarioDao.insertar(usuario);
	}

	/**
	 * Eliminar usuario.
	 *
	 * @param usuario the usuario
	 * @throws Exception the exception
	 */
	public void eliminarUsuario(Usuario usuario) throws Exception {
		log.info("Elimiinacion de " + usuario.getNombre());
		usuarioDao.eliminar(usuario);
	}

	/**
	 * Actualizar usuario.
	 *
	 * @param usuario the usuario
	 * @throws Exception the exception
	 */
	public void actualizarUsuario(Usuario usuario) throws Exception {
		log.info("Actualizacion de " + usuario.getNombre());
		usuarioDao.actualizar(usuario);
	}

	/**
	 * Buscar todos las marcas.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Usuario> buscarTodosLasMarcas() throws Exception {
		log.info("Buscar todos los usuarios ");
		return usuarioDao.buscarTodos();
	}

	/**
	 * Buscar marcas por parametros.
	 *
	 * @param parameteros the parameteros
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Usuario> buscarMarcasPorParametros(Map<String, Object> parameteros) throws Exception {
		log.info("Buscar usuarios por parametros ");
		return usuarioDao.buscarPorParametros(parameteros);
	}
}
