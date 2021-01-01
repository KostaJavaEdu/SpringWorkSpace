package kosta.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.dto.TransferDTO;
import kosta.mvc.service.TransactionService;

@Controller
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping("/")
	public String url() {
		return "transaction";
	}
	
	/**
	 * 계좌이체
	 * */
	@RequestMapping("/transfer")
	public String transfer(TransferDTO dto) {
		transactionService.transfer(dto);
		return "result";
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView error(RuntimeException e) {
		return new ModelAndView("error","errMessage",e.getMessage());
	}
}
