package com.food_shop.repo.app_user;

import com.food_shop.entities.app_user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Integer> {

    @Query(value = "select u from AppUser u where u.idUser = ?1")
    Optional<AppUser> findById(Integer idUser);

    @Query(value = "select u from AppUser u where u.username = ?1")
    Optional<AppUser> findByUsername(String username);

    @Query(value = "select u from AppUser u where u.email = ?1")
    Optional<AppUser> findByEmail(String email);

    @Query(value = "select " +
                        "case when(count(u) > 0) then true else false end " +
                   "from AppUser u where u.username = ?1")
    boolean isUsernameExisted(String username);

    @Query(value = "select " +
                        "case when(count(u) > 0) then true else false end " +
                    "from AppUser u where u.email = ?1")
    boolean isEmailExisted(String email);

    @Query(value = "select u from AppUser u where u.username = ?1 and u.password = ?2")
    Optional<AppUser> login(String username, String password);
}
