package org.purbarun.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

class BookRepositoryTest {
	@Spy
	private BookRepository bookRepository;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("Mocked call is successful")
	void test() {
		when(bookRepository.getBookById(anyInt())).thenReturn(mockedValue());
		Book actualBook = bookRepository.getBookById(3);
		verify(bookRepository, times(1)).getBookById(anyInt());
		assertAll(() -> assertEquals(2, actualBook.getId()), () -> assertEquals("Mocked Book", actualBook.getName()));
	}

	@Test
	@DisplayName("Unmocked call is successful")
	void test1() {
		/*
		 * This will give org.opentest4j.MultipleFailuresError with @Mock, if the call
		 * is not stubbed before.
		 */
		Book actualBook = bookRepository.getBookById(3);
		verify(bookRepository, times(1)).getBookById(anyInt());
		assertAll(() -> assertEquals(3, actualBook.getId()), () -> assertEquals("Test Book", actualBook.getName()));
	}

	private Book mockedValue() {
		return new Book(2, "Mocked Book");
	}

}
