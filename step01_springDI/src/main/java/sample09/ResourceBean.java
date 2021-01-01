package sample09;

import javax.annotation.Resource;

public class ResourceBean {
	
	@Resource(name = "dto") //설정된 name은 xml의 id="이름" 과 동일
	private EmpDTO emp1;
	
	
	@Resource(name = "emp1")
	private EmpDTO emp2;
	
	@Resource(name = "service")
	private EmpService service;
	
	@Resource(name = "controller")
	private EmpController controller;
	
	public void test() {
		System.out.println("emp1 : " + emp1);
		System.out.println("emp2 : " + emp2);
		System.out.println("service : " + service);
		System.out.println("controller : " + controller);
		
	}
}
