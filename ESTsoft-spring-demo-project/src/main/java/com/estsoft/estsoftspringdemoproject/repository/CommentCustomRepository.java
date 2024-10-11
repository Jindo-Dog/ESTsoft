package com.estsoft.estsoftspringdemoproject.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CommentCustomRepository {
	/*@PersistenceContext
	private EntityManager em;

	public List<CommentDTO> getCommentList() {
		List<UserDTO> result = em.createNamedQuery("CommentDTO").getResultList();
	}*/
}
