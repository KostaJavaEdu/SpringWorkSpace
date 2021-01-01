package kosta.mvc.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.domain.UploadDTO;

@Controller
public class UploadController {

	/**
	 * MultipartFile를 사용하려면
	 * MultipartResolver의 구현객체를 선언해야한다.(생성)
	 * 		 : bean 설정문서에
	 * */
	@RequestMapping("/upload.do")
	public ModelAndView upload(String name, MultipartFile file, HttpSession session) { //input에 있는 name이름과 같아야함
		ModelAndView mv = new ModelAndView();
		try {
			//실제 루트경로 가져오기
			String path = 
					session.getServletContext().getRealPath("/WEB-INF/save");
			
			//첨부된 파일 이름 가져오기
			String fileName = 
					file.getOriginalFilename();
			
			file.transferTo(new File(path+"/"+fileName)); //폴더에 저장완료
			
			//뷰쪽으로 전달될 데이터 설정
			mv.addObject("fileName",fileName);
			mv.addObject("path",path);
			mv.addObject("name",name);
			mv.addObject("fileSize",file.getSize());
			
			mv.setViewName("uploadResult"); //views/uploadResult.jsp이동
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	@RequestMapping("/upload2.do")
	public String upload2(UploadDTO uploadDTO ,HttpSession session) {
		//파일 폴더에 저장
		String path = 
				session.getServletContext().getRealPath("/WEB-INF/save");
		String fileName = uploadDTO.getFile().getOriginalFilename();
		try {
			uploadDTO.getFile().transferTo(new File(path+"/"+fileName));
			uploadDTO.setFileName(fileName);
			uploadDTO.setFileSize(uploadDTO.getFile().getSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "uploadResult";
	}
	
	@RequestMapping("/downList.do") //downList.jsp
	public void downList(Model model, HttpSession session) {
		String path = session.getServletContext().getRealPath("/WEB-INF/save");
		File fileDir = new File(path);
		if(fileDir.exists()) {
			String fileNames[] = fileDir.list();
			model.addAttribute("fileNames",fileNames);
		}
	}
	
	@RequestMapping("/down.do")
	public ModelAndView down(String fname,HttpSession session){
		ModelAndView mv = new ModelAndView();
		String path = 
				session.getServletContext().getRealPath("/WEB-INF/save");
		mv.addObject("fname",new File(path + "/" + fname));
		mv.setViewName("downLoadView"); //bean의 id를 찾을 수 있도록 ...
		return mv;
	}
}
