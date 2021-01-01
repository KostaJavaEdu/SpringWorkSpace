package kosta.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpDTO {

	private int empno;
	private String ename;
	private int deptno;
	private String job;
	private int sal;
	
	private DeptDTO deptDTO;
}
