import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class VerProductos {
	public static void verProductos(BaseDatos db) {
		// recuperamos todos los objetos
		// Objects<Producto> objects = db.getObjects(Producto.class);
		Objects<Producto> productos = db.getProductos();
		Objects<Pedido> pedidos = db.getPedidos();
		System.out.printf("%d Productos: %n", productos.size());
	
		while (productos.hasNext()) {
			// visualizar los objetos
			Producto producto = productos.next();
			System.out.printf("%d: %s, %d, %d %n", producto.getIdproducto(), producto.getDescripcion(), producto.getStockminimo(), producto.getStockactual());
		}
		System.out.printf("%d Pedidos: %n", pedidos.size());
		while (pedidos.hasNext()) {
			// visualizar los objetos
			Pedido pedido = pedidos.next();
			System.out.printf("%d: %s, %s, %d %n", pedido.getNumeroPedido(), pedido.getProducto().getDescripcion(),  pedido.getFecha(), pedido.getCantidad());
		}
	}
}
