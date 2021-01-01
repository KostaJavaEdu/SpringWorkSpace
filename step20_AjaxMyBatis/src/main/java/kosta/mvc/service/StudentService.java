package kosta.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kosta.mvc.dto.StudentDTO;
import kosta.mvc.repository.StudentRepository;


public interface StudentService {

	/**
	 * 리스트 조회
	 * */
	List<StudentDTO> studentSelect();
	
	/**
	 * 리스트 삽입
	 * */
	int insert(StudentDTO student);
	
	/**
	 * 삭제
	 * */
	int delete(String stno);
	
	/**
	 * 중복체크
	 * */
	String noCheck(String stno);
}
