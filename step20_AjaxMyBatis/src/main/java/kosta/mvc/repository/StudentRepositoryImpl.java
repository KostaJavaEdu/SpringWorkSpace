package kosta.mvc.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.dto.StudentDTO;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private SqlSession session;
	
	@Override
	public List<StudentDTO> studentSelect(){
		List<StudentDTO> list = 
				session.selectList("suggestMapper.studentSelect");
		return list;
	}

	@Override
	public int insert(StudentDTO student) {
		int result = session.insert("suggestMapper.studentInsert", student);
		return result;
	}

	@Override
	public int delete(String stno) {
		int result = session.delete("suggestMapper.studentDelete", stno);
		return result;
	}

	@Override
	public String noCheck(String stno) {
		String result = session.selectOne("suggestMapper.noCheck", stno);
		return result;
	}
	
	

}
