package com.starter.domain.project.user.dto;

import com.starter.domain.project.user.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
    private Role role;
    private boolean enabled;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
