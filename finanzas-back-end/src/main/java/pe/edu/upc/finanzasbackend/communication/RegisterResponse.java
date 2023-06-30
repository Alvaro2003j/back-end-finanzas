package pe.edu.upc.finanzasbackend.communication;

import pe.edu.upc.finanzasbackend.resource.UserResource;

public class RegisterResponse extends BaseResponse<UserResource>{

    public RegisterResponse(String message) {
        super(message);
    }

    public RegisterResponse(UserResource resource) {
        super(resource);
    }
}
