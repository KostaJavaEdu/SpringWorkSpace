package sample08;

public class BookServiceImpl implements BookService {
	private MessangerSender messangerSender;
	private EmailSender emailSender;
	private BookDAO bookDAO;
	
	public BookServiceImpl() {}
	public BookServiceImpl(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	public void setEmailSender(EmailSender emailSender) {
		this.emailSender = emailSender;
	}
	
	public void setMessangerSender(MessangerSender messangerSender) {
		this.messangerSender = messangerSender;
	}
	
	@Override
	public void save(BookDTO bookDTO, BookDTO bookDTO2) {
		bookDAO.save(emailSender, messangerSender, bookDTO, bookDTO2);

	}

}
