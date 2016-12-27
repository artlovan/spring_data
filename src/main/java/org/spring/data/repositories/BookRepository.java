package org.spring.data.repositories;

import org.spring.data.entiries.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // string operations
    Book findByTitle(String title);

    List<Book> findByTitleLike(String title);

    List<Book> findByTitleContaining(String title);

    List<Book> findByTitleStartingWith(String title);

    List<Book> findByTitleIgnoreCase(String title);

    // relational operations
    List<Book> findByPageCountEquals(int pageCount);

    List<Book> findByPageCountGreaterThan(int pageCount);

    List<Book> findByPageCountGreaterThanEqual(int pageCount);

    List<Book> findByPageCountLessThan(int pageCount);

    List<Book> findByPageCountLessThanEqual(int pageCount);

    List<Book> findByPageCountBetween(int min, int max);

    // logical operations
    List<Book> findByTitleContainingOrTitleContaining(String title1, String title2);

    List<Book> findByTitleContainingAndPageCountGreaterThan(String title, int pageCount);

    List<Book> findByTitleNot(String title);

    // date comparison
    List<Book> findByPublishDateAfter(Date date);

    List<Book> findByPublishDateBefore(Date date);

    List<Book> findByPublishDateBetween(Date date1, Date date2);

    // ordering results
    List<Book> findByTitleContainingOrderByTitleAsc(String title);

    List<Book> findByTitleContainingOrderByTitleDesc(String title);

    // limiting query results
    List<Book> findFirstByOrderByPageCountDesc();

    List<Book> findTopByOrderByPageCountDesc();

    List<Book> findTop5ByOrderByPriceDesc();

    List<Book> findTop5ByTitleOrderByPriceAsc(String title);
}
