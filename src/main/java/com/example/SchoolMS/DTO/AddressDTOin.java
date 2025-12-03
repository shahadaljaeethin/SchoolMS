package com.example.SchoolMS.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressDTOin {

    @Size(min = 6,max = 20,message = "area length 6-20 char")
    @NotEmpty(message = "enter area")
    @Pattern(regexp = "^[a-zA-Z]*$",message = "area must be in letters")
    private String area;

    @Size(min = 6,max = 30,message = "street length 6-30 char")
    @NotEmpty(message = "enter street")
    private String street;

    @Size(min = 1,max = 4,message = "area length 1-4 characters")
    @NotEmpty(message = "enter building number")
    private String buildingNumber;

    @NotNull(message = "log in as teacher")
    private Integer teacherId;

}
