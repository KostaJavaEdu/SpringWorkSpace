package kosta.exam.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import kosta.exam.domain.Customer;

public class MainApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject"); //경로는 이미 지정되어있으므로 따로 안해줘도 됨(META-INF/persistence.xml)
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//1. 등록
//		Customer cu = new Customer(null, "이효정", 25, null);
//		Customer cu2 = new Customer(null, "정채연", 26, null);
//		em.persist(cu);
//		em.persist(cu2);
		
		//2. 검색
		Customer cu = em.find(Customer.class, 3L);
		System.out.println(cu);
		
		//3. 수정
		cu.setAge(100);
		cu.setName("할머니");
		
		//4. 삭제
		em.remove(cu);
		
		tx.commit();
		
		em.close();
		emf.close();
		
		System.out.println(emf+"\n--End--");
	}

}
