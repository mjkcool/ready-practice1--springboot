package com.mirim;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mirim.domain.Board;
import com.mirim.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
//	public void testGetBoard(){
//		Board board = boardRepo.findById(1L).get();
//		System.out.println(board.toString());
//	}
	public void testInsertBoard() {
		Board board = new Board();
		board.setTitle("첫번째 게시글");
		board.setWriter("mirim");
		board.setContent("안녕하시오");
		board.setCreateDate(new Date());
		board.setCnt(0L);
		
		boardRepo.save(board);
	}
}
