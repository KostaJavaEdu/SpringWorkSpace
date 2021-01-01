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
			if(result==0)throw new RuntimeException("��ȸ������ ������ �����Ͽ����ϴ�.");
		}
		
		Electronics elecDTO =boardDAO.selectByModelNum(modelNum);
		if(elecDTO==null)throw new RuntimeException("�Խù� �˻��� ������ �߻��߽��ϴ�.");
		
		return elecDTO;
	}

	@Override
	public int insert(Electronics electronics) {
		int result = boardDAO.insert(electronics);
		if(result==0)throw new RuntimeException("��ϵ��� �ʾҽ��ϴ�.");
		return result;
	}

	@Override
	public int delete(String modelNum, String password) {
		int result = boardDAO.delete(modelNum, password);
		if(result==0)throw new RuntimeException("�������� �ʾҽ��ϴ�.");
		return result;
	}

	@Override
	public int update(Electronics electronics) {
		Electronics dbElec =
			boardDAO.selectByModelNum(electronics.getModelNum());
		
		if(!dbElec.getPassword().equals(electronics.getPassword())) {
			throw new RuntimeException("��й�ȣ ���� �Դϴ�. -��������");
		}
		
		int result = boardDAO.update(electronics);
		if(result==0)throw new RuntimeException("�������� �ʾҽ��ϴ�.");
		return result;
	}

}





