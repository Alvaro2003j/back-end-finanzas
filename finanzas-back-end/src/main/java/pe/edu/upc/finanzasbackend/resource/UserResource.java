package pe.edu.upc.finanzasbackend.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResource {
    private long id;
    private String userName;
    private String email;
    private String password;
}
