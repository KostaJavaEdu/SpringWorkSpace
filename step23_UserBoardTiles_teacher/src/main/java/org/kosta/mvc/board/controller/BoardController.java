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
	 * ��� ��
	 * */
	@RequestMapping("/write")
	public void write(HttpSession session) {}
    
    /**
     * ��� �Խù� ��������
     * 
     * @return : void �� ��û�� �ּҰ� ���̸��ȴ�
     * */
    @RequestMapping("/list")
    public void list(HttpSession session,  Model model ) {
    	List<Electronics> list = boardService.selectAll();
    	model.addAttribute("list", list);
    	
    }
    
   
    /**
     * ����ϱ�
     * */
    @RequestMapping("/insert")
    public String insert(HttpSession session, Electronics dto)throws IOException {
    	
    	MultipartFile file = dto.getFile();
    	if(file.getSize() > 0 ) {//������ ÷�εǾ��ٸ�....
    		String fileName = file.getOriginalFilename();
    		long fileSize = file.getSize();
    		
    		dto.setFname(fileName);
    		dto.setFsize(fileSize);
    		
    		//��������
    		file.transferTo(new File(path+"/" + fileName));
    	}
    	
    	
    	boardService.insert(dto);
    	
    	return "redirect:list";
    }
    
    /**
     * �󼼺���
     * */
    @RequestMapping("/read/{modelNum}")
    public ModelAndView read(HttpSession session,  @PathVariable String modelNum ) {
    	Electronics elecDTO=
    			boardService.selectByModelNum(modelNum, true);
    	
    	return new ModelAndView("board/read","elec", elecDTO);
    }
    
    /**
     * �ٿ�ε��ϱ�
     * */
    @RequestMapping("/down")
    public ModelAndView down(HttpSession session, String fname) {
      System.out.println("fname : " + fname);
    	File file = new File(path+"/"+fname);
    	
    	return new ModelAndView("downLoadView", "fname", file);//downLoadView�� BeanNameViewReslover�� ����ȴ�.(�� bean�� �̸��� ã�´٤�)
    }
    
    /**
     * ������
     * */
    @RequestMapping("/updateForm")
    public ModelAndView updateForm(HttpSession session, String modelNum) {
    	Electronics elecDTO=
    			boardService.selectByModelNum(modelNum, false);
    	
    	return new ModelAndView("board/update", "elec", elecDTO);
    }
    
    /**
     * �����ϱ�
     * */
    @RequestMapping("/update")
    public ModelAndView update(HttpSession session, Electronics elecDTO) {
    	boardService.update(elecDTO);//
    	//���������� read.jsp�̵��ϱ����� �Խù� �˻�
    	Electronics dbElec =
    	boardService.selectByModelNum(elecDTO.getModelNum(), false);
    	
    	return new ModelAndView("board/read", "elec" , dbElec);
    }
    
    /**
     * �����ϱ�
     * */
    @RequestMapping("/delete")
    public String delete(HttpSession session, String modelNum, String password) {
    	boardService.delete(modelNum, password);
    	
    	return "redirect:list";
    }

}
