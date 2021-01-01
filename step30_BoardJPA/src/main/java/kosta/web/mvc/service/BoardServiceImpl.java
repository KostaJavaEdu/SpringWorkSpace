package kosta.web.mvc.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import kosta.web.mvc.domain.Board;
import kosta.web.mvc.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired //주입하기 위해서는 먼저 BoardRepository타입의 객체가 생성
	private BoardRepository boardRepo; //내부적으로 구현 객체를 만들기 때문에 구현객체를 만들지 않아도 autowired될 수 있음
	
	public BoardServiceImpl() {
		System.out.println("boardRepo" + boardRepo);
	}
	
	@PostConstruct
	public void aa() {
		System.out.println("boardRepo" + boardRepo);
	}
	
	@Override
	public void insert(Board board) {
		boardRepo.save(board);
	}

	@Override
	public List<Board> selectAll() {
		
		return Lists.newArrayList(boardRepo.findAll());
	}

	@Transactional
	@Override
	public Board selectByNo(long id, boolean state) {
		if(state) {
			//조회수 증가
			boardRepo.updateByReadnum(id);
		}
		Board board = boardRepo.findById(id).orElse(null);
		return board;
	}

	@Transactional
	@Override
	public void update(Board board) {
		
		Board board2 = boardRepo.findById(board.getId()).orElse(null);
		if(board2!=null && board.getPassword().equals(board2.getPassword())) {
			board2.setContent(board.getContent());
			board2.setSubject(board.getSubject());
			//boardRepo.save(board2);//id가 이미 존재하는 것이면 수정함 아니면 insert
		}
	}

	@Transactional
	@Override
	public void delete(Board board) {
		Board board2 = boardRepo.findById(board.getId()).orElse(null);
		if(board2 != null && board2.getPassword().equals(board.getPassword())) {
			boardRepo.delete(board);
		}
	}
}
