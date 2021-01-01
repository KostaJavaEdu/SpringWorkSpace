package sample04;

public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDao;
	
	public StudentServiceImpl() {
		System.out.println("StudentServiceImpl() 호출됨...");
	}
	
	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
		System.out.println("setStudentDao(StudentDAO studentDao) 호출됨... : " + studentDao);
	}
	
	@Override
	public void serviceInsert(Student student) {
		//dao의 insert를 호출
		studentDao.insert(student);
	}
}
