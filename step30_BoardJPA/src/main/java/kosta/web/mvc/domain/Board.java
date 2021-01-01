package kosta.web.mvc.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO , generator = "seq_no")
	@SequenceGenerator(sequenceName = "seq_no",name = "seq_no",allocationSize = 1)
	private Long id;
	private String subject;
	private String writer;
	private String content;
	private String password;
	private int readnum;//조회수 증가
	@CreationTimestamp
	private Date writeday;
}
