package org.purbarun.mockito;

public class BookService {
	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	Book getBookById(int id){
		return bookRepository.getBookById(id);
	}
}
