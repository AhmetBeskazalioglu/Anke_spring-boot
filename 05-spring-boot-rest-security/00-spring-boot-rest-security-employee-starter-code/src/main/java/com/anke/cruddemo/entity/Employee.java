package com.anke.cruddemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NonNull
    @Column(name="first_name")
    private String firstName;

    @NonNull
    @Column(name="last_name")
    private String lastName;

    @NonNull
    @Column(name="email")
    private String email;

}








