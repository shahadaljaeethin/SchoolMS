package com.example.SchoolMS.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min=4,max=25,message = "name length 4-25 character")
    @Pattern(regexp = "^[a-zA-Z]*$",message = "name must contain letters only")
    @NotEmpty(message = "enter the name")
    @Column(columnDefinition = "varchar(25) not null")
    private String name;

    @Positive(message = "age must be positive")
    @NotNull(message = "enter age")
    @Min(value = 25,message = "minimum age is 25")
    @Max(value = 60,message = "maximum age is 60")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @Email(message = "invalid email")
    @NotEmpty(message = "enter email")
    @Column(columnDefinition = "varchar(100) not null unique")
    private String email;

    @Positive
    @Min(value = 5000,message = "minimum salary is 5000")
    @Max(value = 30000,message = "maximum salary in the system is 30000")
    @NotNull(message = "enter salary")
    @Column(columnDefinition = "int not null")
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

}
