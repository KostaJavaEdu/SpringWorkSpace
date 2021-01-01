package kosta.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EmpDTO {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private int sal;
	private int comm;
	private int deptno;

	private DeptDTO deptDTO;
	private SalgradeDTO salgradeDTO;

	public EmpDTO(int empno) {
		super();
		this.empno = empno;
	}

}
