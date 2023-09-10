package ru.skypro.lessons.springboot.homework_spring2.service;

import org.springframework.stereotype.Component;
import ru.skypro.lessons.springboot.homework_spring2.model.AppUser;
import ru.skypro.lessons.springboot.homework_spring2.DTO.AppUserDTO;

@Component
public class AppUserMapper {

    public AppUserDTO toDto(AppUser user) {
        AppUserDTO userDto = new AppUserDTO();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());
        return userDto;
    }

}