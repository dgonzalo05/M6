import java.math.BigDecimal;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;
public class BaseDatos {

	private ODB odb;
	
	public BaseDatos() {
		this.odb = ODBFactory.open("Producto_Ped.DB");
	}
	public  Objects<Producto> getProductos() {
		return odb.getObjects(Producto.class);
	}
	public Objects<Pedido> getPedidos() {
		return odb.getObjects(Pedido.class);
	}
	public Objects<Venta> getVentas() {
		return odb.getObjects(Venta.class);
	}
	public Producto getProducto(int idProducto) {
		ICriterion criterio = Where.equal("idproducto", idProducto);
		CriteriaQuery query = new CriteriaQuery (Producto.class,criterio);
		Objects<Producto> productos = odb.getObjects(query);
		if (productos.hasNext()) {
			return productos.getFirst();
		}
		return null;
	}
	public int getMaxIdPedido() {
		Values val = odb.getValues(new ValuesCriteriaQuery(Pedido.class).max("numeroPedido"));
		return ((BigDecimal)val.next().getByAlias("numeroPedido")).intValue();
	}
	public void insertarProducto(Producto producto) {
		odb.store(producto);
	}
	public void insertarPedido(Pedido pedido) {
		odb.store(pedido);
	}
	public void insertarVenta(Venta venta) {
		odb.store(venta);
	}
	public void cerrarBD() {
		this.odb.close();
	}
}
