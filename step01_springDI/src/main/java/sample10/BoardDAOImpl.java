package sample10;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository //xml의 <bean class="" 동일 기본id ="boardDAOImpl" 이름은 클래스 이름의 첫 글자만 소문자로 
public class BoardDAOImpl implements BoardDAO {

	public BoardDAOImpl() {}
	@Override
	public void select() {
		System.out.println("BoardDAOImpl의 select() 메소드");
	}

}
