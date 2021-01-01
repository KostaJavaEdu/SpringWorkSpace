package kosta.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.dto.StudentDTO;
import kosta.mvc.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<StudentDTO> studentSelect() {
		List<StudentDTO> list = studentRepository.studentSelect();
		return list;
	}

	@Override
	public int insert(StudentDTO student) {
		int result = studentRepository.insert(student);
		
		return result;
	}

	@Override
	public int delete(String stno) {
		int result = studentRepository.delete(stno);
		return result;
	}

	@Override
	public String noCheck(String stno) {
		String result = studentRepository.noCheck(stno);
		return result;
	}

}
