package sample04;

public class StudentDAOImpl implements StudentDAO {
	public StudentDAOImpl() {
		System.out.println("StudentDAOImpl() 생성자 호출됨");
	}
	@Override
	public void insert(Student student) {
		System.out.println("StudentDAOImpl의 insert호출됨");
		System.out.println("name : " + student.getName());
		System.out.println("no : " + student.getNo());
		System.out.println("phone : " + student.getPhone());
		System.out.println("addr : " + student.getAddr());
	}
}
