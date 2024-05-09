package com.example.delivery2.Config;

import com.example.delivery2.Enums.Roles;
import com.example.delivery2.Security.ClientDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final ClientDetailsService clientDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // конфигурируем сам Spring Security
        // конфигурируем авторизацию
        http.authorizeRequests()
                .antMatchers("/api/v1/deliver/**").hasAnyRole("DELIVER", "ADMIN")
                .antMatchers("/api/v1/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/", "/hello","/**/*.js", "/**/*.css","/auth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/auth/login")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/api/v1/distributor/all", true)
                .failureUrl("/auth/login?error")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/auth/login");
    }

    // Настраиваем аутентификацию
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(clientDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }
    //Шифруем наш пароль

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
