import Departamentos.Departamento;
import Departamentos.DepartamentoDAO;
import Departamentos.DepartamentoImpl;

public class Main {
	public static void main (String[] args) {
		
		DepartamentoDAO dao = new DepartamentoImpl();
		Departamento dept = new Departamento(1, "Informática", "Barcelona");
		dao.InsertarDep(dept);
		System.out.println("Departamento insertado");
		
		Departamento dep = dao.ConsultarDep(dept.getDeptno());
		System.out.println("Departamento: "+dep.getDeptno()+ " "+dep.getDnombre()+ " "+dep.getLoc());
		
		dept.setLoc("Valencia");
		dao.ModificarDep(dept.getDeptno(), dept);
		System.out.println("Departamento modificado");
		
		dep = dao.ConsultarDep(dept.getDeptno());
		System.out.println("Departamento: "+dep.getDeptno()+ " "+dep.getDnombre()+ " "+dep.getLoc());
		
		dao.EliminarDep(dept.getDeptno());
		System.out.println("Departamento eliminado");
		
	}
}