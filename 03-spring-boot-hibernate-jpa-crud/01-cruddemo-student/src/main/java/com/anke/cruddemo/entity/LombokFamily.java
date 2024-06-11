package com.anke.cruddemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor // Boş constructor
@AllArgsConstructor // Tüm field'ları içeren constructor
@RequiredArgsConstructor // Zorunlu field'ları içeren constructor
@ToString
@Entity
@Table(name = "family")
public class LombokFamily {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @NonNull
    @Column(name = "surname", nullable = false)
    private String surname;


}
