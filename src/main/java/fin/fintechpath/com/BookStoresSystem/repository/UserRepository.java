package fin.fintechpath.com.BookStoresSystem.repository;

import fin.fintechpath.com.BookStoresSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}