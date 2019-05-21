package Departamentos;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class DepartamentoImpl implements DepartamentoDAO{

	public static ODB bd;
	
	public DepartamentoImpl() {
		bd = ODBFactory.open("Departamento.DB");
	}
	@Override
	public boolean InsertarDep(Departamento dep) {
		bd.store(dep);
		bd.commit();
		return true;
	}

	@Override
	public boolean EliminarDep(int deptno) {
		Departamento dep = ConsultarDep(deptno);
		if (dep == null) {
			return false;
		}
		bd.delete(dep);
		bd.commit();
		return true;
	}

	@Override
	public boolean ModificarDep(int deptno, Departamento dep) {
		Departamento dept = ConsultarDep(deptno);
		if(dept == null || dep == null) {
			return false;
		}
		dept.setDnombre(dep.getDnombre());
		dept.setLoc(dept.getLoc());
		bd.store(dept);
		bd.commit();
		return true;
	}

	@Override
	public Departamento ConsultarDep(int deptno) {
		ICriterion criterio = Where.equal("deptno", deptno);
		CriteriaQuery query = new CriteriaQuery(Departamento.class, criterio);
		Objects<Departamento> deps = bd.getObjects(query);
		if (deps.hasNext()) {
			return deps.getFirst();
		}
		return null;
	}

}
