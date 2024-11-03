package org.minh.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/public/**").permitAll() // Cho phép truy cập công khai
                        .anyRequest().authenticated() // Yêu cầu xác thực cho tất cả các yêu cầu khác
                )
                .formLogin(form -> form
                        .loginPage("/login") // Đường dẫn đến trang login tùy chỉnh
                        .permitAll() // Cho phép tất cả người dùng truy cập trang login
                        .defaultSuccessUrl("/home", true) // Đường dẫn sau khi đăng nhập thành công
                        .failureUrl("/login?error=true") // Đường dẫn khi đăng nhập thất bại
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Đường dẫn để logout
                        .logoutSuccessUrl("/login?logout=true") // Đường dẫn sau khi logout thành công
                        .permitAll() // Cho phép tất cả người dùng logout
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // Không sử dụng session

        return http.build();
    }
}
