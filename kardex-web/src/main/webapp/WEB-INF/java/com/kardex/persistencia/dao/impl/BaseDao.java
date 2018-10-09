
package com.kardex.persistencia.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.kardex.exceptions.EntidadNoBorradaException;
import com.kardex.exceptions.EntidadNoEncontradaException;
import com.kardex.exceptions.EntidadNoGrabadaException;

/**
 * The Class BaseRepository.
 *
 * @param <T> the generic type
 */
@SuppressWarnings("unchecked")
public abstract class BaseDao<T extends Object> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8351725879372745619L;

	/** The em. */
	@PersistenceContext(unitName = "kardexPU")
	protected EntityManager em;

	/** type. */
	private Class<T> type;

	/**
	 * Instancia un nuevo generic dao impl.
	 *
	 * @param type type
	 */
	public BaseDao(Class<T> type) {
		this.type = type;
	}

	/**
	 * Find ALL.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<T> buscarTodos() throws Exception {
		return obtenerConsulta().getResultList();
	}

	/**
	 * Find by criterias.
	 *
	 * @param parameteros the parameters
	 * @return the list
	 * @throws EntidadNoEncontradaException the entidad no encontrada exception
	 */
	public List<T> buscarPorParametros(Map<String, Object> parameteros) throws EntidadNoEncontradaException {
		Query query = obtenerConsulta();
		for (Entry<String, Object> entry : parameteros.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}

	/**
	 * Creates the.
	 *
	 * @param o the o
	 * @throws EntidadNoGrabadaException the entidad no grabada exception
	 */
	public void insertar(T o) throws EntidadNoGrabadaException {
		em.persist(o);
	}

	/**
	 * Update.
	 *
	 * @param o the o
	 * @throws EntidadNoGrabadaException the entidad no grabada exception
	 */
	public void actualizar(T o) throws EntidadNoGrabadaException {
		em.merge(o);
	}

	/**
	 * Delete.
	 *
	 * @param o the o
	 * @throws EntidadNoBorradaException the entidad no borrada exception
	 */
	public void eliminar(T o) throws EntidadNoBorradaException {
		em.remove(em.merge(o));
	}

	/**
	 * Gets the query.
	 *
	 * @return the query
	 */
	private Query obtenerConsulta() {
		StringBuffer sql = new StringBuffer();
		sql.append("from ").append(type.getSimpleName()).append(" order by 1,2");
		return em.createQuery(sql.toString());
	}
}
