import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.util.Set;
import java.util.Iterator;
import primero.*;

public class HibernateIV_2 {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory (
				new StandardServiceRegistryBuilder().configure().build() ) ;
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		
		Depart dep = new Depart();
		Emple emp = new Emple();
		try {
			dep = session.load(Depart.class, 30);
		} catch ( ObjectNotFoundException o ) {
			System.out.println("El departamento no existe");
		}
		try {
			emp = session.load(Emple.class, 7369);
		} catch ( ObjectNotFoundException o ) {
			System.out.println("El empleado no existe");
		}
		
		emp.setSalario(emp.getSalario() + 1000);
		emp.setDepart(dep);
		
		session.update(emp);
		tx.commit();
		session.close();
		System.exit(0);
	}
}