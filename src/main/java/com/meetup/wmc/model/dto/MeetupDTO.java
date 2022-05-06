package com.meetup.wmc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetupDTO {


    private Long id;

    private String event;

    private LocalDate meetupDateRegistration;

    private UserDTO user;

}
