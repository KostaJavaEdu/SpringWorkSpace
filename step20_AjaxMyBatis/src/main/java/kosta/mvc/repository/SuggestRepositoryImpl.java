package kosta.mvc.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.dto.StudentDTO;

@Repository //id=suggestRepositoryImpl
public class SuggestRepositoryImpl implements SuggestRepository {

	@Autowired
	private SqlSession session;
	
	@Override
	public List<String> suggestSelect(String word) {
		List<String> list = 
				session.selectList("suggestMapper.suggestSelect", word);
		return list;
	}
	
	

}
