package sample10;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service //id="boardServiceImpl"
public class BoardServiceImpl implements BoardService {
	
	//@Autowired //byName 으로 주입
	@Resource(name = "boardDAOImpl")
	private BoardDAO boardDao; //boardDAOImpl
	
	@Autowired //byName
	private BoardDAO boardMyBatisDaoImpl; //boardMyBatisDAOImpl
	
	@Override
	public void select() {
		System.out.println("BoardServiceImpl 의 select() 메소드");
		
		boardDao.select();
		boardMyBatisDaoImpl.select();
	}

}
