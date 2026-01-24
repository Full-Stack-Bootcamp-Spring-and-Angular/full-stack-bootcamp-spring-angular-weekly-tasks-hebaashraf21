package com.myApp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import specialAnnotation.PasswordMatchConstraint;

import javax.validation.constraints.*;


@Component
@Setter
@Getter
@PasswordMatchConstraint
public class UserModel
{

    @NotBlank(message = "this field is required")
    private String userName;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z.-]+\\.[a-zA-Z]{2,}$" , message = "the email not valid")
    private String email;

    @NotBlank(message = "password is required")
    @Size(min = 6, message = "password must be at least 6 characters")
    private String password;

    @NotBlank(message = "confirm password is required")
    private String confirmPassword;
}
