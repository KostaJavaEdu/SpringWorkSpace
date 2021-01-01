package sample11;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private MessangerSender messangerSender;
	
	@Autowired
	private EmailSender emailSender;
	
	@Autowired
	private BookDAO bookDAO;
	
	public BookServiceImpl() {}
	
	@Override
	public void save(BookDTO bookDTO, BookDTO bookDTO2) {
		bookDAO.save(emailSender, messangerSender, bookDTO, bookDTO2);

	}

}
