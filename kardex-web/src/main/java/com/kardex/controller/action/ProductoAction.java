
package com.kardex.controller.action;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.PrimeFaces;

import com.kardex.controller.data.ProductoBean;
import com.kardex.negocio.bo.impl.MarcaServicio;
import com.kardex.negocio.bo.impl.ProductoServicio;
import com.kardex.negocio.bo.impl.TipoProductoServicio;
import com.kardex.persistencia.entidades.Marca;
import com.kardex.persistencia.entidades.Producto;
import com.kardex.persistencia.entidades.TipoProducto;

/**
 * The Class ProductoAction.
 */
@ManagedBean
@ViewScoped
public class ProductoAction extends BaseController {

	/** The producto bean. */
	private ProductoBean productoBean;

	/** The producto servicio. */
	@EJB
	private ProductoServicio productoServicio;

	/** The marca servicio. */
	@EJB
	private MarcaServicio marcaServicio;

	/** The tipo producto servicio. */
	@EJB
	private TipoProductoServicio tipoProductoServicio;

	/**
	 * Inits the producto bean.
	 *
	 * @throws Exception the exception
	 */
	@PostConstruct
	public void initProductoBean() throws Exception {
		try {
			super.initBase();
			productoBean = new ProductoBean();
			productoBean.setProducto(new Producto());
		} catch (Exception e) {
			addMessageException(e);
		}
	}

	/**
	 * Gets the marcas.
	 *
	 * @return the marcas
	 * @throws Exception the exception
	 */
	public List<Marca> getMarcas() throws Exception {
		try {
			return marcaServicio.buscarTodosLasMarcas();
		} catch (Exception e) {
			addMessageException(e);
		}
		return null;
	}

	/**
	 * Gets the tipo productos.
	 *
	 * @return the tipo productos
	 * @throws Exception the exception
	 */
	public List<TipoProducto> getTipoProductos() throws Exception {
		try {
			return tipoProductoServicio.buscarTodosLosTiposProductos();
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
			// asocio marca
			this.complete();
			// creo producto
			productoServicio.insertarProducto(productoBean.getProducto());
			this.addInfoMessage(SUSSESS_MESSAGE);
			initProductoBean();
		} catch (Exception e) {
			addMessageException(e);
		}
	}

	/**
	 * Complete.
	 */
	private void complete() {
		Marca marca = new Marca();
		marca.setId(productoBean.getMarcaId());
		productoBean.getProducto().setMarca(marca);
		// asocio tipo producto
		TipoProducto tipoProducto = new TipoProducto();
		tipoProducto.setId(productoBean.getTipoProductoId());
		productoBean.getProducto().setTipoProducto(tipoProducto);
	}

	/**
	 * Eliminar.
	 */
	public void eliminar() {
		try {
			productoServicio.eliminarProducto(productoBean.getProducto());
			initProductoBean();
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
			productoServicio.actualizarProducto(productoBean.getProducto());
			initProductoBean();
			this.addInfoMessage(SUSSESS_MESSAGE);
		} catch (Exception e) {
			addMessageException(e);
		}
	}

	/**
	 * Gets the productos.
	 *
	 * @return the productos
	 */
	public List<Producto> getProductos() {
		try {
			return productoServicio.buscarTodosLosProductos();
		} catch (Exception e) {
			addMessageException(e);
		}
		return null;
	}

	/**
	 * Gets the producto bean.
	 *
	 * @return the producto bean
	 */
	public ProductoBean getProductoBean() {
		return productoBean;
	}

	/**
	 * Sets the producto bean.
	 *
	 * @param productoBean the new producto bean
	 */
	public void setProductoBean(ProductoBean productoBean) {
		this.productoBean = productoBean;
	}

}