package kosta.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.domain.DeptDTO;
import kosta.domain.EmpDTO;




public class DeptEmpDAO {
	/**
	 * 사원별 부서
	 * */
	public static void selectFirst(EmpDTO empno) {
		
		try(SqlSession session = DbUtil.getSession()){
			List<EmpDTO> list = 
					session.selectList("DeptEmpMapper.selectFirst", empno);
			for(EmpDTO dto : list) {
				System.out.println("사원번호 : " + dto.getEmpno());
				System.out.print(dto.getDeptDTO().getDeptno()+"|");
				System.out.print(dto.getEname()+"|");
				System.out.print(dto.getDeptDTO().getDname()+"|");
				System.out.print(dto.getDeptDTO().getLoc()+"\n");
			}
		}
	}
	
	//selectSecond
	
	/**
	 * 부서별 사원
	 * */
	public static void selectByDeptno(DeptDTO deptDTO) {
		
		try(SqlSession session = DbUtil.getSession()){
			List<DeptDTO> list = 
					session.selectList("DeptEmpMapper.selectSecond", deptDTO);
			for(DeptDTO dto : list) {
				System.out.println("부서번호 : " + dto.getDeptno());
				System.out.print(dto.getDname()+"|");
				System.out.print(dto.getLoc()+"|");
				for(EmpDTO empDTO : dto.getList()) {
					System.out.print(empDTO.getEmpno()+"|");
					System.out.print(empDTO.getEname()+"\n");
				}
			}
		}
	}
	
	
	
}