package com.bcaf.finalproject.Util;

import com.bcaf.finalproject.Entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, String> {
}
