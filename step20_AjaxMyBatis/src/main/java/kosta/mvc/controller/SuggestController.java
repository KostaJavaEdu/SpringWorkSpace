package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.mvc.dto.StudentDTO;
import kosta.mvc.service.SuggestService;

@RestController
public class SuggestController {
	
	@Autowired
	private SuggestService suggestService;
	
	@PostMapping("/suggest") //jackson 라이브러리 필요 
	public List<String> suggest(String keyWord) {
		List<String> list = 
				suggestService.suggestSelect(keyWord);
		return list;
	}
	
	
}
