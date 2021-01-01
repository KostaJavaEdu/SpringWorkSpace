package kosta.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kosta.domain.ProductListDTO;


public interface ProductMapper {
	
	@Insert("insert into productlist values(#{code},#{name},#{qty},#{price},#{detail})")
	int insert(ProductListDTO product);
	
	/*parameter 정보에 따라 레코드 수정한다.
	   *     상품코드에 해당하는 상품의 
	   *     상품이름, 상품수량, 상품가격, 상품상세정보를 수정하데 parameter 의 정보가 있는 데이터만 수정한다.*/
	@Update("update productlist set name=#{name}, qty=#{qty}, price=#{price}, detail=#{detail} where code=#{code}")
	int update(ProductListDTO product);
	
	@Delete("delete from productlist where code = #{_parameter}")
	int delete(String code);
	
	//select sum(qty) from product -- 모든상품의 qty의총합계
	@Select("select sum(qty) from productList")
	int count();
	
}
