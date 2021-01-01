package kosta.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CommentbDTO {
	
//	 comment_No INT PRIMARY KEY,
//     user_id VARCHAR2(20) REFERENCES users(user_id),
//     comment_Content VARCHAR2(100),
//     reg_Date date
	
	private int commentNo;
	private String userId;
	private String commentContent;
	private String regDate;
	
	//1 : 1인 경우
	private UserDTO user;
	
	//1 : 다인 경우
	private List<ReplyDTO> replies;
}
