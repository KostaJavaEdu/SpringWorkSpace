package sample09;

import org.springframework.beans.factory.annotation.Required;

public class EmpDTO {
	private int empno;
	private String ename;
	private String job;
	
	public EmpDTO() {}
	
	public int getEmpno() {
		return empno;
	}
	@Required //필수요소 설정됨
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
}
