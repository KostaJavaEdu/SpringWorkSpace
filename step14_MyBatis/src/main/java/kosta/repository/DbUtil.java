package kosta.repository;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbUtil {
	
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) { //여기서 오류날 때 이렇게 잡으면 오류 굉장히 디테일해져
//		System.out.println(1);
//	}
	
	/**
	 * MyBatis의 SqlSession 객체를 리턴해주는 메소드 작성
	 *  : SqlSession는 CRUD관련메소드와 commit, rollback 메소드를 제공한다.
	 *  	JDBC의 Connection과 유사.
	 * */
	
	public static SqlSession getSession() {
		return factory.openSession();
	}
	
	
	/**
	 * 닫기 기능(select인 경우)
	 * */
	public static void sessionClose(SqlSession session) {
		if(session!=null) session.close();
	}
	
	/**
	 * 닫기 기능(DML인 경우 : insert, update, delete)
	 * 
	 * @param : boolean형은 commit or rollback 처리를 위한 것.
	 * 			true이면 commit, false이면 rollback처리
	 * */
	public static void sessionClose(SqlSession session, boolean state) {
		if(session!=null) {
			if(state) session.commit();
			else session.rollback();
			session.close();
		}
	}
}
