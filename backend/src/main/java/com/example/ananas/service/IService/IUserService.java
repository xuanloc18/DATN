package com.example.ananas.service.IService;

import java.math.BigDecimal;
import java.util.List;

import com.example.ananas.dto.request.UserCreateRequest;
import com.example.ananas.dto.request.UserUpdateRequest;
import com.example.ananas.dto.response.UserResponse;

public interface IUserService {
    UserResponse createUser(UserCreateRequest userCreateRequest);

    UserResponse updateUser(int id, UserUpdateRequest userUpdateRequest);

    String deleteUser(int id);

    List<UserResponse> getAllUsers();

    UserResponse getUserbyId(int id);

    BigDecimal getNumberUsers(String date);
}
