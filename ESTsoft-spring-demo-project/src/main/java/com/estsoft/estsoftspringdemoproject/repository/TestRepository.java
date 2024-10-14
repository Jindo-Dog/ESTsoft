package com.estsoft.estsoftspringdemoproject.repository;

import java.util.List;

import com.estsoft.estsoftspringdemoproject.model.TestDTO;
import com.estsoft.estsoftspringdemoproject.model.TestDTO2;

public interface TestRepository {
	List<TestDTO> selectPostTest();

	List<TestDTO2> selectPostWithCount();
}
