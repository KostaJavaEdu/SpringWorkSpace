package org.kosta.mvc.board.service;

import java.util.List;

import org.kosta.mvc.board.domain.Electronics;
import org.kosta.mvc.board.repository.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
    @Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<Electronics> selectAll() {
		return boardDAO.selectAll();
	}

	@Override
	public Electronics selectByModelNum(String modelNum, boolean state) {
		if(state) {
			int result = boardDAO.readnumUpdate(modelNum);
			if(result==0)throw new RuntimeException("조회수증가 오류로 실패하였습니다.");
		}
		
		Electronics elecDTO =boardDAO.selectByModelNum(modelNum);
		if(elecDTO==null)throw new RuntimeException("게시물 검색에 오류가 발생했습니다.");
		
		return elecDTO;
	}

	@Override
	public int insert(Electronics electronics) {
		int result = boardDAO.insert(electronics);
		if(result==0)throw new RuntimeException("등록되지 않았습니다.");
		return result;
	}

	@Override
	public int delete(String modelNum, String password) {
		int result = boardDAO.delete(modelNum, password);
		if(result==0)throw new RuntimeException("삭제되지 않았습니다.");
		return result;
	}

	@Override
	public int update(Electronics electronics) {
		Electronics dbElec =
			boardDAO.selectByModelNum(electronics.getModelNum());
		
		if(!dbElec.getPassword().equals(electronics.getPassword())) {
			throw new RuntimeException("비밀번호 오류 입니다. -수정실패");
		}
		
		int result = boardDAO.update(electronics);
		if(result==0)throw new RuntimeException("수정되지 않았습니다.");
		return result;
	}

}





