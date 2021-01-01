package kosta.mvc.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

	//학번, 이름, 나이, 전화번호, 주소
	
	private String stno;
	private String stname;
	private int stage;
	private String stphone;
	private String staddr;
}
