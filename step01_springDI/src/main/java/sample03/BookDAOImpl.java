package sample03;

public class BookDAOImpl implements BookDAO {

	@Override
	public void insert(BookVo bookVo) {
		System.out.println("BookDAOImpl insert 호출됨!!!");
		System.out.println("과목 : "+bookVo.getSubject());
		System.out.println("작성자 : "+bookVo.getWriter());
		System.out.println("가격 : "+bookVo.getPrice());
		System.out.println("날자 : "+bookVo.getDate());
	}
}
