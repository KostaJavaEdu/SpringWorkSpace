package kosta.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.domain.CommentbDTO;
import kosta.domain.ReplyDTO;

public class EmpDAO {
	
	/**
	 * 1 : 1 인 경우
	 * */
	public static void associationTest() {
		try( SqlSession session = DbUtil.getSession()){
			List<CommentbDTO> list = 
					session.selectList("JoinMapper.associationJoin");
			
			for( CommentbDTO dto : list) {
				System.out.print(dto.getCommentNo() + "|");
				System.out.print(dto.getUser().getUserName() + "|");
				System.out.print(dto.getCommentContent() + "|");
				System.out.print(dto.getRegDate() + "\n");
			}
		}
	}
	
	/**
	 * 1 : 다 인 경우
	 * */
	public static void collectionTest() {
		try( SqlSession session = DbUtil.getSession()){
			List<CommentbDTO> list = 
					session.selectList("JoinMapper.collectionJoin");
			
			System.out.println("개수 : " + list.size());
			for( CommentbDTO dto : list) {
				System.out.println(dto.getCommentNo() + "의 답변 ");
				for( ReplyDTO reply : dto.getReplies()) {
					System.out.print(reply.getReplyNo()+"|");
					System.out.print(reply.getReplyContent()+"|");
					System.out.print(reply.getUserId()+"|");
					System.out.print(reply.getRegDate()+"\n");
				}
			}
		}
	}
	
	/**
	 * 캐멀 & 언더스코어
	 * */
	
	public static void test() {
		try( SqlSession session = DbUtil.getSession()){
			List<CommentbDTO> list = 
					session.selectList("JoinMapper.selectAll");
			for(CommentbDTO dto : list) {
				System.out.print(dto.getCommentNo() + "|");
				System.out.print(dto.getCommentContent() + "|");
				System.out.print(dto.getUserId() + "|");
				System.out.print(dto.getRegDate() + "\n");
			}
		
		}
	}
	
	/**
	 * insert
	 * */
	public static void insert(CommentbDTO dto) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			state = session.insert("JoinMapper.insert", dto) > 0 ? true : false;
			if(state) System.out.println("삽입성공");
			else System.out.println("삽입실패");
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
}