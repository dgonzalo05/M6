
public class LlenarProductos {

	public static void main(String[] args) {
		Producto p1 = new Producto(1, "Duruss Cobalt", 10, 3, 220);
		Producto p2 = new Producto(2, "Varlion Avant Carbon", 5, 2, 176);
		Producto p3 = new Producto(3, "Star Vie Pyramid R50", 20, 5, 193);
		Producto p4 = new Producto(4, "Dunlop Titan", 8, 3, 85);
		Producto p5 = new Producto(5, "Vision King", 7, 1, 159);
		Producto p6 = new Producto(6, "Slazenger Reflex Pro", 5, 2, 80);
		
		BaseDatos db = new BaseDatos();
		
		db.insertarProducto(p1);
		db.insertarProducto(p2);
		db.insertarProducto(p3);
		db.insertarProducto(p4);
		db.insertarProducto(p5);
		db.insertarProducto(p6);
		db.cerrarBD();
	}

}
