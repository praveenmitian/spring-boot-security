package com.praveen.springbootsecurity.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.praveen.springbootsecurity.config.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDAOService implements ApplicationUserDAO{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDAOService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUser().stream().filter(applicationUser -> username.equals(applicationUser.getUsername())).findFirst();
    }

    private List<ApplicationUser> getApplicationUser(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(STUDENT.grantedAuthorities(), "narain",
                        passwordEncoder.encode("pass"), true, true,
                        true, true),
                new ApplicationUser(ADMIN.grantedAuthorities(), "saran",
                        passwordEncoder.encode("pass123"), true, true,
                        true, true),
                new ApplicationUser(ADMINTRAINEE.grantedAuthorities(), "karthi",
                        passwordEncoder.encode("pass123"), true, true,
                        true, true)
        );

        return applicationUsers;
    }
}
