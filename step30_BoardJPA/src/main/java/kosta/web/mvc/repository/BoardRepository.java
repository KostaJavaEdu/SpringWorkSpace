package kosta.web.mvc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import kosta.web.mvc.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
	
	/**
	 * fondbyXxx에 해당하는 메소드 선언 - select 활용.
	 * */
	
	/**
	 * 조회수 증가 -> 내가 직접 만들어야함
	 * 	: 쿼리를 작성할 때는 JPQL문법(자바 객체 중심 쿼리)
	 * */
	//@Transactional
	@Modifying
	@Query("update Board b set b.readnum = b.readnum+1 where b.id=?1")
	void updateByReadnum(Long id);
	
}
