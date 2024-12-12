package com.group9.partypulse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {

    // BCryptPasswordEncoder Bean for hashing passwords
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Security filter chain configuration
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Allow access to the admin login page and static files (CSS, JS)
                        .requestMatchers("/admin/login", "/css/**", "/js/**").permitAll()
                        // Admin-specific page is restricted to users with ADMIN role
                        .requestMatchers("/admin/dashboard").hasRole("ADMIN")
                        // Require authentication for all other pages
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        // Admin has a dedicated login page
                        .loginPage("/admin/login")  // Admin login page URL
                        .defaultSuccessUrl("/admin/dashboard", true) // Redirect to admin dashboard on successful login
                        .failureUrl("/admin/login?error=true")  // Redirect to login page on failure
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/admin/login?logout=true")  // Redirect to admin login page on logout
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable());  // Disable CSRF explicitly (if not using)

        return http.build();
    }
}
