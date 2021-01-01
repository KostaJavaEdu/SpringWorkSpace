package kosta.exam.mvc.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kosta.exam.mvc.domain.BoardDTO;

@Controller
public class BoardController {
	
	@Autowired
	private List<BoardDTO> boardList ;
	

	@RequestMapping("/select.kosta")
	public void select(Model model) {
		model.addAttribute("boardList", boardList);//${boardList}
	}
	
	
	/**
	 * 가입 폼
	 * */
	@RequestMapping("/{aa}.kosta")
	public void url() {}
	
	
	@PostMapping("/register.kosta")
	public String insert(BoardDTO dto) {
		boardList.add(dto);
		return "redirect:select.kosta";
				
	}
	
	@RequestMapping("/read.kosta")
	public ModelAndView read(Integer no) {
		if(no==null) {
			throw new RuntimeException("글번호가 필요합니다.^^");
		}
		
		BoardDTO boardDTO = this.search(no);
		
		if(boardDTO==null) throw new RuntimeException(no+"는 없으므로 찾는 정보가 없습니다.");
		
		return new ModelAndView("read" , "board" , boardDTO);
	}
	
	@RequestMapping("/delete.kosta")
	public String delete(@RequestParam(defaultValue = "0") int no) {
		BoardDTO boardDTO = this.search(no);
		if(boardDTO==null)
			throw new RuntimeException(no+"는 없으므로 삭제 안됩니다.");
		
		boardList.remove(boardDTO);
		
		return "redirect:select.kosta";
	}
	
	/**
	 * 필요한 메소드 선언(list에서 no에 해당하는 객체 찾아서리턴)
	 * */
	public BoardDTO search(int no) {
		for(BoardDTO dto : boardList) {
			if(dto.getNo()==no) {
				return dto;
			}
		}
		return null;
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView error(Exception e) {
		return new ModelAndView("error/errorView" , "errMsg", e.getMessage());
	}
}







