package sample11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sample11.BookDAO;

@Repository //id="bookDAOImpl
public class BookDAOImpl implements BookDAO {
	
	@Autowired 
	private DbUtil dbUtil;

	public BookDAOImpl() {}
	
	@Override
	public void save(EmailSender emailSender, MessangerSender messagerSender, BookDTO book1, BookDTO book2) {
		System.out.println("emailSender = " + emailSender);
		System.out.println("messageSender = " + messagerSender);
		System.out.println("book1 = " + book1);
		System.out.println("book2 = " + book2);
		System.out.println("dbUtil = " + dbUtil);
		
	}
}
