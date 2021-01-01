package org.kosta.mvc.board.service;

import java.util.List;

import org.kosta.mvc.board.domain.Electronics;

public interface BoardService {
	/**
	  * ���ڵ� ��ü �˻�
	  * */
	  List<Electronics> selectAll() ;
	  
	  /**
		  * �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻�
		  * @param: state true�̸� ��ȸ������, false�̸� ��ȸ��������.
		  * */
	  Electronics selectByModelNum(String modelNum , boolean state) ;
	  
	 
	/**
	 * ���ڵ� ����
	 * */
	  int insert(Electronics electronics);
	  
	  /**
	   * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	   * */
	   int delete(String modelNum, String password);
	  
	   /**
	    * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	    * */
	   int update(Electronics electronics);
}
