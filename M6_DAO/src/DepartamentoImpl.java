import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class DepartamentoImpl implements DepartamentoDAO{

	public static ODB bd;
	
	public DepartamentoImpl() {
		bd = ODBFactory.open("Departamento.DB");
	}
	@Override
	public boolean InsertarDep(Departamento dep) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean EliminarDep(int deptno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ModificarDep(int deptno, Departamento dep) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Departamento ConsultarDep(int deptno) {
		// TODO Auto-generated method stub
		return null;
	}

}
