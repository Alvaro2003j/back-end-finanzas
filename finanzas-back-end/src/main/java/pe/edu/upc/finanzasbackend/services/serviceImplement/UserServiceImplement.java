package pe.edu.upc.finanzasbackend.services.serviceImplement;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.finanzasbackend.communication.AuthenticateRequest;
import pe.edu.upc.finanzasbackend.communication.AuthenticateResponse;
import pe.edu.upc.finanzasbackend.communication.RegisterRequest;
import pe.edu.upc.finanzasbackend.communication.RegisterResponse;
import pe.edu.upc.finanzasbackend.domain.User;
import pe.edu.upc.finanzasbackend.repositories.UserRepository;
import pe.edu.upc.finanzasbackend.resource.UserResource;
import pe.edu.upc.finanzasbackend.services.UserService;
import pe.edu.upc.finanzasbackend.shared.mapping.EnhancedModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class UserServiceImplement implements UserService {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImplement.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EnhancedModelMapper mapper;

    @Override
    public ResponseEntity<?> authenticate(AuthenticateRequest request) {
        try {
            Optional<User> user = this.userRepository.findUserByEmailAndPassowrd(request.getEmail(), request.getPassword());
            if (user.isEmpty()){
                AuthenticateResponse response = new AuthenticateResponse("User bad data request");
                return ResponseEntity.badRequest().body(response.getMessage());
            }
            return ResponseEntity.ok("User authenticated");
        } catch (Exception e) {
            AuthenticateResponse response = new AuthenticateResponse(e.getMessage());
            return ResponseEntity.badRequest().body(response.getMessage());
        }


    }

    @Override
    public ResponseEntity<?> register(RegisterRequest request) {
        if (userRepository.existsUserByEmail(request.getEmail())) {
            AuthenticateResponse response = new AuthenticateResponse("User email is already used.");
            return ResponseEntity.badRequest().body(response.getMessage());
        }
        try {
            User user = new User()
                    .withUserName(request.getUserName())
                    .withEmail(request.getEmail())
                    .withPassword(request.getPassword());
            userRepository.save(user);
            UserResource resource = mapper.map(user, UserResource.class);
            RegisterResponse response = new RegisterResponse(resource);
            return ResponseEntity.ok(response);

        } catch (Exception e){
            RegisterResponse response = new RegisterResponse(e.getMessage());
            return ResponseEntity.badRequest().body(response.getMessage());
        }

    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
