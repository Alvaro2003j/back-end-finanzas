package pe.edu.upc.finanzasbackend.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.finanzasbackend.communication.AuthenticateRequest;
import pe.edu.upc.finanzasbackend.communication.RegisterRequest;
import pe.edu.upc.finanzasbackend.domain.User;
import pe.edu.upc.finanzasbackend.mapping.UserMapper;
import pe.edu.upc.finanzasbackend.resource.UserResource;
import pe.edu.upc.finanzasbackend.services.UserService;

@Tag(name ="Users", description="Create & read users")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticateRequest request) {
        return userService.authenticate(request);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request){
        return userService.register(request);
    }

    @GetMapping("{userId}")
    public UserResource getUserById(@PathVariable Long userId) {
        return userMapper.toResource(userService.getById(userId));
    }
}
