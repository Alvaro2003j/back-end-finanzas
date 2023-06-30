package pe.edu.upc.finanzasbackend.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@With
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(max=50)
    @Column(name="userName", unique = true)
    private String userName;

    @NotBlank
    @Size(max=50)
    @Column(name="email", unique = true)
    private String email;

    @NotBlank
    @Size(min=5)
    @Column(name="password", unique = true)
    private String password;

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
