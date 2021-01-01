package kosta.exam.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import kosta.exam.domain.Member;
import kosta.exam.domain.Team;

public class AssociationMainApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = 
				emf.createEntityManager();
		EntityTransaction tx = 
				em.getTransaction();
		tx.begin();
		
		//팀 추가
//		Team team1 = new Team(null, "술정");
//		Team team2 = new Team(null, "러닝머신");
//		  em.persist(team1);
//		  em.persist(team2);
//		//회원 추가
//		Member member1 = new Member(null, "수녕", 24, team1);
//		Member member2 = new Member(null, "은진", 24, team1);
//		Member member3 = new Member(null, "나현", 27, team2);
//	    Member member4 = new Member(null, "지연", 27, team2);
//		  em.persist(member1);
//		  em.persist(member2);
//		  em.persist(member3);
//		  em.persist(member4);
		
		//회원 검색
//		Member member = em.find(Member.class, 50L); //ManyToOne : 즉시로딩
//		System.out.println(member);
//		System.out.println(member.getTeam());
		
		//OneToMany
		Team team = em.find(Team.class, 48L);
		System.out.println(team);
		System.out.println("인원 : " + team.getList().size());
		
		  tx.commit();
		
		em.close();
		emf.close();
	}
}
