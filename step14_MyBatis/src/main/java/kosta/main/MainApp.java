package kosta.main;

import kosta.domain.EmpDTO;
import kosta.repository.EmpDAO;

public class MainApp {
	public static void main(String[] args) {
		/**
		 * 1. 전체 이름 가져오기
		 * */
		//EmpDAO.selectAllName();
		System.out.println("---------------------");
		/**
		 * 2. 등록하기
		 * */
		
		//EmpDAO.insert(new EmpDTO(81, "수녕", "학생", 300, null));
		
		/**
		 * 3. 삭제하기
		 * */
		//EmpDAO.delete(9898);
		
		
		/**
		 * 4. 수정하기
		 * */
		//EmpDAO.update(new EmpDTO(9595, "희정", "공쥬", 0, null));
		
		/**
		 * 5. 전체검색
		 * */
		EmpDAO.selectAll();
		
		/**
		 * 6. 사원번호 검색
		 * */
		//EmpDAO.selectByEmpno(9595);
		
		
		/**
		 * 7. 급여 이하 검색
		 * */
		//EmpDAO.selectBySal(6000);
		
		/**
		 * 8. 급여 최소~최대 검색
		 * */
		//EmpDAO.selectBySal(400, 5000);
		
		/**
		 * 9. 정렬하기 (정렬 대상 필드를 인수로 전달)
		 * */
		 //EmpDAO.selectByOrder("empno");
		 
		 /**
		  * 10. 검색필드에 검색단어를 포함하고 있는 레코드
		  * */
		 //EmpDAO.selectByField("sal", "5");
		 
		 /**
		  * 11. job에 해당하는 레코드 검색
		  * */
		 //EmpDAO.selectByJob("학생");
	}
}
