package com.sda.starter.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class GuestbookEntryDTO {
    private String name;
    private String text;
    private LocalDateTime timestamp;
}
