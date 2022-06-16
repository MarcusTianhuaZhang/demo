package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(List.of(user, admin));
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.
                httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/api/v1/movie").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/v1/movie/delete/{\\\\d+}").hasAnyRole("ADMIN")
                .antMatchers("/api/v1/movie/{\\\\d+}/like").permitAll()
                .antMatchers("/api/v1/movie/{\\\\d+}/dislike").permitAll()
                .and()
                .formLogin();
        //http.csrf().disable();

        return http.build();
    }
}


