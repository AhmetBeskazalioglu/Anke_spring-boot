package com.anke.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    // InMemoryUserDetailsManager kullanıcı bilgilerini hafızada tutar.
    public InMemoryUserDetailsManager userDetailsService() {

        // UserDetails nesnesi oluşturulur ve kullanıcı bilgileri set edilir.
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary= User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails susan= User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE","ADMIN","MANAGER")
                .build();

        return new InMemoryUserDetailsManager(john,mary,susan);
    }
}
