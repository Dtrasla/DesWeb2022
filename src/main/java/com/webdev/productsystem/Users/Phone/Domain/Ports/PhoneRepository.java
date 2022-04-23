package com.webdev.productsystem.Users.User.Phone.Domain.Ports;

import com.webdev.productsystem.Users.User.Domain.User;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.UserEmail;
import com.webdev.productsystem.Users.User.Domain.ValueObjects.UserId;
import com.webdev.productsystem.Users.User.Phone.Domain.Phone;
import com.webdev.productsystem.Users.User.Phone.Domain.ValueObjects.PhoneId;
import com.webdev.productsystem.Users.User.Phone.Domain.ValueObjects.PhoneNumber;

import java.util.List;
import java.util.Optional;

public interface PhoneRepository {
    void save(Phone phone);
    void update(Phone phone);
    Optional<Phone> find(PhoneId phoneId);
    Optional<Phone> findByNumber(PhoneNumber number);
    Optional<List<Phone>> all();
    void delete(Phone phone);
}
