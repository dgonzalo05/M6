import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.*;

import java.util.Date;

public class HibernateII {
	public static void main(String[] args) {
		//En primer lugar se obtiene la sesión creada por el Singleton.
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		//Abrimos sesión e iniciamos una transacción
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Inserto una fila en emple");
		//Creamos un nuevo objeto Depart y damos valor a sus atributos
		// Depart dep = new Depart();
		Date fecha = new Date();
		Emple emp = new Emple();
		emp.setEmpNo(7727);
		emp.setDepart(new Depart(10));
		emp.setApellido("GONZALO");
		emp.setOficio("PROGRAMADOR");
		emp.setDir(7698);
		emp.setFechaAlt(fecha);
		emp.setDir(7698);
		emp.setSalario(1364);
		//Guardamos en la base de datos y comprometemos la información
		session.save(emp);
		tx.commit();
		session.close();
		System.exit(0);
	}
}
