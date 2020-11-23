package com.mirim;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mirim.domain.Board;

public class JPAClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest");
		EntityManager em = emf.createEntityManager();
		//Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {
			//트랜잭션 시작
			tx.begin();
			Board board = new Board();
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JPA 글 등록이 잘 됨");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			em.persist(board);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close(); emf.close();
		}
	}

}
