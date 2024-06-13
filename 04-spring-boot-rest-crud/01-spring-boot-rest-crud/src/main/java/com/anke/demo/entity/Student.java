package com.anke.demo.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;
}
