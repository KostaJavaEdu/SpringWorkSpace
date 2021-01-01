package kosta.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyDTO {
//	reply_no INT PRIMARY KEY,
//    comment_No INT REFERENCES commentb(comment_No),
//    user_id VARCHAR2(20) REFERENCES users(user_id),
//    reply_content VARCHAR2(100),
//    reg_date date
	private int replyNo;
	private int commentNo;
	private String userId;
	private String replyContent;
	private String regDate;

	}
