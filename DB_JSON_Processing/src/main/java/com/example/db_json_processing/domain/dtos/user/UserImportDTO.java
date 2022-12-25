package com.example.db_json_processing.domain.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserImportDTO {
    private String firstName;
    private String lastName;
    private Integer age;
}
