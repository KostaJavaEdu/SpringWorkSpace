package kosta.mvc.service;

import kosta.mvc.dto.TransferDTO;

public interface TransactionService {

	/**
	 * 계좌이체하기
	 * */
	void transfer(TransferDTO dto);
	
	//테스트용
	void aa();
}
