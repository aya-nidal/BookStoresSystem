package fin.fintechpath.com.BookStoresSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Jwtlogin {
    private String username;
    private String password;
}
