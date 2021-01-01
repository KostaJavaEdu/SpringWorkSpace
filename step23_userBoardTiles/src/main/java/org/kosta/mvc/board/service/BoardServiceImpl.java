package org.kosta.mvc.board.service;

import java.util.List;

import org.kosta.mvc.board.domain.Electronics;
import org.kosta.mvc.board.repository.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<Electronics> selectAll() {
		List<Electronics> list = boardDAO.selectAll();
		return list;
	}

	@Override
	public Electronics selectByModelNum(String modelNum, boolean state) {
		if(state) {
			if(boardDAO.readnumUpdate(modelNum)==0){
				throw new RuntimeException("조회수 증가 오류로 인해 검색안됨");
			}
		}
		Electronics electronics = boardDAO.selectByModelNum(modelNum);
		if(electronics==null) {
			throw new RuntimeException(modelNum+"의 정보가 없습니다.");
		}
		return electronics;
	}

	@Override
	public int insert(Electronics electronics) {
		int result = boardDAO.insert(electronics);
		if(result==0) throw new RuntimeException("삽입실패");
		return result;
	}

	@Override
	public int delete(String modelNum, String password) {
		int result = boardDAO.delete(modelNum, password);
		if(result==0) throw new RuntimeException("삭제 실패입니다.");
		return result;
	}

	@Override
	public int update(Electronics electronics) {
		int result = boardDAO.update(electronics);
		if(result==0) throw new RuntimeException("수정 실패입니다.");
		return result;
	}
}
