package sample04;

public class StudentController {
	private StudentService studentService;
	private Student student;
	
	public StudentController() {
		System.out.println("StudentController() 생성자 호출...");
	}
	
	public void setStudent(Student student) {
		this.student = student;
		System.out.println("setStudent(Student student) 호출... : " + student);
	}
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
		System.out.println("setStudentService(StudentService studentService) 호출... : " + studentService);
	}
	
	public void insert() {
		//서비스의 serviceInsert() 호출한다.
		studentService.serviceInsert(student);
	}
}
