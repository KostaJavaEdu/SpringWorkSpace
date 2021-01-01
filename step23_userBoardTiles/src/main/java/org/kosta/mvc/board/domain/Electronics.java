package org.kosta.mvc.board.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Electronics {

	private String modelNum;
	private String modelName;
	private int price;
	private String description;
	private String password;
	private String writeday;
	private int readnum;
	private String fname;
	private long fsize;
	
	private MultipartFile file; //<input type="file" name="file"
}

