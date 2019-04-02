package Ejercicio_JB1;

public class PruebasFinales {
	  public static void main(String[] args) {
	      Empleado empleado= new Empleado();
	      PanelEmpleado panel =new PanelEmpleado();
	      
	      empleado.addVetoableSupport(panel);
	      empleado.setCargo("Junior");
	      empleado.setSueldo(900);
	  }
}