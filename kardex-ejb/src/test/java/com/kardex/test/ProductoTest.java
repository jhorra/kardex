
package com.kardex.test;

import java.math.BigDecimal;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.kardex.negocio.bo.impl.MarcaServicio;
import com.kardex.negocio.bo.impl.ProductoServicio;
import com.kardex.negocio.bo.impl.TipoProductoServicio;
import com.kardex.persistencia.entidades.Marca;
import com.kardex.persistencia.entidades.Producto;
import com.kardex.persistencia.entidades.TipoProducto;

/**
 * The Class ProductoTest.
 */
@RunWith(Arquillian.class)
public class ProductoTest {

	/**
	 * Creates the test archive.
	 *
	 * @return the archive
	 */
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackage("com.kardex.persistencia.entidades")
				.addPackage("com.kardex.persistencia.dao.impl").addPackage("com.kardex.negocio.bo.impl")
				.addPackage("com.kardex.exceptions")
				//				.addClasses(Producto.class, ProductoServicio.class, ProductoDao.class, EntidadNoBorradaException.class,
				//						EntidadNoGrabadaException.class, EntidadNoEncontradaException.class, Marca.class, BaseDao.class,
				//						EntityManager.class, TipoProducto.class, Inventario.class, InventarioPK.class)
				.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
		// Deploy our test datasource
		//				.addAsWebInfResource("test-ds.xml", "test-ds.xml")
		;
	}

	/** The producto servicio. */
	@EJB
	ProductoServicio productoServicio;

	/** The marca servicio. */
	@EJB
	MarcaServicio marcaServicio;

	/** The tipo producto servicio. */
	@EJB
	TipoProductoServicio tipoProductoServicio;

	/**
	 * Test register.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testRegister() throws Exception {
		Marca marca = new Marca();
		marca.setId(1l);
		
		TipoProducto tipoProducto = new TipoProducto();
		tipoProducto.setId(1l);
		
		Producto producto = new Producto();
		//producto.setId(1l);
		producto.setNombre("nombre");
		producto.setEstado("A");
		producto.setCantidad(BigDecimal.ONE);
		producto.setMarca(marca);
		producto.setTipoProducto(tipoProducto);

		productoServicio.insertarProducto(producto);

	}
}