package kosta.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.dto.TransferDTO;
import kosta.mvc.repository.TransactionDAO;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED) //괄호 안은 안써줘도됨. 클래스 말고 메소드에 해도됨
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDAO transactionDAO;
	
	@Override
	public void transfer(TransferDTO dto) {
		int re1 = transactionDAO.withDraw(dto);
		int re2 = transactionDAO.deposit(dto);
		if(re1==0 || re2==0) throw new RuntimeException("계좌이체 되지 않았습니다.");
	}
	
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void aa() {
		
	}
}
