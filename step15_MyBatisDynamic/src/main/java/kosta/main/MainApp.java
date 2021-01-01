package kosta.main;

import java.util.ArrayList;
import java.util.List;

import kosta.domain.EmpDTO;
import kosta.repository.EmpDAO;

public class MainApp {
	public static void main(String[] args) {
		/**
		 * 1. if문 test(<set>,<trim>)
		 * */
		
		//EmpDAO.ifTest(new EmpDTO()); //전체검색
		//EmpDAO.ifTest(new EmpDTO(0, "수녕", null, 0, null));
		//EmpDAO.ifTest(new EmpDTO(0, null, "학생", 0, null));
		
		/**
		 * 2. setTest(<set>,<trim>)
		 * */
		//EmpDAO.setTest(new EmpDTO(1235, "메롱", null, 0, null));
		//EmpDAO.setTest(new EmpDTO(1235, "최수녕", "요리사", 0, null));
		//EmpDAO.setTest(new EmpDTO(1235, "최수녕", "대통령", 60000, null));
		
		/**
		 * 3. forEachTest
		 * */
		List<Integer> list = new ArrayList<Integer>();
		list.add(81);
		list.add(1234);
		list.add(1235);
		EmpDAO.forEachTest(list);
		
	}
}
