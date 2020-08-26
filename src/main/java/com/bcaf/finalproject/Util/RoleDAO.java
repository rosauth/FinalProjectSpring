package com.bcaf.finalproject.Util;

import com.bcaf.finalproject.Entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleDAO extends JpaRepository<Role, String> {

    @Query(nativeQuery = true,value="SELECT r.* FROM role r WHERE r.role like %:role% ")
    Role findIdByRole(@Param("role") String role);

}
