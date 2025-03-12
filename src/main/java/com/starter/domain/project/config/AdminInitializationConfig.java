package com.starter.domain.project.config;

import com.starter.domain.project.user.model.Role;
import com.starter.domain.project.user.model.User;
import com.starter.domain.project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdminInitializationConfig {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void initializeAdminUser() {
        if (!userRepository.existsByUsername(adminUsername)) {
            log.info("Initializing admin user...");
            User adminUser = User.builder()
                    .username(adminUsername)
                    .email(adminEmail)
                    .password(passwordEncoder.encode(adminPassword))
                    .role(Role.ADMIN)
                    .enabled(true)
                    .build();
            
            adminUser.setCreatedAt(ZonedDateTime.now());
            adminUser.setUpdatedAt(ZonedDateTime.now());
            
            userRepository.save(adminUser);
            log.info("Admin user created successfully");
        } else {
            log.info("Admin user already exists");
        }
    }
}
