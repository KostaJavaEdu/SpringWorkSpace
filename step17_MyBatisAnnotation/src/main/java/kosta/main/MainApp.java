package kosta.main;

import kosta.domain.EmpDTO;
import kosta.repository.EmpDAO;

public class MainApp {
	public static void main(String[] args) {
		
		
		/**
		 * 5. 전체검색
		 * */
		//EmpDAO.selectAll();
		
		/**
		 * 사원번호에 대한 검색
		 * */
		//EmpDAO.selectByEmpno(9595);
		
		/**
		 * 2. 등록하기
		 * */
		
		//EmpDAO.insert(new EmpDTO(92, "효정", "아시아", 300, null));
		
		/**
		 * 3. 삭제하기
		 * */
		//EmpDAO.delete(92);
		
		
		/**
		 * 4. 수정하기
		 * */
		//EmpDAO.update(new EmpDTO(1234, "효정", "병원", 0, null));
		
		
		/**
		 * 동적쿼리
		 * */
		//EmpDAO.ifTest(new EmpDTO()); //전체검색
		//EmpDAO.ifTest(new EmpDTO(0, "수녕", null, 0, null));
		//EmpDAO.ifTest(new EmpDTO(0, null, "학생", 0, null));
		
	}
}
