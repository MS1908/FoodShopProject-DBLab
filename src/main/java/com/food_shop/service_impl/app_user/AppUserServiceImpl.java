package com.food_shop.service_impl.app_user;

import com.food_shop.entities.app_user.AppUser;
import com.food_shop.entities.json.LoginForm;
import com.food_shop.payload.app_user.RegisterForm;
import com.food_shop.repo.app_user.AppUserRepo;
import com.food_shop.security.JWTService;
import com.food_shop.service.app_user.AppUserService;
import static com.food_shop.utils.EncodeUtils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppUserServiceImpl.class);

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private JWTService jwtService;

    @Override
    public String getRoleFromCookie(HttpServletRequest request) {
        String token;
        String username;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                    username = jwtService.decode(token);
                    if (username != null) {
                        return findByUsername(username)
                                .map(AppUser::getRole)
                                .orElse(null);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Optional<AppUser> findById(Integer idUser) {
        try {
            return appUserRepo.findById(idUser);
        } catch (Exception ex) {
            LOGGER.error("findById error", ex);
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<AppUser> findAll() {
        try {
            return appUserRepo.findAll();
        } catch (Exception ex) {
            LOGGER.error("findAll error", ex);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<AppUser> findByUsername(String username) {
        try {
            return appUserRepo.findByUsername(username);
        } catch (Exception ex) {
            LOGGER.error("findByUsername error", ex);
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<AppUser> findByEmail(String email) {
        try {
            return appUserRepo.findByEmail(email);
        } catch (Exception ex) {
            LOGGER.error("findByEmail error", ex);
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Boolean checkUsernameExisted(String username) {
        try {
            return appUserRepo.isUsernameExisted(username);
        } catch (Exception ex) {
            LOGGER.error("checkUsernameExisted error", ex);
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean checkEmailExisted(String email) {
        try {
            return appUserRepo.isEmailExisted(email);
        } catch (Exception ex) {
            LOGGER.error("checkEmailExisted error", ex);
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public AppUser register(RegisterForm registerForm) {
        try {
            AppUser appUser = new AppUser();
            appUser.setFullname(registerForm.getFullname());
            appUser.setUsername(registerForm.getUsername());
            appUser.setPassword(getSHA256(registerForm.getPassword()));
            appUser.setAddress(registerForm.getAddress());
            appUser.setEmail(registerForm.getEmail());
            appUser.setPhone(registerForm.getPhone());
            appUser.setRole(AppUser.ROLE_CUSTOMER);
            return appUserRepo.save(appUser);
        } catch (Exception ex) {
            LOGGER.error("register error", ex);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<AppUser> login(LoginForm loginForm) {
        try {
            return appUserRepo.login(loginForm.getUsername(), getSHA256(loginForm.getPassword()));
        } catch (Exception ex) {
            LOGGER.error("login error", ex);
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<AppUser> upload(AppUser appUser) {
        try {
            return Optional.ofNullable(appUserRepo.save(appUser));
        } catch (Exception ex) {
            LOGGER.error("saveAppUser error", ex);
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<AppUser> update(AppUser appUser) {
        return Optional.empty();
    }
}
