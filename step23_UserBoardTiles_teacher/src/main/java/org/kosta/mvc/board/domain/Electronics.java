package org.kosta.mvc.board.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
