import java.util.Date;

public class Prueba {
    public static void main(String[] args) {    	
    	BaseDatos db = new BaseDatos();
    	VerProductos.verProductos(db);
    	Producto producto = new Producto(20, "Producto 20", 10, 8, 220);
    	db.insertarProducto(producto);
        Pedido pedido = new Pedido(producto, db);
        int max = db.getMaxIdVenta() + 1;
    	java.util.Date fecha_actual = new Date();
    	int cantidadVenta = 5;
    	Venta venta = new Venta(max, producto,fecha_actual,cantidadVenta,"");
        producto.addPropertyChangeListener (pedido);
        producto.addPropertyChangeListener (venta);
    	db.insertarVenta(venta);
    	producto.setStockactual(producto.getStockactual()-cantidadVenta);
        
        
        VerProductos.verProductos(db);
        db.cerrarBD();
    }
}


