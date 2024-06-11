package com.anke.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Bean
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
