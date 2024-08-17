package org.purbarun.mockito;

public class BookRepository {
	Book getBookById(int id) {
		// Imagine this to be an actual DB call
		return getBook(id);
	}

	private Book getBook(int id) {
		return new Book(id, "Test Book");
	}
}
