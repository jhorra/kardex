
package com.kardex.controller.action;

import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.ActionSource;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class BaseController.
 */
public class BaseController {

	/** The Constant logger. */
	protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	/** The Constant SUSSESS_MESSAGE. */
	protected static final String SUSSESS_MESSAGE = "Transaccion exitosa";

	/** The activar insertar. */
	protected boolean activarInsertar;

	/** The activar actualizar. */
	protected boolean activarActualizar;

	/**
	 * Inits the base.
	 */
	protected void initBase() {
		this.activarInsertar = true;
		this.activarActualizar = false;
	}

	/**
	 * Actualizar boton.
	 */
	public void actualizarBoton() {
		this.activarInsertar = false;
		this.activarActualizar = true;
	}

	/**
	 * Procesar.
	 */
	public void procesar() {
		PrimeFaces.current().executeScript("PF('dialogEliminar').show();");
	}

	/**
	 * Adds the error message.
	 *
	 * @param summary the summary
	 * @param detail  the detail
	 */
	protected static void addErrorMessage(final String summary, final String detail) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
	}

	/**
	 * Adds the info message.
	 *
	 * @param summary the summary
	 * @param detail  the detail
	 */
	public static void addInfoMessage(final String summary, final String detail) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
	}

	/**
	 * Gets the external context.
	 *
	 * @return the external context
	 */
	protected ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}

	/**
	 * Gets the faces context.
	 *
	 * @return the faces context
	 */
	protected static FacesContext getFacesContext() {
		return (FacesContext.getCurrentInstance());
	}

	/**
	 * Obtener parametro session.
	 *
	 * @param key the key
	 * @return the object
	 */
	protected Object obtenerParametroSession(final String key) {
		return getExternalContext().getSessionMap().get(key);
	}

	/**
	 * Existe parametro session.
	 *
	 * @param key the key
	 * @return the boolean
	 */
	protected Boolean existeParametroSession(final String key) {
		return getExternalContext().getSessionMap().containsKey(key);
	}

	/**
	 * Checks if is existen errores.
	 *
	 * @return true, if is existen errores
	 */
	public boolean isExistenErrores() {
		return isExisteMensajes(FacesMessage.SEVERITY_ERROR);
	}

	/**
	 * Checks if is existen info mensajes.
	 *
	 * @return true, if is existen info mensajes
	 */
	public boolean isExistenInfoMensajes() {
		return isExisteMensajes(FacesMessage.SEVERITY_INFO);
	}

	/**
	 * Checks if is existe mensajes.
	 *
	 * @param severity the severity
	 * @return true, if is existe mensajes
	 */
	private boolean isExisteMensajes(FacesMessage.Severity severity) {
		if (FacesContext.getCurrentInstance().getMessages() != null) {
			for (Iterator<FacesMessage> iterator = FacesContext.getCurrentInstance().getMessages(); iterator
					.hasNext();) {
				FacesMessage fm = iterator.next();
				if (fm.getSeverity().equals(severity)) {
					return true;
				}

			}
		}
		return false;
	}

	/**
	 * Adds the message exception.
	 *
	 * @param e the e
	 */
	protected void addMessageException(Exception e) {
		addErrorMessage(e.getMessage(), "");
	}

	/**
	 * Adds the info message.
	 *
	 * @param message the message
	 */
	protected void addInfoMessage(String message) {
		addInfoMessage(message, message);
	}

	/**
	 * Gets the etiquetas resource.
	 *
	 * @param key the key
	 * @return the etiquetas resource
	 */
	protected String getEtiquetasResource(String key) {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			ResourceBundle bundle = context.getApplication().getResourceBundle(context, "etiquetas");
			if (bundle != null) {
				return bundle.getString(key);
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	/**
	 * Limpiar faces messages.
	 *
	 * @param facesContext the faces context
	 * @param clientId     the client id
	 */
	public void limpiarFacesMessages(FacesContext facesContext, String clientId) {
		Iterator<FacesMessage> facesMessages = facesContext.getMessages(clientId);
		while (facesMessages.hasNext()) {
			facesMessages.next();
			facesMessages.remove();
		}
	}

	/**
	 * Limpiar immediate faces messages.
	 *
	 * @param facesContext the faces context
	 */
	public void limpiarImmediateFacesMessages(FacesContext facesContext) {
		limpiarImmediateFacesMessages(facesContext, facesContext.getViewRoot());
	}

	/**
	 * Limpiar immediate faces messages.
	 *
	 * @param facesContext the faces context
	 * @param uIComponent  the u I component
	 */
	public void limpiarImmediateFacesMessages(FacesContext facesContext, UIComponent uIComponent) {
		if (uIComponent instanceof ActionSource) {
			ActionSource actionSource = (ActionSource) uIComponent;
			if (actionSource.isImmediate()) {
				limpiarFacesMessages(facesContext, uIComponent.getClientId(facesContext));
			}
		} else if (uIComponent instanceof EditableValueHolder) {
			EditableValueHolder editableValueHolder = (EditableValueHolder) uIComponent;
			if (editableValueHolder.isImmediate()) {
				limpiarFacesMessages(facesContext, uIComponent.getClientId(facesContext));
			}
		}
		List<UIComponent> childComponents = uIComponent.getChildren();
		for (UIComponent childComponent : childComponents) {
			limpiarImmediateFacesMessages(facesContext, childComponent);
		}
	}

	/**
	 * Checks if is activar insertar.
	 *
	 * @return true, if is activar insertar
	 */
	public boolean isActivarInsertar() {
		return activarInsertar;
	}

	/**
	 * Sets the activar insertar.
	 *
	 * @param activarInsertar the new activar insertar
	 */
	public void setActivarInsertar(boolean activarInsertar) {
		this.activarInsertar = activarInsertar;
	}

	/**
	 * Checks if is activar actualizar.
	 *
	 * @return true, if is activar actualizar
	 */
	public boolean isActivarActualizar() {
		return activarActualizar;
	}

	/**
	 * Sets the activar actualizar.
	 *
	 * @param activarActualizar the new activar actualizar
	 */
	public void setActivarActualizar(boolean activarActualizar) {
		this.activarActualizar = activarActualizar;
	}

}