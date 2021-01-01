package kosta.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kosta.domain.ProductDTO;

public interface ProductMapper {
	@Insert("insert into productList values (#{code}, #{name}, #{qty}, #{price}, #{detail})")
	int insert(ProductDTO productDTO);
	
	@Delete("delete from productList where code = #{code}")
	int delete(String code);

	@Select("select count(*) from productlist")
	int selectCount();
	
	@Select("select sum(qty) from productlist")
	int selectQty();
}
