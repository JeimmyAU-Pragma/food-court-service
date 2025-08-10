package com.pragma.foodcourt.application.dto.external;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleDto {
    private Long id;
    private String name;
    private String description;
}
