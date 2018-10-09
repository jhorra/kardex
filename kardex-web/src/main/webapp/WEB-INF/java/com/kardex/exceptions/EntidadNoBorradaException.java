
package com.kardex.exceptions;

import javax.ejb.ApplicationException;

/**
 * Clase Class EntidadNoBorradaException.
 */
@ApplicationException(rollback = true)
public class EntidadNoBorradaException extends Exception {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia un nuevo entidad no borrada exception.
	 */
	public EntidadNoBorradaException() {
		super();
	}

	/**
	 * Instancia un nuevo entidad no borrada exception.
	 *
	 * @param arg0  arg0
	 * @param arg1  arg1
	 */
	public EntidadNoBorradaException(final String arg0, final Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Instancia un nuevo entidad no borrada exception.
	 *
	 * @param arg0  arg0
	 */
	public EntidadNoBorradaException(final String arg0) {
		super(arg0);
	}

	/**
	 * Instancia un nuevo entidad no borrada exception.
	 *
	 * @param arg0  arg0
	 */
	public EntidadNoBorradaException(final Throwable arg0) {
		super(arg0);
	}
}