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
public class SalgradeDTO {
	private int grade;
	private int losal;
	private int hisal;
	
	private List<EmpDTO> empList;

	public SalgradeDTO(int grade) {
		super();
		this.grade = grade;
	}
	
	
}
