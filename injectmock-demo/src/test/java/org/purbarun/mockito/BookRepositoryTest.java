package org.purbarun.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class BookRepositoryTest {
	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private BookService bookService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("Actual Call is Mocked Successfully")
	void test() {
		when(bookRepository.getBookById(anyInt())).thenReturn(mockedValue());
		Book actualBook = bookService.getBookById(3);
		verify(bookRepository, times(1)).getBookById(anyInt());
		assertAll(() -> assertEquals(2, actualBook.getId()), () -> assertEquals("Mocked Book", actualBook.getName()));
	}

	private Book mockedValue() {
		return new Book(2, "Mocked Book");
	}

}
