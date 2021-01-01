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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * MyBatis의 SqlSession 객체를 리턴하는 메소드 작성 SqlSession는 CRUD 관련 메소드와 commit, rollback
	 * 메소드 제공 JDBC의 Connection과 유사
	 */
	public static SqlSession getSession() {
		return factory.openSession();
	}

	/**
	 * 닫기 기능 (select)
	 */
	public static void sessionClose(SqlSession session) {
		if (session != null)
			session.close();
	}

	/**
	 * 닫기 기능 (DML : insert, delete, update)
	 * 
	 * @param : boolean -> commit or false true면 commit, false면 rollback
	 */
	public static void sessionClose(SqlSession session, boolean state) {
		if (session != null) {
			if (state)
				session.commit();
			else
				session.rollback();
			session.close();
		}
	}
}
