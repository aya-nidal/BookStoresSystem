package fin.fintechpath.com.BookStoresSystem.repository;

import fin.fintechpath.com.BookStoresSystem.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
