package org.purbarun.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

class BookRepositoryTest {

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("Mocked call is successful")
	void test() {
		try (MockedStatic<BookRepository> bookRepository = mockStatic(BookRepository.class)) {
			bookRepository.when(() -> BookRepository.getBookById(anyInt())).thenReturn(mockedValue());
			Book actual = BookRepository.getBookById(2);
			bookRepository.verify(() -> BookRepository.getBookById(anyInt()), times(1));
			assertAll(() -> assertEquals(2, actual.getId()), () -> assertEquals("Mocked Book", actual.getName()));
		}
	}

	private Book mockedValue() {
		return new Book(2, "Mocked Book");
	}

}
