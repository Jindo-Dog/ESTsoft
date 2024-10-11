package com.estsoft.estsoftspringdemoproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estsoft.estsoftspringdemoproject.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	Optional<Comment> findByIdAndIsDeleted(Long commentId, Boolean isDeleted);

	// 댓글이 제일많이 달린 게시글을 조회하는 쿼리. 댓글이 가장많은 순서대로 정렬
	// select post_id, count(1) from comment group by post_id order by count(1) desc
	// postId: 1, count: 6
	// HQL -> ORM, JPA entity hibernate. hibernate query language HQL -> sql + entity
	@Query("SELECT comm.post, COUNT(comm) FROM Comment comm GROUP BY comm.post ORDER BY COUNT(comm) DESC")
	List<Object[]> findCommentCountByPost();
}
