package kosta.main;

import java.util.ArrayList;
import java.util.List;

import kosta.domain.DeptDTO;
import kosta.domain.EmpDTO;
import kosta.repository.DeptEmpDAO;

public class MainApp {
  public static void main(String[] args) {
	 
	  /**
	   * 부서별 번호에 따른 
	   * */
	  //DeptEmpDAO.selectFirst(new EmpDTO(7369, "수녕", 0, null, 0, null));
	  
	  //DeptEmpDAO.selectFirst(new EmpDTO());
	  
	  DeptEmpDAO.selectByDeptno(new DeptDTO(20, null, null, null));
	  
	}
}







