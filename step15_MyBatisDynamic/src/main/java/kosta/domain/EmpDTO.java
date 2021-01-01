package kosta.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmpDTO {
	//empno, ename, job, sal, hiredate
	
	
	private int empno;
	private String ename;
	private String job;
	private int sal;
	private String hiredate;
	
	
}
