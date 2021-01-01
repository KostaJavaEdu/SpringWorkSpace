package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.mvc.dto.StudentDTO;
import kosta.mvc.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@PostMapping("/select")
	public List<StudentDTO> student(){
		List<StudentDTO> list = studentService.studentSelect();
		return list;
	}
	
	@RequestMapping("/insert")
	public int insert(StudentDTO student) {
		return studentService.insert(student);
	}
	
	@RequestMapping("/delete")
	public int delete(String stno) {
		return studentService.delete(stno);
	}
	
	@PostMapping(value = "/noCheck", produces = {"text/html;charset=UTF-8"})
	public String noCheck(String stno) {
		String result =  studentService.noCheck(stno);
		if(result!=null)  return "사용가능한 no입니다.";
		else return "중복입니다. 다른 no를 입력해주세요";
	}
}
