import java.beans.*;
import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("serial")
public class Venta implements Serializable, PropertyChangeListener {     
    private int numeroVenta;
    private Producto Idproducto;
    private Date fechaVenta;
    private int cantidad;
    private String observaciones;
    public Venta() { }
    public Venta (int numeroVenta, Producto Idproducto, Date fechaVenta, int cantitad, String observaciones) {
            this.numeroVenta = numeroVenta;
            this.Idproducto = Idproducto ;
            this.fechaVenta = fechaVenta;
            this.cantidad = cantitad;
            this.observaciones = observaciones;
    }
   
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    	
     }
	public int getNumeroVenta() {
		return numeroVenta;
	}
	public void setNumeroVenta(int numeroVenta) {
		this.numeroVenta = numeroVenta;
	}
	public Producto getIdproducto() {
		return Idproducto;
	}
	public void setIdproducto(Producto idproducto) {
		Idproducto = idproducto;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
