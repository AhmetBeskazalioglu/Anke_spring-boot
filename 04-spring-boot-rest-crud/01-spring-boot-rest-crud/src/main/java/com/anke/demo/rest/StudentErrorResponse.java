package com.anke.demo.rest;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentErrorResponse {

    private int status;

    private String message;

    private long timeStamp;


}
