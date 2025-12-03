package com.example.SchoolMS.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Address {

    @Id
    private Integer id;
    @Column(columnDefinition = "varchar(20) not null")
    private String area;
    @Column(columnDefinition = "varchar(30) not null")
    private String street;
    @Column(columnDefinition = "varchar(4) not null")
    private String buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
