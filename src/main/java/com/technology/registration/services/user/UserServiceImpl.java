package com.technology.registration.services.user;

import com.technology.registration.dto.display.DisplayUserDto;
import com.technology.registration.dto.input.UserDto;
import com.technology.registration.errors.RoleNotFoundException;
import com.technology.registration.errors.UserAlreadyExistsException;
import com.technology.registration.models.Role;
import com.technology.registration.models.User;
import com.technology.registration.registration.requests.UserRegistrationRequest;
import com.technology.registration.repositories.RoleRepository;
import com.technology.registration.repositories.UserRepository;
import com.technology.registration.services.address.AddressService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AddressService addressService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           AddressService addressService,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.addressService = addressService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void registerUser(UserRegistrationRequest userRegistrationRequest) throws RoleNotFoundException,UserAlreadyExistsException {
        String email = userRegistrationRequest.email();
        Optional<User> optionalUser = userRepository.findUserByEmail(email);
        if (optionalUser.isPresent()) {
            throw new UserAlreadyExistsException("User " + email + " already exists");
        }
        User user = new User();
        user.setFirstName(userRegistrationRequest.firstName());
        user.setLastName(userRegistrationRequest.lastName());
        user.setPatronymic(userRegistrationRequest.patronymic());
        user.setEmail(email);
        user.setPhoneNumber(userRegistrationRequest.phoneNumber());
        user.setPassword(passwordEncoder.encode(userRegistrationRequest.password()));
        Optional<Role> roleOptional = roleRepository.findRoleByRoleName("USER");
        user.setRoles(Collections.singleton(
                roleOptional.orElseThrow(
                        () -> new RoleNotFoundException("Role USER is not found"))));
        user.setAddresses(
                Collections.singleton(
                        addressService.registerUserAddress(userDto)));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public List<DisplayUserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new DisplayUserDto(
                user.getFirstName(),
                user.getLastName(),
                user.getPatronymic(),
                user.getEmail(),
                user.getPhoneNumber()
        )).collect(Collectors.toList());
    }
}
