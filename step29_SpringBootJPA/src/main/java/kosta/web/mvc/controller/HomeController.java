package kosta.web.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.web.mvc.domain.Board;
import kosta.web.mvc.repository.BoardRepository;

@Controller
public class HomeController {
	@Autowired
	private BoardRepository boardRepo;

	@RequestMapping("/")
	public String index(Model model) {
		
		//service -> dao
		Pageable page = PageRequest.of(0, 10);
		Page<Board> pageList = boardRepo.findByBnoGreaterThanOrderByBnoDesc(80L,page);
		
		model.addAttribute("list", pageList.getContent());
		model.addAttribute("size",pageList.getSize());
		model.addAttribute("totalPage",pageList.getTotalPages());
		model.addAttribute("nextP",pageList.nextPageable());
		model.addAttribute("previousP",pageList.previousPageable());
		model.addAttribute("number",pageList.getNumber());
		
		return "index"; //WEB-INF/views/index.jsp
	}
	
	@RequestMapping("/select")
	public ModelAndView select() {
		return new ModelAndView("result","message","select성공");
	}
}
