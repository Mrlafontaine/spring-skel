package com.sekl.demo.services;

import com.sekl.demo.entities.Category;
import com.sekl.demo.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Slf4j
@TestInstance(Lifecycle.PER_CLASS)
public class CategoryServiceTest {

	CategoryService categoryService;

	CategoryRepository categoryRepository;

	@BeforeAll
	public void before() {

		categoryRepository = mock(CategoryRepository.class);
		categoryService = new CategoryService(categoryRepository);

	}

	@Test
	public void findAll_withNElement_returnListNElement() {
		// Arrange
		List<Category> mockEntities = new ArrayList<>();
		when(categoryRepository.findAll()).thenReturn(mockEntities);

		// Act
		List<Category> entities = categoryService.findAll();

		// Assert
		assertEquals(mockEntities.size(), entities.size(), "He did not returned elements");

	}

}
