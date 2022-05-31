package com.webdev.productsystem.Users.User.Application.AddPhone;


import com.webdev.productsystem.Users.Phone.Domain.Ports.PhoneRepository;
import com.webdev.productsystem.Users.User.Domain.Entities.UserPhone;
import com.webdev.productsystem.Users.User.Domain.Ports.UserRepository;
import com.webdev.productsystem.Users.User.Domain.User;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.UserId;

import java.util.Optional;


/* TODO
Acabar esta clase
 */

public class AddPhone {
    private UserRepository repository;

    public AddPhone(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(String userId, String phoneCountryCode, String phoneNumber, String phoneId) {
        Optional<User> optionalUser = repository.find(new UserId(userId));
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.addPhone(new UserPhone(phoneId, phoneCountryCode, phoneNumber));
            this.repository.update(user);

        }



    }

}
