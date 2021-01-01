package sample06;

import java.util.List;

public class ListBean {
	private List<Integer> intList;
	private List<String> strList;
	private List<Customer> customerList;
	public List<Integer> getIntList() {
		return intList;
	}
	public void setIntList(List<Integer> intList) {
		this.intList = intList;
		System.out.println("setIntList(List<Integer> intList) 호출됨.. : intList" + intList);
	}
	public List<String> getStrList() {
		return strList;
	}
	public void setStrList(List<String> strList) {
		this.strList = strList;
		System.out.println("setStrList(List<String> strList) 호출됨.. : strList" + strList);
	}
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
		System.out.println("setCustomerList(List<Customer> customerList) 호출됨.. : customerList" + customerList);
	}
	
	
	
	
}
