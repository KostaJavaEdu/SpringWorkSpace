package kosta.main;



import java.util.HashMap;
import java.util.Map;

import kosta.repository.ProductDAO;

public class ProductMainView {
  public static void main(String[] args) {
	  /**
	   * 
		4. 주어진 ProductMainView.java을 보고
   		dao 클래스, dto클래스, Mapper를 만든다.
	   * */
	  
	  
	  /**
	   * [1]. 레코드 삽입
	   * */
	 // System.out.println("********** [1] 상품 등록하기 ******************");
	  //ProductDAO.insert(new ProductListDTO("A06", "감자칩", 30, 3000, "짭쪼름"));
	  
	  /**
	   * [2].   ex) select * from productList
	   *         ex)  select * from productList where 검색필드 like  검색단어
	   *          ex) select *from productList order by 정렬대상
	   *          ex) select * from productList where 검색필드 like  검색단어  order by 정렬대상
	   * */
	  //System.out.println("********** [2] 모든 게시물 검색 또는 조건에 따른 검색 및 정렬 ******************");
	  //이거 모르겠다!!!!!!!!!!!! 난 바보야!!!!!!!!!!!!
	  Map<String, String> map = new HashMap<String, String>();
	  map.put("keyField", "detail");
	  map.put("keyWord", "맛");
	  map.put("order", "QTY");
	  ProductDAO.selectByKeyword(map);
	 
	  /**
	   * [3].  parameter 정보에 따라 레코드 수정한다.
	   *     상품코드에 해당하는 상품의 
	   *     상품이름, 상품수량, 상품가격, 상품상세정보를 수정하데 parameter 의 정보가 있는 데이터만 수정한다.
	   * 
	   * */
	  //System.out.println("********** [3] 상품 수정하기 ******************");
	  //ProductDAO.update(new ProductListDTO("A01", "수녕", 1, 3000, "어벤저스"));
	
	  /**
	   * [4].상품코드에 해당하는 레코드 삭제
	   * */
	  //System.out.println("********** [4] 상품 삭제하기 ******************");
	  //ProductDAO.delete("A02");
	  
	 /**
	  * [5]. 모든 상품의 개수를 출력한다.

		  select sum(p_qty) from product -- 모든상품의 qty의총합계
	  * */
	  //System.out.println("********** [5] 등록된 총 상품 개수 ******************");
	  //ProductDAO.count();
	  
	  /**
	   * [6]. parameter의 상품코드에 해당하는 레코드 검색
	   * ex)select * from productList where in 상품코드 in (?,?,...)
	   * */
//	  System.out.println("********** [6] 상품코드에 해당하는 레코드 검색 ******************");
//	  List<String> list = new ArrayList<String>();
//	  list.add("A01");
//	  list.add("A03");
//	  ProductDAO.selectParameter(list);

	}
}







