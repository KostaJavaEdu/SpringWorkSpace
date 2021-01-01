package kosta.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.repository.SuggestRepository;
@Service //id=suggestServiceImpl
public class SuggestServiceImpl implements SuggestService {

	@Autowired //byType으로 주입
	private SuggestRepository suggestRep;
	
	@Override
	public List<String> suggestSelect(String word) {
		
		return suggestRep.suggestSelect(word);
	}

}
