package com.estsoft.estsoftspringproject.blog.coltroller.externalAPI;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContentTest {
	@Test
	@DisplayName("주어진 제목과 본문으로 Content 객체를 생성할 때, toString() 메서드는 올바른 문자열을 반환해야 한다.")
	void testToString() {
		// given
		String title = "테스트 제목";
		String body = "테스트 본문";
		Content content = new Content(title, body);

		// when
		String result = content.toString();

		// then
		String expected = "#title: " + title + "body: " + body + "\n";
		assertThat(expected).isEqualTo(result);
	}
}