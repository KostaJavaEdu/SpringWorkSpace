package kosta.web.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.web.mvc.domain.Board;
import kosta.web.mvc.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/write")
	public void write() {}
	
	@PostMapping("/insert")
	public String insert(Board board) {
		boardService.insert(board);
		return "redirect:list"; //"redirect:/board/list"
	}
	
	@RequestMapping("/list")
	public void selectAll(Model model) {
		List<Board> list = boardService.selectAll();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("/read/{id}")
	public ModelAndView read(@PathVariable Long id) {
		Board board = boardService.selectByNo(id, true);
		return new ModelAndView("board/read","board",board);
	}
	
	@RequestMapping("/updateForm")
	public ModelAndView updateForm(Long id) {
		Board board = boardService.selectByNo(id, false);
		return new ModelAndView("board/update","board",board);
	}
	
	@RequestMapping("/update")
	public String update(Board board) {
		boardService.update(board);
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(Board board) {
		Board board2 = boardService.selectByNo(board.getId(),false);
		boardService.delete(board2);
		return "redirect:list";
	}
}
