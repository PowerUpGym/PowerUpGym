package com.example.PowerUpGym.services.admin;

import com.example.PowerUpGym.bo.auth.AddClassRequest;
import com.example.PowerUpGym.bo.auth.AddPackageRequest;
import com.example.PowerUpGym.bo.auth.AddPlayerToClassRequest;
import com.example.PowerUpGym.bo.auth.update.ClassUpdateRequest;
import com.example.PowerUpGym.bo.auth.update.UserUpdateRequest;
import com.example.PowerUpGym.bo.auth.users.PlayerRegistrationRequest;
import com.example.PowerUpGym.bo.auth.users.TrainerRegistrationRequest;
import com.example.PowerUpGym.bo.auth.users.UserRegistrationRequest;
import com.example.PowerUpGym.entity.users.AdminEntity;
import com.example.PowerUpGym.entity.users.UserEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

public interface AdminService {

    AdminEntity signupAdmin(AdminEntity admin);

    AdminEntity getAdminById(Long id);

    AdminEntity getAdminByUsername(String username);

    RedirectView postSignupAdmin(UserRegistrationRequest userRequest);

    String getEditAdminProfile(Principal principal, Model model);
    RedirectView getUpdateAdmin(UserUpdateRequest userUpdateRequest);

    RedirectView signupTrainer(UserRegistrationRequest userRequest, TrainerRegistrationRequest trainerRequest, Principal principal);

    RedirectView signupPlayer(PlayerRegistrationRequest playerRequest, UserRegistrationRequest userRequest, Principal principal);

    RedirectView renewSubscription(@RequestParam(name = "playerId") Long playerId,
                                   @RequestParam(name = "newPackageId") Long newPackageId);
    RedirectView updateAccountStatus(@RequestParam(name = "playerId") Long playerId,
                                     @RequestParam(name = "accountStatus") String accountStatus);
    RedirectView addPackage(AddPackageRequest packageRequest, Principal principal);

    RedirectView addClass(AddClassRequest classRequest, Principal principal);

    RedirectView addPlayerToClass(AddPlayerToClassRequest request);

    RedirectView postEditClassDetails(ClassUpdateRequest classUpdateRequest , Principal principal, @RequestParam Long trainerId);


//    UserEntity findUserByUsername(String username);
}
