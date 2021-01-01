package org.kosta.mvc.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.kosta.mvc.board.domain.Electronics;
import org.kosta.mvc.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	/**
	 * 모든 게시물 가져오기
	 * */
	@RequestMapping("/list")
	public void boardList(HttpSession session, Model model) {
		List<Electronics> list = boardService.selectAll();
		model.addAttribute("list", list);
	} 
	
	@RequestMapping("/write")
	public void write(HttpSession session) {}
	
	@RequestMapping("/insert")
	public String insert(HttpSession session,Electronics electronics) throws IOException{
			MultipartFile file = electronics.getFile();
			
			if(file.getSize() > 0) {
				String path = session.getServletContext().getRealPath("/WEB-INF/save");
				String fileName = file.getOriginalFilename();
				file.transferTo(new File(path+"/"+fileName)); //폴더에 저장완료
				electronics.setFname(fileName); //dto에 파일이름 저장
				electronics.setFsize(file.getSize()); //dto에 파일사이즈 저장
			}
			
			
			boardService.insert(electronics);
		return "redirect:list";
	}
	
	@RequestMapping("/read/{modelNum}")
	public ModelAndView read(HttpSession session,@PathVariable String modelNum) {
		Electronics elec = boardService.selectByModelNum(modelNum, true);
		return new ModelAndView("board/read", "elec", elec);
	}
	
	@RequestMapping("/updateForm")
	public ModelAndView updateForm(HttpSession session,String modelNum) {
		Electronics elec = boardService.selectByModelNum(modelNum, false);
		return new ModelAndView("board/update", "elec", elec);
	}
	
	@RequestMapping("/update")
	public ModelAndView update(HttpSession session,Electronics electronics) {
		Electronics elec = boardService.selectByModelNum(electronics.getModelNum(), false);
		boardService.update(electronics);
		return new ModelAndView("redirect:list", "elec", elec);
	}
	
	
	@RequestMapping("/delete")
	public String delete(HttpSession session,String modelNum, String password) {
		boardService.delete(modelNum, password);
		return "redirect:list";
	}
	
	@RequestMapping("/downLoad")
	public ModelAndView down(HttpSession session,String fname){
		ModelAndView mv = new ModelAndView();
		String path = 
				session.getServletContext().getRealPath("/WEB-INF/save");
		mv.addObject("fname",new File(path + "/" + fname));
		mv.setViewName("downLoadView"); //bean의 id를 찾을 수 있도록 ...
		return mv;
	}
}
