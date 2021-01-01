package kosta.domain;

public class EmpDTO {
	//empno, ename, job, sal, hiredate
	
	private int empno;
	private String name; //디비에서는 ename임 일부러 이름 다르게 해봄 
	private String job;
	private int sal;
	private String hiredate;
	
	public EmpDTO() {}
	
	public EmpDTO(int empno, String name, String job, int sal, String hiredate) {
		super();
		this.empno = empno;
		this.name = name;
		this.job = job;
		this.sal = sal;
		this.hiredate = hiredate;
	}
	

	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "EmpDTO [empno=" + empno + ", name=" + name + ", job=" + job + ", sal=" + sal + ", hiredate=" + hiredate
				+ "] \n";
	}
	
	
}
