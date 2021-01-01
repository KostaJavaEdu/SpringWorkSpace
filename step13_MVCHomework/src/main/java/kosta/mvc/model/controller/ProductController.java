package kosta.mvc.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;
import kosta.mvc.model.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/select.kosta")
	public String select(Model model) {
		List<ProductDTO> list = productService.select();
		model.addAttribute("list",list);
		return "productList";
	}
	
	@RequestMapping("/{insertForm}.kosta")
	public void insertForm() {
		
	}
	
	@RequestMapping("/insert.kosta")
	public String insert(ProductDTO productDTO) throws MyErrorException{
			int rsult = productService.insert(productDTO);

		return "redirect:select.kosta";
	}
	
	@RequestMapping("/delete.kosta")
	public String delete(String code) throws MyErrorException{
			//System.out.println(code+"코드나오니?????");
			int rsult = productService.delete(code);

		return "redirect:select.kosta";
	}
	
	
	@ExceptionHandler(MyErrorException.class)
	public ModelAndView error(MyErrorException e) {
		System.out.println("오류정보 : " + e.getMessage());
		return new ModelAndView("error/error" , "errMsg", e.getMessage());
	}
	

}
