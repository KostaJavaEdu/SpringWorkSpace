package kosta.mvc.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.ProductDTO;
import kosta.mvc.model.exception.MyErrorException;

@Repository
public class ProductDAOImpl implements ProductDAO {
	/**
	 * 예외상황(사용자정의 Exception처리한다 – 예외클래스 1개(MyErrorException웅앵)
		-상품코드는 중복체크 - dao에서 체크
		-가격은 1000 ~ 10000만원 사이만 가능. --service체크

	 * */
	@Autowired
	private List<ProductDTO> list;

	@Override
	public List<ProductDTO> select() {
		return list;
	}
	
	public ProductDTO searchByCode(String code) { //code에 해당하는 dto찾기
		for( ProductDTO dto : list) {
			if(dto.getCode().equals(code)) {
				return dto;
			}
		}
		return null;
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException { //1이면 성공 0이면 실패
		ProductDTO dto = this.searchByCode(productDTO.getCode());
		if(dto != null) {
			throw new MyErrorException("중복코드입니다.");
		}else {
			boolean result = list.add(productDTO);
			if(result) return 1;
		}
		return 0;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		ProductDTO dto = this.searchByCode(code);
		boolean result = list.remove(dto);
		if(result) return 1;
		return 0;
	}

}
