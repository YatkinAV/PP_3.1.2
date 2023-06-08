package com.my_group.pp_312_spring_boot.model;

import jakarta.persistence.*;
import lombok.*;


@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String firstName;


    private String lastName;


    private Integer age;


    private String mail;
}
