package kosta.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DeptDTO {
	private int deptno;
	private String dname;
	private String loc;

	private List<EmpDTO> EmpList;

	public DeptDTO(int deptno) {
		super();
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "DeptDTO [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}

}
