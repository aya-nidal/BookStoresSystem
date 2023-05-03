package fin.fintechpath.com.BookStoresSystem.database;

import fin.fintechpath.com.BookStoresSystem.model.*;
import fin.fintechpath.com.BookStoresSystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DBInit implements CommandLineRunner {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private AuthoritiesRepository authoritiesRepository;
    private StoreRepository storeRepository;
    private BookRepository bookRepository;

    @Autowired
    public DBInit(UserRepository userRepository, RoleRepository roleRepository, AuthoritiesRepository authoritiesRepository, StoreRepository storeRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.authoritiesRepository = authoritiesRepository;
        this.storeRepository = storeRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        createRole("storeAdmin");
        createRole("normalUser");

        createAuthorities("ACCESS_ADMIN");
        createAuthorities("ACCESS_USER");


        createAdminUser("aya","aya123","ayanidal56@gmail.com",1);
        createAdminUser("bayan","bayan123","bayan_alqasem_96@gmail.com",1);

        createNormalUser("layan","layan123","layansofian00@gmail.com",1);
        createNormalUser("tete","tete123","tete1999@gmail.com",1);

        createUserWithoutRole("nidal","nidal123","nidal35@gmail.com",1);
        createUserWithoutRole("ahmad","ahmad123","ahmad1999@gmail.com",1);

        createStoreAndBook();

    }

    public void createRole(String roleName) {
        Role role = new Role();
        role.setRoleName(roleName);
        roleRepository.save(role);
    }
    public void createAuthorities(String authoritiesName) {
        Authorities authorities = new Authorities();
        authorities.setAuthoritiesName(authoritiesName);
        authoritiesRepository.save(authorities);
    }
    private void createAdminUser(String username, String password, String email, int active) {
        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setActive(active);
        user.getRoles().add(roleRepository.findById(1L).get());
        user.getAuthorities().add(authoritiesRepository.findById(1L).get());
        user.getAuthorities().add(authoritiesRepository.findById(2L).get());

        userRepository.save(user);
    }
    private void createNormalUser(String username, String password, String email, int active) {
        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setActive(active);
        user.getRoles().add(roleRepository.findById(2L).get());
        user.getAuthorities().add(authoritiesRepository.findById(2L).get());

        userRepository.save(user);
    }
    public void createUserWithoutRole(String username, String password, String email, int active) {
        User user = new User();
        user.setUsername("nidal");
        user.setPassword("nidal123");
        user.setEmail("nidal35@gmail.com");
        user.setActive(1);
        userRepository.save(user);
    }
    public void createStoreAndBook() {
        Book book1 = new Book();
        book1.setBookName("arabic");
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setBookName("english");
        bookRepository.save(book2);

        Book book3 = new Book();
        book3.setBookName("math");
        bookRepository.save(book3);

        Book book4 = new Book();
        book4.setBookName("history");
        bookRepository.save(book4);

        Book book5 = new Book();
        book5.setBookName("computer");
        bookRepository.save(book5);

        Store store1 = new Store();
        store1.setStoreName("etihad-store");
        store1.getBooks().add(book1);
        store1.getBooks().add(book2);
        store1.getBooks().add(book3);
        storeRepository.save(store1);

        Store store2 = new Store();
        store2.setStoreName("tqarub-store");
        store2.getBooks().add(book4);
        store2.getBooks().add(book5);
        storeRepository.save(store2);
    }
}
