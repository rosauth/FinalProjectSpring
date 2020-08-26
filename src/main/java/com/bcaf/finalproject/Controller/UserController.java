package com.bcaf.finalproject.Controller;

import com.bcaf.finalproject.Entity.model.Agency;
import com.bcaf.finalproject.Entity.user.User;
import com.bcaf.finalproject.Entity.user.UserAgency;
import com.bcaf.finalproject.Util.AgencyDAO;
import com.bcaf.finalproject.Util.RoleDAO;
import com.bcaf.finalproject.Util.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AgencyDAO agencyDAO;

    @Autowired
    private RoleDAO roleDAO;

    @GetMapping("/")
    public String landingPage(){
        return "index";
    }

    @GetMapping("/register")
    public String signUp(UserAgency userAgency, Model model){

        model.addAttribute("userAgency", userAgency);
        return "register";
    }

    @PostMapping("/add-user")
    public String signingUp(UserAgency userAgency, Model model){
        User user = new User();
        user.setEmail(userAgency.getEmail());
        user.setFirstName(userAgency.getFirstName());
        user.setLastName(userAgency.getLastName());
        user.setMobileNumber(userAgency.getMobileNumber());
        user.setRole(roleDAO.findIdByRole("owner").getId());

        String hashedPassword = "";
        String salt = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(salt.getBytes(StandardCharsets.UTF_8));

            byte[] bytes = messageDigest.digest(userAgency.getPassword().getBytes(StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();
            for (byte aByte : bytes) {
                stringBuilder.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            hashedPassword = stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        user.setPassword(hashedPassword);

        Agency agency = new Agency();
        agency.setDetails(userAgency.getAgencyDetails());
        agency.setName(userAgency.getAgencyName());
        agency.setOwner(userAgency.getFirstName() + " " + userAgency.getLastName());

        userDAO.save(user);
        agencyDAO.save(agency);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String logIn(){
        return "login";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword(){
        return "forgot-password";
    }
}
