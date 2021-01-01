package kosta.web.mvc.service;

import java.util.List;

import kosta.web.mvc.domain.Board;

public interface BoardService{
	
	/**
	 * 등록
	 * */
	void insert(Board board);
	
	/**
	 * 전체검색
	 * */
	List<Board> selectAll();
	
	
	/**
	 * 상세보기(조회수 증가 시키기)
	 * */
	Board selectByNo(long id, boolean state);
	
	/**
	 * 수정하기
	 * */
	void update(Board board);
	
	/**
	 * 삭제하기
	 * */
	void delete(Board board);
}
