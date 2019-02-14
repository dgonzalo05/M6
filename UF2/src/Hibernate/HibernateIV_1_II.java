import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.util.Set;
import java.util.Iterator;
import primero.*;

public class HibernateIV_1_II {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory (
				new StandardServiceRegistryBuilder().configure().build() ) ;
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		
		Depart dep = new Depart();
		Emple emp;
		try {
			dep = session.load(Depart.class, 10);
		} catch ( ObjectNotFoundException o ) {
			System.out.println("El departamento no existe");
		}
		Set<Emple> listaemp = dep.getEmples();
		Iterator<Emple> it = listaemp.iterator();
		
		while(it.hasNext()) {
			emp = it.next();
			System.out.printf("Apellido: %s%n", emp.getApellido());
			System.out.printf("Salario: %s%n", emp.getSalario());
		}
		
		tx.commit();
		session.close();
		System.exit(0);
	}
}