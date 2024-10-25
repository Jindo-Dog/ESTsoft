package com.estsoft.estsoftspringproject.blog.coltroller.externalAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Content {
	private String title;
	private String body;

	@Override
	public String toString() {
		return "#title: " + title + "body: " + body + "\n";
	}
}