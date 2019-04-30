
public class Prueba {
    public static void main(String[] args) {    	
    	BaseDatos db = new BaseDatos();
    	VerProductos.verProductos(db);
    	Producto producto = db.getProducto(2);
        Pedido pedido = new Pedido(producto, db);
        producto.addPropertyChangeListener (pedido);
        producto.setStockactual(1);
        VerProductos.verProductos(db);
        db.cerrarBD();
    }
}


