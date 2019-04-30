import java.beans.*;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;

import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("serial")
public class Pedido implements Serializable, PropertyChangeListener {     
    private int numeroPedido;
    private Producto producto;
    private Date fecha;
    private int cantidad;
    private BaseDatos db;
    public Pedido(Producto producto, BaseDatos db) {
    	this.producto = producto;
        this.db = db;
    }
    public Pedido (int numeroPedido, Producto producto, Date fecha, int cantitad) {
            this.numeroPedido = numeroPedido;
            this.producto = producto;
            this.fecha = fecha;
            this.cantidad = cantitad;

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    	int max = db.getMaxIdPedido() + 1;
    	java.util.Date fecha_actual = new Date();
    	int nueva_cantidad = (int) evt.getNewValue() - (int) evt.getOldValue();
    	Pedido p1 = new Pedido(max, this.producto,fecha_actual, nueva_cantidad);
    	db.insertarPedido(p1);
    	
     }
	public int getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
