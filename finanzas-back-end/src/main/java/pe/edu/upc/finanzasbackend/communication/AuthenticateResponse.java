package pe.edu.upc.finanzasbackend.communication;

import pe.edu.upc.finanzasbackend.resource.UserResource;

public class AuthenticateResponse extends BaseResponse<UserResource>{

    public AuthenticateResponse(String message) {
        super(message);
    }

    public AuthenticateResponse(UserResource resource) {
        super(resource);
    }
}
