package org.kosta.mvc.board.service;

import java.util.List;

import org.kosta.mvc.board.domain.Electronics;

public interface BoardService {
	/**
	  * 레코드 전체 검색
	  * */
	  List<Electronics> selectAll() ;
	  
	  /**
		  * 모델번호에 해당하는 레코드 검색
		  * @param: state true이면 조회수증가, false이면 조회증가안함.
		  * */
	  Electronics selectByModelNum(String modelNum , boolean state) ;
	  
	 
	/**
	 * 레코드 삽입
	 * */
	  int insert(Electronics electronics);
	  
	  /**
	   * 모델번호에 해당하는 레코드 삭제
	   * */
	   int delete(String modelNum, String password);
	  
	   /**
	    * 모델번호에 해당하는 레코드 수정
	    * */
	   int update(Electronics electronics);
}
