package com.spms.user_service.service.custom;

import com.spms.user_service.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
    UserDTO authenticateUser(String email);

    UserDTO getUserProfile(Long id);
    UserDTO updateUserProfile(Long id, UserDTO userDetails);
    List<UserDTO> getAllUsers();
}
