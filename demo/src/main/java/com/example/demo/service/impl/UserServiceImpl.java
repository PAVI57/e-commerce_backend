package com.example.demo.service.impl;

import com.example.demo.constants.Codes;
import com.example.demo.dao.UserDAO;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.response.AllProductResponse;
import com.example.demo.dto.response.StatusMessage;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.mapper.ResponseMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userDAO.getUserById(id);
        UserDTO userDTO = ResponseMapper.convert(user, new UserDTO());
        StatusMessage statusMessage = new StatusMessage(Codes.SUCCESS_MSG, Codes.SUCCESS_DESC);
        return new UserResponse(userDTO, Codes.SUCCESS, statusMessage);
    }

    @Override
    public UserResponse createUser(User user) {
        userDAO.createUser(user);
        UserDTO userDTO = ResponseMapper.convert(user, new UserDTO());
        StatusMessage statusMessage = new StatusMessage(Codes.SUCCESS_MSG, Codes.SUCCESS_DESC);
        return new UserResponse(userDTO, Codes.SUCCESS, statusMessage);
    }

    @Override
    public UserResponse updateUser(Long id, User userDetails) {
        User user = userDAO.getUserById(id);

        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        user.setAddress(userDetails.getAddress());

        userDAO.createUser(user);
        UserDTO userDTO = ResponseMapper.convert(user, new UserDTO());
        StatusMessage statusMessage = new StatusMessage(Codes.SUCCESS_MSG, Codes.SUCCESS_DESC);
        return new UserResponse(userDTO, Codes.SUCCESS, statusMessage);
    }

    @Override
    public UserResponse deleteUser(Long id) {
        User user = userDAO.getUserById(id);
        userDAO.deleteUser(user.getUserId());
        UserDTO userDTO = ResponseMapper.convert(user, new UserDTO());
        StatusMessage statusMessage = new StatusMessage(Codes.SUCCESS_MSG, Codes.SUCCESS_DESC);
        return new UserResponse(userDTO, Codes.SUCCESS, statusMessage);
    }

    @Override
    public AllProductResponse getProductsByUserId(Long userId) {
        User user = userDAO.getUserById(userId);
        List<ProductDTO> productDTOList = new ArrayList<>(user.getProducts().size());

        user.getProducts().forEach(product -> {
            ProductDTO productDTO = ResponseMapper.convert(product, new ProductDTO());
            productDTOList.add(productDTO);
        });

        StatusMessage statusMessage = new StatusMessage(Codes.SUCCESS_MSG, Codes.SUCCESS_DESC);
        return new AllProductResponse(productDTOList, Codes.SUCCESS, statusMessage);
    }
}
