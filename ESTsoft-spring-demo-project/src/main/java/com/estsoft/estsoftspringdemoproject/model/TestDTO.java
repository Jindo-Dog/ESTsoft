package com.estsoft.estsoftspringdemoproject.model;

import lombok.Data;

@Data
public class TestDTO {
	// post, comment
	/*
	SELECT t1.id, t1.title, t1.content, COUNT(t2.id), COUNT(t3.id)
	FROM posts t1
	LEFT OUTER JOIN comments t2 ON t1.id = t2.post_id
	LEFT OUTER JOIN likes t3 ON t1.id = t3.post_id
	GROUP BY t1.id;, t1.title, t1.content;
	 */
	private Long postId;
	private String title;
	private String content;
	private String commentId;
	private String commentContent;
	// private Integer commentCount;
	// private Integer likeCount;
	private Long userId;
}
