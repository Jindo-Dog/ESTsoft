package com.estsoft.estsoftspringdemoproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estsoft.estsoftspringdemoproject.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	// SELECT * FROM post WHERE is_deleted = 0 ORDER BY created_at DESC
	List<Post> findAllByIsDeletedOrderByCreatedAtDesc(boolean isDeleted);

	// SELECT * FROM post WHERE id = :postId AND is_deleted = :isDeleted
	Post findByIdAndIsDeleted(Long postId, boolean isDeleted);
}
