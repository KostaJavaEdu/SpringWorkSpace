package kosta.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.domain.EmpDTO;


public class EmpDAO {
	
	/**
	 * 전체검색
	 * */
	public static void selectAll() {
		try(SqlSession session = DbUtil.getSession()) {
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			List<EmpDTO> list = mapper.selectAll();
			for( EmpDTO dto : list ) {
				System.out.println(dto);
			}
		}
	}
	
	/**
	 * 사원번호에 해당하는 사원정보 검색
	 * */
	public static void selectByEmpno(int empno) {
		try(SqlSession session = DbUtil.getSession()){
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			EmpDTO dto = mapper.selectByEmpno(empno);
			System.out.println(dto);
		}
	}
	
	/**
	 * 등록
	 * */
	public static void insert(EmpDTO empDTO) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			state = mapper.insert(empDTO) > 0 ? true : false;
			if(state) System.out.println("삽입성공");
			else System.out.println("삽입실패");
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * 삭제
	 * */
	public static void delete(int empno) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			state = mapper.delete(empno) > 0 ? true : false;
			if(state) System.out.println("삭제성공");
			else System.out.println("삭제실패");
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * 수정
	 * */
	public static void update(EmpDTO empDTO) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			state = mapper.update(empDTO) > 0 ? true : false;
			if(state) System.out.println("수정성공");
			else System.out.println("수정실패");
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	public static void ifTest(EmpDTO empDTO) {
		try(SqlSession session = DbUtil.getSession()){
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			List<EmpDTO> list = 
					mapper.ifTest(empDTO);
			
			for( EmpDTO dto  : list) {
				System.out.println(dto);
			}
		}
	}

}