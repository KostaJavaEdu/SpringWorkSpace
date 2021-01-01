package kosta.exam.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity //테이블 생성
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
	
	@Id //pk
	@GeneratedValue(strategy = GenerationType.AUTO) //시퀀스??
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	//@Transient //컬럼에서 제외하고 싶을 때
	private int age;
	
	@CreationTimestamp //현재 시간과 날짜 
	private Date regdate;
}
