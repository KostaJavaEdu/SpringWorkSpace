package kosta.mvc.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.dto.TransferDTO;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

	
	@Autowired
	private SqlSession session;
	
	@Override
	public int withDraw(TransferDTO dto) {
		return session.update("transferMapper.withDraw", dto);
	}

	@Override
	public int deposit(TransferDTO dto) {
		return session.update("transferMapper.deposit", dto);
	}
}
