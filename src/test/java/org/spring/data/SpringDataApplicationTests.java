package org.spring.data;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.data.entiries.Book;
import org.spring.data.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataApplicationTests {

	@Autowired
	private ConfigurableApplicationContext context;
	private BookRepository repository;

	@Before
	public void setUp() {
		repository = context.getBean(BookRepository.class);
	}

	@Test
	public void contextLoads() {
		assertNotNull(context);
	}

	@Test
	public void bookRepositoryHoldBootstrappedData() {
		List<Book> books = repository.findAll();
		assertTrue(books.size() == 3);
	}

	@Test
	public void bookRepositoryFindByTitle() {
		Book book = repository.findByTitle("No Excuses");
		assertTrue(book.getTitle().equals("No Excuses"));
	}

	@Test
	public void bookRepositoryFindByTitleLike() {
		List<Book> books = repository.findByTitleLike("%No%");
		assertTrue(books.size() == 1);
	}

	@Test
	public void bookRepositoryFindByPageCountBetween() {
		List<Book> books = repository.findByPageCountBetween(10, 1000);
		assertTrue(books.size() == 3);
	}

	@Test
	public void bookRepositoryFindByPageGreaterThan() {
		List<Book> books = repository.findByPageCountEquals(480);
		assertTrue(books.size() == 1);
	}

	@Test
	public void bookRepositoryFindByTitleNot() {
		List<Book> books = repository.findByTitleNot("No Excuses");
		assertTrue(books.size() == 2);
	}

	@Test
	public void bookRepositoryFindByPublishDateAfter() {
		List<Book> books = repository.findByPublishDateBefore(new Date());
		assertTrue(books.size() == 3);
	}

}
