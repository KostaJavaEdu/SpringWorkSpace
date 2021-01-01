package kosta.exam.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//@Table("바꾸고 싶은 테이블 이름")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"list"})
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //지금 사용하는 방언에 따라 자동증가 컬럼으로 만들어줌
	private Long teamId;
	private String teamName;
	
	@OneToMany(mappedBy = "team") //지연로딩(디폴트 값임)
	//@OneToMany(mappedBy = "team", fetch = FetchType.EAGER) //즉시로딩
	private List<Member> list = new ArrayList<Member>();
}
