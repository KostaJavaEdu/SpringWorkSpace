package kosta.main;

import java.util.ArrayList;
import java.util.List;

import kosta.domain.CommentbDTO;
import kosta.repository.EmpDAO;

public class MainApp {
	public static void main(String[] args) {
		/**
		 * 1 : 1인 경우
		 * */
		//EmpDAO.associationTest();
		
		/**
		 * 1 : 다인 경우
		 * */
		//EmpDAO.collectionTest();
		
		/**
		 * 캐맬 & 언더스코어
		 * */
		//EmpDAO.test();
		
		/**
		 * insert 물음표에 값 안들어 올 때 
		 * */
		EmpDAO.insert(new CommentbDTO(10, "kim", null, null, null, null));
	}
}
