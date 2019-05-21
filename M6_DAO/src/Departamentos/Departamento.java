package Departamentos;
import java.io.Serializable;

public class Departamento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int deptno;
	private String dnombre;
	private String loc;
	
	public Departamento() {
	}
	
	public Departamento(int deptno, String dnombre, String loc) {
		this();
		this.deptno = deptno;
		this.dnombre = dnombre;
		this.loc = loc;
	}
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDnombre() {
		return dnombre;
	}
	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}

	
}
