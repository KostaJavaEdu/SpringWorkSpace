package kosta.mvc.repository;

import java.util.List;

import kosta.mvc.dto.StudentDTO;

public interface StudentRepository {

	
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
	 * 아이디중복체크
	 * */
	String noCheck(String stno);
}
