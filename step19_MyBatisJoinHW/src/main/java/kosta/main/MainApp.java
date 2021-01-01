/**
 * 이름 : 오유진
 * 날짜 : 2019.12.18
 * 주제 : myBatis join
 * */

package kosta.main;

import kosta.domain.DeptDTO;
import kosta.domain.EmpDTO;
import kosta.domain.SalgradeDTO;
import kosta.repository.JoinDAO;

public class MainApp {
	public static void main(String[] args) {
		// 각 사원의 부서
		// JoinDAO.selectByEmpno(new EmpDTO());
		// JoinDAO.selectByEmpno(new EmpDTO(7839));

		// 부서별 사원
		//JoinDAO.selectByDeptno(new DeptDTO());
		 JoinDAO.selectByDeptno(new DeptDTO(10));

		// 각 사원의 salgrade
		// JoinDAO.selectSalGradeByEmpno(new EmpDTO());
		// JoinDAO.selectSalGradeByEmpno(new EmpDTO(7839));
		
		// salgrade 별 사원
		// JoinDAO.selectEmpByGrade(new SalgradeDTO());
		// JoinDAO.selectEmpByGrade(new SalgradeDTO(2));

	}
}
