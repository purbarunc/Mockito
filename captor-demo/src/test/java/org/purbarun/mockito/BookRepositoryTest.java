package org.purbarun.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class BookRepositoryTest {
	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private BookService bookService;
	
	@Captor
	ArgumentCaptor<Integer> captor;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("ArgumentCaptor is Successful")
	void test() {
		bookService.getBookById(3);
		verify(bookRepository).getBookById(captor.capture());
		int value = captor.getValue();
		assertEquals(3, value);
	}
}
