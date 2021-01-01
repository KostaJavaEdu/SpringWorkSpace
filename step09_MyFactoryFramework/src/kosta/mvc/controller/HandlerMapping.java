package kosta.mvc.controller;

public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {}
	
	public static HandlerMapping getFactory() {
		return factory;
	}
	/**
	 * 요청에 해당하는 Controller를 찾아서 생성해준다.
	 * */
	
	public Controller createController (String command){
		Controller controller = null;
		if(command.equals("insert")) {
			controller = new InsertController();
		}else if(command.equals("delete")) {
			controller = new DeleteController();
		}else if(command.equals("select")) {
			controller = new SelectController();
		}
		
		return controller;
	}
}
