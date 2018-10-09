
package com.kardex.exceptions;

import javax.ejb.ApplicationException;

/**
 * Clase Class EntidadNoEncontradaException.
 */
@ApplicationException(rollback = true)
public class EntidadNoEncontradaException extends Exception {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia un nuevo entidad no encontrada exception.
	 */
	public EntidadNoEncontradaException() {
		super();
	}

	/**
	 * Instancia un nuevo entidad no encontrada exception.
	 *
	 * @param arg0  arg0
	 * @param arg1  arg1
	 */
	public EntidadNoEncontradaException(final String arg0, final Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Instancia un nuevo entidad no encontrada exception.
	 *
	 * @param arg0  arg0
	 */
	public EntidadNoEncontradaException(final String arg0) {
		super(arg0);
	}

	/**
	 * Instancia un nuevo entidad no encontrada exception.
	 *
	 * @param arg0  arg0
	 */
	public EntidadNoEncontradaException(final Throwable arg0) {
		super(arg0);
	}
}