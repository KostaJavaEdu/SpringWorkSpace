package sample10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller //id="boardController"
public class BoardController {
	@Autowired 
	private BoardDTO boardDTO;
	
	@Autowired
	private BoardDTO boardDTO2;
	
	@Autowired //byType으로 주입
	private BoardService boardService;
	
	public void test() {
		System.out.println("boardDTO : " + boardDTO + boardDTO.getContent());
		System.out.println("boardDTO2 : " + boardDTO2 + boardDTO2.getContent());
		System.out.println("boardService : " + boardService);
		boardService.select();
	}
}
