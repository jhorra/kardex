
package com.kardex.exceptions;

import javax.ejb.ApplicationException;

/**
 * Clase Class EntidadNoGrabadaException.
 */
@ApplicationException(rollback = true)
public class EntidadNoGrabadaException extends Exception {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia un nuevo entidad no grabada exception.
	 */
	public EntidadNoGrabadaException() {
		super();
	}

	/**
	 * Instancia un nuevo entidad no grabada exception.
	 *
	 * @param arg0  arg0
	 * @param arg1  arg1
	 */
	public EntidadNoGrabadaException(final String arg0, final Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * Instancia un nuevo entidad no grabada exception.
	 *
	 * @param arg0  arg0
	 */
	public EntidadNoGrabadaException(final String arg0) {
		super(arg0);
	}

	/**
	 * Instancia un nuevo entidad no grabada exception.
	 *
	 * @param arg0  arg0
	 */
	public EntidadNoGrabadaException(final Throwable arg0) {
		super(arg0);
	}
}