package com.example.lab7_20190159.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "technician")
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnicianID", nullable = false)
    private int id;

    @Size(min = 3 ,max = 100,message = "Solo puede ingresar una cantidad entre 3 a 100 caracteres")
    @NotBlank
    @Column(name = "firstname")
    private String firstname;

    @Size(min = 3 ,max = 100,message = "Solo puede ingresar una cantidad entre 3 a 100 caracteres")
    @NotBlank
    @Column(name = "lastname")
    private String lastname;

    @Size(min = 8,max = 8,message = "Ingrese 8 valores")
    @NotBlank
    @Column(name = "dni")
    private String dni;

    @Size(min = 9 ,max = 9,message = "Ingrese un numero de 9 digitos")
    @Column(name = "phone", length = 9)
    private String phone;

    @Positive
    @Column(name = "Age")
    private int Age;
}