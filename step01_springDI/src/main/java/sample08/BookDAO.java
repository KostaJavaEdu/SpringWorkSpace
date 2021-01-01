package sample08;

public interface BookDAO {
	void save(EmailSender emailSender,MessangerSender messagerSender, BookDTO bookDTO, BookDTO bookDTO2);
}
