package kosta.mvc.repository;

import java.util.List;

public interface SuggestRepository {

	/**
	 * 전달된 단어로 시작하는 단어를 DB에서 찾기
	 * */
	List<String> suggestSelect(String word);
	
	
}
