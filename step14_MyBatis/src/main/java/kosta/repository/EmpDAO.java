package kosta.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kosta.domain.EmpDTO;

public class EmpDAO {
	/**
	 * 모든 사원 이름검색
	 * */
	
	public static void selectAllName() {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			List<String> list = session.selectList("EmpMapper.selectAllName");
			System.out.println("list : " + list);
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	public static void insert(EmpDTO dto) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			state = session.insert("EmpMapper.insert", dto) > 0 ? true : false;
			if(state) System.out.println("등록되었습니다.");
			else System.out.println("등록되지 않았습니다.");
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	public static void delete(int empno) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			state = session.delete("EmpMapper.delete",empno) > 0 ? true : false;
			if(state) System.out.println("삭제되었습니다.");
			else System.out.println("삭제되지 않았습니다.");
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	public static void update(EmpDTO dto) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			state = session.delete("EmpMapper.update",dto) > 0 ? true : false;
			if(state) System.out.println("수정되었습니다.");
			else System.out.println("수정되지 않았습니다.");
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	public static void selectAll() {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			//List<String> list = session.selectList("EmpSelectMapper.selectAll");
			RowBounds rb = new RowBounds(0, 2);
			List<String> list = 
					session.selectList("EmpSelectMapper.selectAll", null, rb);
			System.out.println("list : " + list);
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 사원번호 검색
	 * */
	public static void selectByEmpno(int empno) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			EmpDTO dto = session.selectOne("EmpSelectMapper.selectByEmpno",empno);
			System.out.println("dto : " + dto);
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 급여 이하 검색
	 * */
	public static void selectBySal(int sal) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			List<EmpDTO> list = 
					session.selectList("EmpSelectMapper.selectBySal", sal);
			System.out.println("list : " + list);
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 급여 최소~최대 검색
	 * */
	public static void selectBySal(int min, int max) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("min", min);
			map.put("max", max);
			
			List<EmpDTO> list = 
					session.selectList("EmpSelectMapper.selectByMinMax", map);
			
			System.out.println(list);
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 정렬하기
	 * */
	public static void selectByOrder(String columnName) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			List<EmpDTO> list = 
					session.selectList("EmpSelectMapper.selectByOrder", columnName);
			
			System.out.println(list);
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 검색필드 포함 검색
	 * */
	public static void selectByField(String column, String keyword) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			Map<String, String> map = new HashMap<String, String>();
			map.put("column", column);
			map.put("keyword", keyword);
			
			List<EmpDTO> list = 
					session.selectList("EmpSelectMapper.selectByField", map);
			
			System.out.println(list);
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * job에 해당하는 레코드 검색
	 * */
	public static void selectByJob(String job) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			
			List<EmpDTO> list = 
					session.selectList("EmpMapper.selectByJob", job);
			
			System.out.println(list);
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
}
