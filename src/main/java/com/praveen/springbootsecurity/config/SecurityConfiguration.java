package com.praveen.springbootsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static com.praveen.springbootsecurity.config.ApplicationUserPermission.*;
import static com.praveen.springbootsecurity.config.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                // Look CSRFFilter class
                //.and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                //.antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
                //.antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
                //.antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
                //.antMatchers(HttpMethod.GET, "/management/api/**").hasAnyRole(ADMIN.name(), ADMINTRAINEE.name())
                .anyRequest().authenticated().and().httpBasic();
        //http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/h2-consolFe/**").permitAll().and().csrf().disable().headers().frameOptions().disable();
        //http.authorizeRequests().antMatchers("/h2-console/**").permitAll().and().csrf().disable().headers().frameOptions().disable();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        System.out.println("ROLE: " + STUDENT.name());
        System.out.println("ROLE: " + STUDENT.values().toString());
        UserDetails narainUser = User.builder().username("narain").password(passwordEncoder.encode("pass"))
                //.roles(STUDENT.name())
                .authorities(STUDENT.grantedAuthorities())
                .build();
        UserDetails saranUser = User.builder().username("saran").password(passwordEncoder.encode("pass123"))
                //.roles(ADMIN.name())
                .authorities(ADMIN.grantedAuthorities())
                .build();
        UserDetails karthiUser = User.builder().username("karthi").password(passwordEncoder.encode("pass123"))
                //.roles(ADMINTRAINEE.name())
                .authorities(ADMINTRAINEE.grantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(narainUser, saranUser, karthiUser);
    }
}
