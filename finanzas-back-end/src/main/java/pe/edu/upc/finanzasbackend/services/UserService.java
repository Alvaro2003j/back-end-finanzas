package pe.edu.upc.finanzasbackend.services;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.finanzasbackend.communication.AuthenticateRequest;
import pe.edu.upc.finanzasbackend.communication.RegisterRequest;
import pe.edu.upc.finanzasbackend.domain.User;

import java.util.List;

public interface UserService {

    ResponseEntity<?> authenticate(AuthenticateRequest request);
    ResponseEntity<?> register(RegisterRequest request);

    User getById(Long id);

    List<User> getAll();
}
