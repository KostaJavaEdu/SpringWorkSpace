package kosta.web.mvc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.google.common.collect.Lists;

import kosta.web.mvc.domain.Board;
import kosta.web.mvc.repository.BoardRepository;

@SpringBootTest
class BoardRepositoryTests {
	
	@Autowired
	private BoardRepository repo;

	@Test
	void contextLoads() {
		System.out.println("안녕~~~");
	}
	
	/**
	 * 등록하기
	 * */
	@Test
	public void insert() {
		//repo.save(new Board(null,"spring boot","최수녕","신기하다",null));
		for(int i=1; i<=200; i++) {
			repo.save(new Board(null,"제목" + i,"user"+i,"springJPA"+i,null));
		}
	}
	
	/**
	 * 검색하기
	 * */
	@Test
	public void selectByBno() {
		Board board = repo.findById(62L).orElse(null);
		System.out.println(board);
	}
	
	/**
	 * 수정하기
	 * */
	@Test
	public void update() {
		Board board = repo.findById(62L).orElse(null);
		if(board!=null) {
			//수정하자
			board.setContent("수정완료");
			board.setTitle("수정하기");
			repo.save(board);
		}
	}
	
	/**
	 * 삭제하기
	 * */
	@Test
	public void delete() {
		repo.deleteById(61L);
	}
	
	/**
	 * 조건검색
	 * */
	@Test
	public void search() {
//		List<Board> list = repo.findByTitle("제목12");
//		for(Board board : list) {
//			System.out.println(board);
//		}
		
		List<Board> list = repo.findByTitleContaining("제목1");
//		for(Board board : list) {
//			System.out.println(board);
//		}
		
		list.forEach(board -> System.out.println(board));
		
	}
	
	/**
	 * Page<Board> 리턴
	 * */
	@Test
	public void searchTest() {
		//List<Board> list = repo.findByBnoGreaterThanOrderByBnoDesc(80L);
		//list.forEach(board -> System.out.println(board));
		
		Pageable page = PageRequest.of(18, 10);
		Page<Board> pageList = repo.findByBnoGreaterThanOrderByBnoDesc(80L, page);
		
		//조회된 데이터 가져오기
		pageList.getContent().forEach(board->System.out.println(board));
		
		System.out.println("*******************");
		
		System.out.println("pageList.getNumber() : " + pageList.getNumber());
		System.out.println("pageList.getSize() : " + pageList.getSize());
		System.out.println("pageList.getTotalPages() : " + pageList.getTotalPages());
		System.out.println("pageList.previousPageable() : " + pageList.previousPageable());
		System.out.println("pageList.nextPageable() : " + pageList.nextPageable());
		
		System.out.println("*******************");
	}
	
	/**
	 * 전체검색
	 * */
	@Test
	public void selectAll() {
		
		Iterable<Board> iter = repo.findAll();
		
		//Iterable -> List 형태로 변환
//		Iterator<Board> it = iter.iterator();
//		List<Board> list = new ArrayList<Board>();
//		while(it.hasNext()) {
//			Board board = it.next();
//			list.add(board);
//		}
		
		//guava lib
		List<Board> list = Lists.newArrayList(iter);
		
		System.out.println("******************");
		list.forEach(b->System.out.println(b));
	}
}














