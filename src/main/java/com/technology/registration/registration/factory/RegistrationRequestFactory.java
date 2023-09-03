package com.technology.registration.registration.factory;

public interface RegistrationRequestFactory<T,E>{
    T createObjectFromDto(E dtoObject);
}
