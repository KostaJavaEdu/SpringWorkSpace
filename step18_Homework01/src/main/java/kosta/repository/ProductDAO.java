package kosta.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kosta.domain.ProductListDTO;



public class ProductDAO {
	
	/**
	 * 삽입
	 * */
	public static void insert(ProductListDTO product) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			state = mapper.insert(product) > 0 ? true : false;
			if(state) System.out.println("삽입성공");
			else System.out.println("삽입실패");
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * 검색필드, 키워드
	 * */
	public static void selectByKeyword(Map<String, String> map) {
		try (SqlSession session = DbUtil.getSession()){
			List<ProductListDTO> list = 
					session.selectList("productMapper.selectByWhat",map);
			for( ProductListDTO dto : list ) {
				System.out.println(dto);
			}
		}
	}
	
	
	/**
	 * 수정
	 * */
	public static void update(ProductListDTO product) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			state = mapper.update(product) > 0 ? true : false;
			if(state) System.out.println("수정성공");
			else System.out.println("수정실패");
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * 삭제
	 * */
	public static void delete(String code) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			state = mapper.delete(code) > 0 ? true : false;
			if(state) System.out.println("삭제성공");
			else System.out.println("삭제실패");
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * 총 갯수
	 * */
	public static void count() {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			int result = mapper.count(); 
			System.out.println("총 갯수 : " + result);
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 상품코드 파라미터 여러개에 해당하는 레코드
	 * */
	//foreachSelect
	public static void selectParameter(List<String> list) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			List<ProductListDTO> product = 
					session.selectList("productMapper.foreachSelect", list);
			for(ProductListDTO dto : product) {
				System.out.println(dto);
			}
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	
}