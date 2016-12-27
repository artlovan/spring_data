package org.spring.data;

import org.spring.data.entiries.Book;
import org.spring.data.repositories.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootApplication
//@EnableJpaRepositories
public class SpringDataApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);

		Book book = new Book();
		book.setDate(new Date());
		book.setPrice(new BigDecimal(9.99));
		book.setTitle("Book Title");
		book.setPageCount(200);

		repository.save(book);

		List<Book> books = repository.findAll();

		printAllBooks(books);

		Book b1 = repository.findOne(4L);
		b1.setTitle("New Book Title");

		repository.save(b1);
		books = repository.findAll();
		printAllBooks(books);

		Book b2 = repository.findOne(1L);
		b2.setId(100L);
		repository.save(b2);

		books = repository.findAll();
		printAllBooks(books);

	}

	private static void printAllBooks(List<Book> books) {
		boolean hasBooks = books.stream().anyMatch(b -> books.size() > 0);

		if (hasBooks) System.out.println("\n************** All Books **************");
		books.forEach(SpringDataApplication::printBook);
		if (hasBooks) System.out.println("************** End All Books **************\n");
	}

	private static void printBook(Book b) {
			System.out.println("-- Book --");
			System.out.println(b.getId());
			System.out.println(b.getDate());
			System.out.println(b.getPrice());
			System.out.println(b.getTitle());
			System.out.println(b.getPageCount());
			System.out.println("\n");
	}
}
