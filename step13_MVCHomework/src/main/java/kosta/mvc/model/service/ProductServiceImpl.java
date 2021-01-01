package kosta.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.ProductDAO;
import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<ProductDTO> select() {
		List<ProductDTO> list = productDAO.select();
		return list;
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		int result = 0;
		if(productDTO.getPrice()>=1000 && productDTO.getPrice()<=10000) {
			result = productDAO.insert(productDTO);
			if(result==0) {
				throw new MyErrorException("등록에 실패하였습니다.");
			}
		}else {
			throw new MyErrorException("가격이 1000~10000이상입니다.");
		}
		return result;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		int result = productDAO.delete(code);
		if(result==0) {
			throw new MyErrorException("삭제에 실패하였습니다.");
		}
		return result;
	}

}
