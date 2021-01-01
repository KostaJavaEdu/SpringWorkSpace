package kosta.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.domain.EmpDTO;

public class EmpDAO {
	/**
	 * ifTest 하기
	 * */
	public static void ifTest(EmpDTO empDTO) {
		try(SqlSession session = DbUtil.getSession()){
			List<EmpDTO> list = 
					session.selectList("EmpMapper.ifTest", empDTO);
			
			for( EmpDTO dto  : list) {
				System.out.println(dto);
			}
		}
	}
	
	/**
	 * set 실습
	 * */
	public static void setTest(EmpDTO empDTO) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			state = session.update("EmpMapper.updateSet", empDTO)>0 ? true : false;
			if(state) System.out.println("수정되었습니다.");
			else System.out.println("수정실패");
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * forEach 실습
	 * */
	public static void forEachTest(List<Integer> list) {
		try(SqlSession session = DbUtil.getSession()){
			List<EmpDTO> returnList = 
					session.selectList("EmpMapper.forEachTest", list);
			
			for( EmpDTO dto  : returnList) {
				System.out.println(dto);
			}
		}
	}
}