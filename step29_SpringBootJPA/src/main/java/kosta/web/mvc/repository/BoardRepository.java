package kosta.web.mvc.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import kosta.web.mvc.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

	/**
	 * 제목에 해당하는 레코드 검색하기
	 * */
	List<Board> findByTitle(String title);//제목이 똑같아야함
	List<Board> findByTitleContaining(String title);//제목에 이 단어를 포함한 걸 찾는다(like연산자)
	
	/**
	 * 글번호가 50번 이상이면서 내용에 어떤 단어를 포함
	 * 정렬
	 * 
	 * 리턴타입 page는 단순히 데이터만 추출하는 것이 아니라 
	 * 웹에서 필요한 데이터들을 추가적으로 제공한다.
	 * 
	 * findby는 select전용이다!!!!(insert, delete안됨)
	 * 
	 * pageable에는 현재 페이지의 번호와 한 페이지 당 들어갈 갯수가 들어가야 한다.
	 * */
	List<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno);
	
	Page<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno,Pageable pageable);
	
}
