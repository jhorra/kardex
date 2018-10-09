
package com.kardex.controller.action;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.PrimeFaces;

import com.kardex.controller.data.InventarioBean;
import com.kardex.negocio.bo.impl.InventarioServicio;
import com.kardex.negocio.bo.impl.ProductoServicio;
import com.kardex.negocio.bo.impl.SucursalServicio;
import com.kardex.persistencia.entidades.Inventario;
import com.kardex.persistencia.entidades.InventarioPK;
import com.kardex.persistencia.entidades.Producto;
import com.kardex.persistencia.entidades.Sucursal;

/**
 * The Class InventarioAction.
 */
@ManagedBean
@ViewScoped
public class InventarioAction extends BaseController {

	/** The inventario bean. */
	private InventarioBean inventarioBean;

	/** The inventario servicio. */
	@EJB
	private InventarioServicio inventarioServicio;

	/** The producto servicio. */
	@EJB
	private ProductoServicio productoServicio;

	/** The sucursal servicio. */
	@EJB
	private SucursalServicio sucursalServicio;

	/**
	 * Inits the inventario bean.
	 *
	 * @throws Exception the exception
	 */
	@PostConstruct
	public void initInventarioBean() throws Exception {
		try {
			super.initBase();
			inventarioBean = new InventarioBean();
			inventarioBean.setInventario(new Inventario());
		} catch (Exception e) {
			addMessageException(e);
		}
	}

	/**
	 * Gets the inventarios.
	 *
	 * @return the inventarios
	 */
	public List<Inventario> getInventarios() {
		try {
			return inventarioServicio.buscarTodosLosInventarios();
		} catch (Exception e) {
			addMessageException(e);
		}
		return null;
	}

	/**
	 * Gets the productos.
	 *
	 * @return the productos
	 * @throws Exception the exception
	 */
	public List<Producto> getProductos() throws Exception {
		try {
			return productoServicio.buscarTodosLosProductos();
		} catch (Exception e) {
			addMessageException(e);
		}
		return null;
	}

	/**
	 * Gets the sucursales.
	 *
	 * @return the sucursales
	 * @throws Exception the exception
	 */
	public List<Sucursal> getSucursales() throws Exception {
		try {
			return sucursalServicio.buscarTodosLasSucursales();
		} catch (Exception e) {
			addMessageException(e);
		}
		return null;
	}

	/**
	 * Guardar.
	 */
	public void guardar() {
		try {
			this.complete();
			// creo producto
			inventarioServicio.insertarInventario(inventarioBean.getInventario());
			this.addInfoMessage(SUSSESS_MESSAGE);
			initInventarioBean();
		} catch (Exception e) {
			addMessageException(e);
		}
	}

	/**
	 * Eliminar.
	 */
	public void eliminar() {
		try {
			inventarioServicio.eliminarInventario(inventarioBean.getInventario());
			initInventarioBean();
			this.addInfoMessage(SUSSESS_MESSAGE);
			PrimeFaces.current().executeScript("PF('dialogEliminar').hide();");
		} catch (Exception e) {
			addMessageException(e);
		}
	}

	/**
	 * Actualizar.
	 */
	public void actualizar() {
		try {
			this.complete();
			inventarioServicio.actualizarInventario(inventarioBean.getInventario());
			initInventarioBean();
			this.addInfoMessage(SUSSESS_MESSAGE);
		} catch (Exception e) {
			addMessageException(e);
		}
	}

	/**
	 * Carga total.
	 *
	 * @param valueChangeEvent the value change event
	 */
	public void cargaTotal(ValueChangeEvent valueChangeEvent) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			this.limpiarImmediateFacesMessages(facesContext);
			UIViewRoot uIViewRoot = facesContext.getViewRoot();
			Long productoId = (Long) valueChangeEvent.getNewValue();

			Producto producto = this.productoServicio.buscarProductosById(productoId);

			if (producto != null) {
				UIInput provinciaInputText = (UIInput) uIViewRoot.findComponent("frm:total");
				provinciaInputText.setValue(producto.getCantidad());
				provinciaInputText.setSubmittedValue(producto.getCantidad());

				facesContext.renderResponse();
			}

		} catch (Exception e) {
			addMessageException(e);
		} finally {
			
		}
	}

	/**
	 * Complete.
	 */
	private void complete() {
		// asocio producto
		InventarioPK id = new InventarioPK();
		id.setProductoId(inventarioBean.getProductoId());
		id.setSucursalId(inventarioBean.getSucursalId());
		inventarioBean.getInventario().setId(id);
	}

	/**
	 * Gets the inventario bean.
	 *
	 * @return the inventario bean
	 */
	public InventarioBean getInventarioBean() {
		return inventarioBean;
	}

	/**
	 * Sets the inventario bean.
	 *
	 * @param inventarioBean the new inventario bean
	 */
	public void setInventarioBean(InventarioBean inventarioBean) {
		this.inventarioBean = inventarioBean;
	}

}