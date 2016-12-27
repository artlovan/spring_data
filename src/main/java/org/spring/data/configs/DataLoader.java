package org.spring.data.configs;

import org.spring.data.entiries.Book;
import org.spring.data.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public DataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        Book book1 = new Book();
        book1.setDate(new Date());
        book1.setPrice(new BigDecimal(14.99));
        book1.setTitle("See You At The Top");
        book1.setPageCount(480);

        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setDate(new Date());
        book2.setPrice(new BigDecimal(24.99));
        book2.setTitle("No Excuses");
        book2.setPageCount(280);

        bookRepository.save(book2);

        Book book3 = new Book();
        book3.setDate(new Date());
        book3.setPrice(new BigDecimal(19.99));
        book3.setTitle("The Day That Will Turn Your Life Around");
        book3.setPageCount(340);

        bookRepository.save(book3);
    }
}
