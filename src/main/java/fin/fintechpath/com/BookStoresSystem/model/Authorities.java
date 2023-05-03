package fin.fintechpath.com.BookStoresSystem.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "authorities")
public class    Authorities {

    @Id
    @GeneratedValue
            (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authorities_name")
    private String authoritiesName;

    @ManyToMany(mappedBy = "authorities")
    private List<User> users = new ArrayList<>();
}
