package com.estsoft.estsoftspringdemoproject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.estsoft.estsoftspringdemoproject.entity.QComment;
import com.estsoft.estsoftspringdemoproject.entity.QPost;
import com.estsoft.estsoftspringdemoproject.model.TestDTO;
import com.estsoft.estsoftspringdemoproject.model.TestDTO2;
import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class TestRepositoryQueryDslImpl implements TestRepository {
	@Autowired
	private JPAQueryFactory jpaQueryFactory;

	@Override
	public List<TestDTO> selectPostTest() {
		QPost qpost = QPost.post;
		QComment qcomment = QComment.comment;
		/*
		SELECT t1.id AS postId, t1.title, t1.content, t2.id AS commentId, t2.content AS commentContent
		FROM posts t1
		LEFT OUTER JOIN comments t2 ON t1.id = t2.post_id
		 */
		var result = jpaQueryFactory
			.select(
				Projections.constructor(
					TestDTO.class,
					qpost.id,
					qpost.title,
					qpost.content,
					qcomment.id,
					qcomment.content,
					qpost.userId
				)
			)
			.from(qpost)
			.leftJoin(qcomment).on(qpost.id.eq(qcomment.post.id))
			.fetch();

		return result;
	}

	@Override
	public List<TestDTO2> selectPostWithCount() {
		QPost qpost = QPost.post;
		QComment qcomment = QComment.comment;

		var result = jpaQueryFactory
			.select(
				Projections.constructor(
					TestDTO2.class,
					qpost.id,
					qpost.title,
					qpost.content,
					qcomment.id.count().as("commentCount"),
					qpost.userId
				)
			)
			.from(qpost)
			.leftJoin(qcomment).on(qpost.id.eq(qcomment.post.id))
			.groupBy(qpost.id, qpost.title, qpost.content)
			.fetch();

		return result;
	}
}
