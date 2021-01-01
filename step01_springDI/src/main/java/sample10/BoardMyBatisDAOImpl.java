package sample10;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("boardMyBatisDaoImpl") //id="boardMyBatisDAOImpl"
public class BoardMyBatisDAOImpl implements BoardDAO {

	@Override
	public void select() {
		System.out.println("BoardMyBatisDAOImpl 의 select() 메소드");
	}

}
