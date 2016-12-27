package org.spring.data;

import org.spring.data.entiries.Book;
import org.spring.data.repositories.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
@EnableJpaRepositories
public class SpringDataApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataApplication.class, args);
		BookRepository bookRepository = context.getBean(BookRepository.class);

//		Book book = new Book();
//		book.setDate(new Date());
//		book.setPrice(new BigDecimal(14.99));
//		book.setTitle("See You At The Top");
//		book.setPageCount(480);

//		bookRepository.save(book);

		List<Book> books = bookRepository.findAll();

		boolean hasBooks = books.stream().anyMatch(b -> books.size() > 0);

		if (hasBooks) System.out.println("\n************** All Books ************** ");

		books.forEach(b -> {
			System.out.println("-- Book --");
			System.out.println(b.getId());
			System.out.println(b.getDate());
			System.out.println(b.getPrice());
			System.out.println(b.getTitle());
			System.out.println(b.getPageCount());
			System.out.println("\n");
		});
	}
}
