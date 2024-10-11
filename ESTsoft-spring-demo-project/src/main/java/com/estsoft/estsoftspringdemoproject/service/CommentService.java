package com.estsoft.estsoftspringdemoproject.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.estsoft.estsoftspringdemoproject.entity.Post;
import com.estsoft.estsoftspringdemoproject.entity.Comment;
import com.estsoft.estsoftspringdemoproject.model.CommentRequest;
import com.estsoft.estsoftspringdemoproject.repository.CommentRepository;
import com.estsoft.estsoftspringdemoproject.repository.PostRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {

	private final CommentRepository commentRepository;
	private final PostRepository postRepository;

	@Transactional
	public void createComment(CommentRequest request) {
		Post post = postRepository.findById(request.getPostId())
			.orElseThrow(() -> new RuntimeException("post not found"));

		Comment comment = new Comment();
		comment.setContent(request.getContent());
		comment.setPost(post);
		comment.setUserId(1L);
		comment.setIsDeleted(false);
		comment.setCreatedAt(LocalDateTime.now());

		commentRepository.save(comment);
	}

	@Transactional
	public void deleteComment(Long commentId) {
		Comment comment = commentRepository.findByIdAndIsDeleted(commentId, Boolean.FALSE)
			.orElseThrow(() -> new RuntimeException("삭제하려는 댓글이 존재하지 않습니다."));

		comment.setIsDeleted(Boolean.TRUE);
		comment.setDeletedAt(LocalDateTime.now());

		commentRepository.save(comment);
	}

	public List<Object[]> getMostCommentPost() {
		return commentRepository.findCommentCountByPost();
	}
}