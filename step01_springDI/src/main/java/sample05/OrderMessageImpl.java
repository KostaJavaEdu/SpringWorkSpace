package sample05;

public class OrderMessageImpl implements OrderMessage {

	private int orderId;
	private String message;
	private UserBean userBesn;
	private ProductBean priductBean;
	
	public OrderMessageImpl() {}
	
	@Override
	public void getOrder_Message() {
		System.out.println("orderId : " + orderId);
		System.out.println("name : " + userBesn.getName());
		System.out.println("phone : " + userBesn.getPhone());
		System.out.println("p_name : " + priductBean.getP_name());
		System.out.println("p_price : " + priductBean.getP_price());
		System.out.println("message : " + message);
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public void setUserBesn(UserBean userBesn) {
		this.userBesn = userBesn;
	}


	public void setPriductBean(ProductBean priductBean) {
		this.priductBean = priductBean;
	}
	

}
