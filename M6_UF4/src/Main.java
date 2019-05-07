import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    	BaseDatos db = new BaseDatos();
    	System.out.println("Introduce un identificador de producto: ");
    	String inputId = read.readLine();
    	int identificador = Integer.parseInt(inputId);
    	System.out.println("Introduce una cantidad: ");
    	String inputCantidad = read.readLine();
    	int cantidad = Integer.parseInt(inputCantidad);
    	Producto producto = db.getProducto(identificador);
    	if(producto == null) {
    		System.out.println("EL PRODUCTO NO SE ENCUENTRA EN LA BASE DE DATOS.");
    	} else {
            int max = db.getMaxIdVenta() + 1;
        	java.util.Date fecha_actual = new Date();
        	Venta venta = new Venta(max, producto,fecha_actual,cantidad,"");
            Pedido pedido = new Pedido(producto, db);
            producto.addPropertyChangeListener(pedido);
            producto.addPropertyChangeListener(venta);        	
        	producto.setStockactual(producto.getStockactual()-cantidad);

            
        	db.insertarVenta(venta);

    	}
         
        VerProductos.verProductos(db);
        db.cerrarBD();
    }
}
