package fin.fintechpath.com.BookStoresSystem.repository;

import fin.fintechpath.com.BookStoresSystem.model.Book;
import fin.fintechpath.com.BookStoresSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
