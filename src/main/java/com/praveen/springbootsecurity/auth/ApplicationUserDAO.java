package com.praveen.springbootsecurity.auth;

import java.util.Optional;

public interface ApplicationUserDAO {
    Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
