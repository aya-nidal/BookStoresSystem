package fin.fintechpath.com.BookStoresSystem.controller;

import fin.fintechpath.com.BookStoresSystem.Service.StoreService;
import fin.fintechpath.com.BookStoresSystem.model.Book;
import fin.fintechpath.com.BookStoresSystem.model.Store;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {
    private StoreService storeService;

    public StoreController(StoreService storeService) {
        super();
        this.storeService = storeService;
    }

    @GetMapping("/stores")
    public List<Store> getAllStore() {
        return storeService.getAllStore();
    }

    @GetMapping("/stores/{id}")
    public Store getStore(@PathVariable int id) {
        return storeService.getStore(id);
    }

    @GetMapping("/stores/{id}/books")
    public List<Book> getAllBookByStoreId(@PathVariable int id) {
        return storeService.findAllBookByStoreId(id);
    }
}
