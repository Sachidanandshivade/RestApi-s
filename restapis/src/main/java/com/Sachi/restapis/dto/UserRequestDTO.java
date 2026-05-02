package com.Sachi.restapis.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequestDTO {
    @NotBlank(message = "Name is Required")
    private String Name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String Email;

    @NotBlank
    private String password;
}
