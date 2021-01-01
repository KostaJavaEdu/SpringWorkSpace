package org.kosta.mvc.board.repository;

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
		List<Electronics> list = session.selectList("boardMapper.boardList");
		return list;
	}

	@Override
	public Electronics selectByModelNum(String modelNum) {
		Electronics electronocs = session.selectOne("boardMapper.boardRead",modelNum);
		return electronocs;
	}

	@Override
	public int readnumUpdate(String modelNum) {
		int result = session.update("boardMapper.readnum", modelNum);
		return result;
	}

	@Override
	public int insert(Electronics electronics) {
		int result = session.insert("boardMapper.boardInsert", electronics);
		return result;
	}

	@Override
	public int delete(String modelNum, String password) {
		//delete 인수 값 두개 받는 거 모르겠음
		Map<String, String> map = new HashMap<String, String>();
		map.put("modelNum", modelNum);
		map.put("password", password);
		int result = session.delete("boardMapper.boardDelete", map);
		return result;
	}

	@Override
	public int update(Electronics electronics) {
		int result = session.update("boardMapper.boardUpdate", electronics);
		return result;
	}
}
