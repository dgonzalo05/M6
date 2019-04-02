package Ejercicio_JB1;

import java.beans.*;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Empleado implements Serializable {

	private String NIF;
	private String nombre;
	private String cargo;
	private int sueldo;
	
	private VetoableChangeSupport vetoSupport;
	
	public Empleado () {
		vetoSupport = new VetoableChangeSupport (this);
		this.cargo = "Junior";
		this.sueldo = 1000;
    }
	
	public Empleado (String NIF, String nombre) {
		this();
		vetoSupport = new VetoableChangeSupport(this);
		this.NIF = NIF;
		this.nombre = nombre;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {		
		if (cargo != null && !cargo.equals(""))
		{
			try {
				vetoSupport.fireVetoableChange("cargo", this.cargo, cargo);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.cargo = cargo;
		}
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		if (sueldo > 0) {
			try {
				vetoSupport.fireVetoableChange("sueldo", this.sueldo, sueldo);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.sueldo = sueldo;
		}
	}

	public VetoableChangeSupport getVetoableSupport() {
		return vetoSupport;
	}

	public void addVetoableSupport(VetoableChangeListener listener) {
		this.vetoSupport.addVetoableChangeListener(listener);
	}
	public void removeVetoableSupport(VetoableChangeListener listener) {
		this.vetoSupport.removeVetoableChangeListener(listener);
	}	
}
