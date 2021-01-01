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
	
    private String path ="C:\\Edu\\springFileSave\\";
    
    /**
	 * 등록 폼
	 * */
	@RequestMapping("/write")
	public void write(HttpSession session) {}
    
    /**
     * 모든 게시물 가져오기
     * 
     * @return : void 는 요청된 주소가 뷰이름된다
     * */
    @RequestMapping("/list")
    public void list(HttpSession session,  Model model ) {
    	List<Electronics> list = boardService.selectAll();
    	model.addAttribute("list", list);
    	
    }
    
   
    /**
     * 등록하기
     * */
    @RequestMapping("/insert")
    public String insert(HttpSession session, Electronics dto)throws IOException {
    	
    	MultipartFile file = dto.getFile();
    	if(file.getSize() > 0 ) {//파일이 첨부되었다면....
    		String fileName = file.getOriginalFilename();
    		long fileSize = file.getSize();
    		
    		dto.setFname(fileName);
    		dto.setFsize(fileSize);
    		
    		//파일저장
    		file.transferTo(new File(path+"/" + fileName));
    	}
    	
    	
    	boardService.insert(dto);
    	
    	return "redirect:list";
    }
    
    /**
     * 상세보기
     * */
    @RequestMapping("/read/{modelNum}")
    public ModelAndView read(HttpSession session,  @PathVariable String modelNum ) {
    	Electronics elecDTO=
    			boardService.selectByModelNum(modelNum, true);
    	
    	return new ModelAndView("board/read","elec", elecDTO);
    }
    
    /**
     * 다운로드하기
     * */
    @RequestMapping("/down")
    public ModelAndView down(HttpSession session, String fname) {
      System.out.println("fname : " + fname);
    	File file = new File(path+"/"+fname);
    	
    	return new ModelAndView("downLoadView", "fname", file);//downLoadView는 BeanNameViewReslover가 실행된다.(즉 bean의 이름을 찾는다ㅏ)
    }
    
    /**
     * 수정폼
     * */
    @RequestMapping("/updateForm")
    public ModelAndView updateForm(HttpSession session, String modelNum) {
    	Electronics elecDTO=
    			boardService.selectByModelNum(modelNum, false);
    	
    	return new ModelAndView("board/update", "elec", elecDTO);
    }
    
    /**
     * 수정하기
     * */
    @RequestMapping("/update")
    public ModelAndView update(HttpSession session, Electronics elecDTO) {
    	boardService.update(elecDTO);//
    	//성공했으니 read.jsp이동하기전에 게시물 검색
    	Electronics dbElec =
    	boardService.selectByModelNum(elecDTO.getModelNum(), false);
    	
    	return new ModelAndView("board/read", "elec" , dbElec);
    }
    
    /**
     * 삭제하기
     * */
    @RequestMapping("/delete")
    public String delete(HttpSession session, String modelNum, String password) {
    	boardService.delete(modelNum, password);
    	
    	return "redirect:list";
    }

}
