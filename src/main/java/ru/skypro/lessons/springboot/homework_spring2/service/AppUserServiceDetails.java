package ru.skypro.lessons.springboot.homework_spring2.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.skypro.lessons.springboot.homework_spring2.repository.AppUserRepository;
import ru.skypro.lessons.springboot.homework_spring2.security.AppUserDetails;

@Component
public class AppUserServiceDetails implements UserDetailsService {

    private final AppUserRepository repository;

    private final AppUserMapper mapper;

    private final AppUserDetails appUserDetails;

    public AppUserServiceDetails(AppUserRepository repository, AppUserMapper mapper, AppUserDetails appUserDetails) {
        this.repository = repository;
        this.mapper = mapper;
        this.appUserDetails = appUserDetails;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var appUser = repository.findAppUserByLogin(username)
                .orElseThrow(() -> new IllegalStateException("User not found"));
        appUserDetails.setUserDetails(mapper.toDto(appUser));
        return appUserDetails;
    }

}
