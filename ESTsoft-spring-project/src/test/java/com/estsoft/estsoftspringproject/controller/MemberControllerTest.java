package com.estsoft.estsoftspringproject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.estsoft.estsoftspringproject.member.repository.MemberRepository;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {
	@Autowired
	WebApplicationContext context;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	MemberRepository repository;

	@BeforeEach
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	// @Test
	@DisplayName("모든 멤버 조회")
	public void testGetAllMember() throws Exception {
		// given: 멤버 목록 저장 (생략)

		// when: GET /members
		ResultActions resultActions = mockMvc.perform(get("/members")
			.accept(MediaType.APPLICATION_JSON));

		// then: response 검증
		resultActions.andExpect(status().is2xxSuccessful())
			.andExpect(jsonPath("$[0].id").value(1))
			.andExpect(jsonPath("$[1].id").value(2));
	}
}