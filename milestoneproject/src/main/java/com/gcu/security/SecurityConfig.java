package com.gcu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gcu.business.MyUserDetailsService;

/**
 * Spring Security configuration class.
 * Sets up authentication, authorization, login, logout, and password encoding.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Autowired
        private MyUserDetailsService userDetailsService;

        /**
         * Configures the HTTP security for the application.
         * 
         * @param http the HttpSecurity object
         * @return the configured SecurityFilterChain
         * @throws Exception if any error occurs during configuration
         */
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                return http
                                .csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers("/login/**", "/register/**", "/css/**", "/images/**")
                                                .permitAll()
                                                .anyRequest().authenticated())
                                .formLogin(form -> form
                                                .loginPage("/login/") // your login controller page
                                                .loginProcessingUrl("/login/process") // form POST action
                                                .defaultSuccessUrl("/login/dashboard", true)
                                                .failureUrl("/login/?error=true")
                                                .permitAll())
                                .logout(logout -> logout
                                                .logoutUrl("/logout")
                                                .logoutSuccessUrl("/login?logout=true")
                                                .permitAll())
                                .userDetailsService(userDetailsService)
                                .build();
        }

        /**
         * Bean for password encoding using BCrypt.
         * 
         * @return the PasswordEncoder instance
         */
        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }
}
