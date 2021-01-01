package kosta.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.domain.DeptDTO;
import kosta.domain.EmpDTO;
import kosta.domain.SalgradeDTO;

public class JoinDAO {
	public static void selectByEmpno(EmpDTO empDTO) {
		try (SqlSession session = DbUtil.getSession()) {
			List<EmpDTO> list = session.selectList("JoinMapper.selectByEmpno", empDTO);

			for (EmpDTO dto : list)
				System.out.println(dto.getEmpno() + " | " + dto.getEname() + " | " + dto.getDeptDTO().getDname() + " | "
						+ dto.getDeptDTO().getLoc());
		}
	}

	public static void selectByDeptno(DeptDTO deptDTO) {
		try (SqlSession session = DbUtil.getSession()) {
			List<DeptDTO> list = session.selectList("JoinMapper.selectByDeptno", deptDTO);

			for (DeptDTO dto : list) {
				System.out.println(dto.getDeptno() + " | " + dto.getDname() + " | " + dto.getLoc());
				for (EmpDTO empDTO : dto.getEmpList())
					System.out.println(empDTO.getEmpno() + " | " + empDTO.getEname());
			}
		}
	}

	public static void selectSalGradeByEmpno(EmpDTO empDTO) {
		try (SqlSession session = DbUtil.getSession()) {
			List<EmpDTO> list = session.selectList("JoinMapper.selectSalGradeByEmpno", empDTO);

			for (EmpDTO dto : list) {
				SalgradeDTO salgradeDTO = dto.getSalgradeDTO();
				System.out.println(dto.getEmpno() + " | " + dto.getEname() + " | " + dto.getJob() + " | " + dto.getSal()
						+ " | " + salgradeDTO.getGrade() + " | " + salgradeDTO.getLosal() + " | "
						+ salgradeDTO.getHisal());
			}
		}

	}
	
	public static void selectEmpByGrade(SalgradeDTO salgradeDTO) {
		try(SqlSession session = DbUtil.getSession()){
			List<SalgradeDTO> list = session.selectList("JoinMapper.selectEmpByGrade", salgradeDTO);
			
			for(SalgradeDTO dto : list) {
				System.out.println(dto.getGrade() + " | " + dto.getLosal() + " | " + dto.getHisal());
				for(EmpDTO empDTO : dto.getEmpList()) 
					System.out.println(empDTO.getEmpno() + " | " + empDTO.getEname() + " | " + empDTO.getJob() + " | " + empDTO.getSal());
			}
		}
	}
}
