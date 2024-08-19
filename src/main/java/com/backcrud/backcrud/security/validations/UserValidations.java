package com.backcrud.backcrud.security.validations;

import com.backcrud.backcrud.entity.User;
import com.backcrud.backcrud.security.dto.Response;

public class UserValidations {
    
    public Response validate(User user){
        Response response = new Response();

        response.setNumOfErrors(0);

        if (user.getUsername()==null ||
            user.getPassword()==null ||
            user.getEmail()==null
        ){
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("Error al ingresar los datos requeridos");
        }

        return response;

    }

}
