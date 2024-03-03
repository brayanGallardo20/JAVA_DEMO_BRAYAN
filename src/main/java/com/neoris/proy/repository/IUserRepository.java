package com.neoris.proy.repository;

import com.neoris.proy.model.User;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository <User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = :vEmail")
    User findByEmail(@Param("vEmail") String vEmail);

    @Query("SELECT u FROM User u WHERE u.token = :vToken")
    User findUserByToken(@Param("vToken") String vToken);

    @Modifying
    @Query(
            "UPDATE User u SET u.token = :vToken, u.lastLogin = :vLastLogin,u.modified = :vModified WHERE u.email = :vEmail")
    int updateUser(
            @Param("vEmail") String vEmail,
            @Param("vToken") String vToken,
            @Param("vLastLogin") String vLastLogin,
            @Param("vModified") String vModified);

    @Modifying
    @Query("UPDATE User u SET u.token = :vTokenUpdate WHERE u.token = :vTokenSearch")
    int revocateToken(
            @Param("vTokenSearch") String vTokenSearch, @Param("vTokenUpdate") String vTokenUpdate);
}
