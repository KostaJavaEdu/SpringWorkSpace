package  org.kosta.mvc.board.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.kosta.mvc.board.domain.Electronics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
    @Autowired
	private SqlSession session;
	
	@Override
	public List<Electronics> selectAll() {
		return session.selectList("boardMapper.selectAll");
	}

	@Override
	public Electronics selectByModelNum(String modelNum) {
		return session.selectOne("boardMapper.selectAll" , modelNum);
	}

	@Override
	public int readnumUpdate(String modelNum) {
		return session.update("boardMapper.readnumUpdate" , modelNum);
	}

	@Override
	public int insert(Electronics electronics) {
		return session.insert("boardMapper.boardInsert" ,electronics);
	}

	@Override
	public int delete(String modelNum, String password) {
		Map<String, String> map =new HashMap<String, String>();
		map.put("modelNum", modelNum);
		map.put("password", password);
		
		return session.delete("boardMapper.delete", map);
	}

	@Override
	public int update(Electronics electronics) {
		return session.update("boardMapper.update", electronics);
	}

}
