package Ejercicio_JB1;

import java.beans.*;
import java.io.Serializable;
import java.util.Arrays;

@SuppressWarnings("serial")
public class PanelEmpleado implements Serializable, VetoableChangeListener{

	private int limiteVariacionSueldo;
	private String[] listaDeCargos = { "Junior", "SemiSenior", "Analista", "CEO" };

	public PanelEmpleado() {
		this.limiteVariacionSueldo = 10;
	}
	
	public PanelEmpleado(int limiteVariacionSueldo) {
		if (limiteVariacionSueldo > 10 && limiteVariacionSueldo < 50) {
			this.limiteVariacionSueldo = limiteVariacionSueldo;
		}
	}

	public String[] getListaDeCargos() {
		return listaDeCargos;
	}

	public void setListaDeCargos(String[] listaDeCargos) {
		this.listaDeCargos = listaDeCargos;
	}

	public int getLimiteVariacionSueldo() {
		return limiteVariacionSueldo;
	}

	public void setLimiteVariacionSueldo(int limiteVariacionSueldo) {
		this.limiteVariacionSueldo = limiteVariacionSueldo;
	}

	@Override
	public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
		if (evt.getPropertyName().equals("cargo")) {
			if (!Arrays.stream(this.listaDeCargos).anyMatch(evt.getNewValue()::equals)) {
				throw new PropertyVetoException("el cargo no está en la lista ",evt);
			}
		}
		if (evt.getPropertyName().equals("sueldo")) {
			int variacion = Math.abs((int) evt.getNewValue() - (int) evt.getOldValue());
			float porcentaje = variacion / (float) (int) evt.getOldValue() * 100;
			if (porcentaje > this.limiteVariacionSueldo) {
				throw new PropertyVetoException("variación del sueldo demasiado alta ",evt);

			}
			
		}
	}
}
