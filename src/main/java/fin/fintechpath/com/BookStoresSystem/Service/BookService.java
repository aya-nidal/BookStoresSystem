package fin.fintechpath.com.BookStoresSystem.Service;

import fin.fintechpath.com.BookStoresSystem.model.Book;
import fin.fintechpath.com.BookStoresSystem.repository.BookRepository;
import fin.fintechpath.com.BookStoresSystem.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;
    private StoreRepository storeRepository;

    @Autowired
    public BookService(BookRepository bookRepository, StoreRepository storeRepository) {
        this.bookRepository = bookRepository;
        this.storeRepository = storeRepository;
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }


}
