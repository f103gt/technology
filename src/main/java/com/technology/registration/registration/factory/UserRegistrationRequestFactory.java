package com.technology.registration.registration.factory;


import com.technology.registration.models.User;
import com.technology.registration.registration.requests.UserRegistrationRequest;

public class UserRegistrationRequestFactory implements RegistrationRequestFactory<User,UserRegistrationRequest>{
    @Override
    public User createObjectFromDto(UserRegistrationRequest userRegistrationRequest) {
        User user = new User();
        user.setFirstName(userRegistrationRequest.firstName());
        user.setLastName(userRegistrationRequest.lastName());
        user.setPatronymic(userRegistrationRequest.patronymic());
        user.setEmail(userRegistrationRequest.email());
        user.setPhoneNumber(userRegistrationRequest.phoneNumber());
        return user;
    }
}
