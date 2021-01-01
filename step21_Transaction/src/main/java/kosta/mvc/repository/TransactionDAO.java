package kosta.mvc.repository;

import kosta.mvc.dto.TransferDTO;

public interface TransactionDAO {

	/**
	 * 출금하기
	 * */
	int withDraw(TransferDTO dto);
	
	/**
	 * 입금하기
	 * */
	int deposit(TransferDTO dto);
}
