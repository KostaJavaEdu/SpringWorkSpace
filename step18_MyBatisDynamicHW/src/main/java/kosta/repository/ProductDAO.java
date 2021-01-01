package kosta.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.KeySelector.Purpose;

import org.apache.ibatis.session.SqlSession;

import kosta.domain.ProductDTO;

public class ProductDAO {
	public static int insert(ProductDTO productDTO) {
		boolean state = false;
		int result;
		SqlSession session = null;

		try {
			session = DbUtil.getSession();
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			result = mapper.insert(productDTO);

			if (result > 0) {
				state = true;
				System.out.println("등록 성공");
			} else
				System.out.println("등록 실패");

		} finally {
			DbUtil.sessionClose(session, state);
		}

		return result;
	}

	public static List<ProductDTO> select(ProductDTO productDTO, 
			String keyfield) {
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productDTO", productDTO);
		map.put("orderColumn", keyfield);
		
		try (SqlSession session = DbUtil.getSession()) {
			list = session.selectList("ProductDynamicMapper.select", map);

			for (ProductDTO dto : list)
				System.out.println(dto);
		}

		return list;
	}

	public static int update(ProductDTO productDTO) {
		SqlSession session = null;
		boolean state = false;
		int result = 0;
		try {
			session = DbUtil.getSession();
			result = session.update("ProductDynamicMapper.update", productDTO);

			if (result > 0) {
				state = true;
				System.out.println("수정 성공");
			} else
				System.out.println("수정 성공");

		} finally {
			DbUtil.sessionClose(session, state);
		}
		return result;
	}

	public static int delete(String code) {
		SqlSession session = null;
		boolean state = false;
		int result = 0;
		try {
			session = DbUtil.getSession();
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			result = mapper.delete(code);

			if (result > 0) {
				state = true;
				System.out.println("삭제 성공");
			} else
				System.out.println("삭제 실패");

		} finally {
			DbUtil.sessionClose(session, state);
		}

		return result;
	}

	public static int selectCount() {
		SqlSession session = null;
		int result = 0;
		try {
			session = DbUtil.getSession();
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			result = mapper.selectCount();
			
			System.out.println(result);
		} finally {
			DbUtil.sessionClose(session);
		}
		
		return result;
	}
	public static int selectQty() {
		SqlSession session = null;
		int result = 0;
		try {
			session = DbUtil.getSession();
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			result = mapper.selectQty();

			System.out.println(result);
		} finally {
			DbUtil.sessionClose(session);
		}

		return result;
	}
	
	public static List<ProductDTO> selectByCode(List<String> list){
		List<ProductDTO> result = new ArrayList<ProductDTO>();

		for(String f : list)
			System.out.println(f);
		try (SqlSession session = DbUtil.getSession()){
			result = session.selectList("ProductDynamicMapper.selectByCode", list);
			
			for(ProductDTO dto : result)
				System.out.println(dto);
		}
		
		return result;
	}
}
