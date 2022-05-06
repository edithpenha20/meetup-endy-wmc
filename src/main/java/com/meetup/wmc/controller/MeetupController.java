package com.meetup.wmc.controller;

import com.meetup.wmc.model.dto.MeetupDTO;
import com.meetup.wmc.model.dto.MeetupFilter;
import com.meetup.wmc.model.dto.UserDTO;
import com.meetup.wmc.model.entity.CreateMeetup;
import com.meetup.wmc.model.entity.Meetup;
import com.meetup.wmc.model.entity.User;
import com.meetup.wmc.service.CreateMeetupService;
import com.meetup.wmc.service.MeetupService;
import com.meetup.wmc.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/meetups")
public class MeetupController {

    private final MeetupService meetupService;
    private final UserService userService;
    private final CreateMeetupService createMeetupService;
    private final ModelMapper modelMapper;

    public MeetupController(MeetupService meetupService, UserService userService, CreateMeetupService createMeetupService, ModelMapper modelMapper) {
        this.meetupService = meetupService;
        this.userService = userService;
        this.createMeetupService = createMeetupService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private MeetupDTO userForAnEvent(@RequestBody MeetupFilter filter) {

        User user = userService.getUserByLogin(filter.getLogin())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

        CreateMeetup newEvent = createMeetupService.findByEvent(filter.getEvent())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

        Meetup entity = Meetup.builder()
                .event(newEvent.getEvent())
                .meetupDateRegistration(LocalDate.now())
                .eventDetails(newEvent)
                .user(user)
                .build();

        entity = meetupService.save(entity);
        MeetupDTO dto = modelMapper.map(entity, MeetupDTO.class);
        return dto;
    }


    @GetMapping
    public Page<MeetupDTO> findAllMeetups(MeetupFilter dto, Pageable pageRequest) {
        Page<Meetup> result = meetupService.findAllMeetups(dto, pageRequest);
        List<MeetupDTO> meetups = result
                .getContent()
                .stream()
                .map(entity -> {

                    User user = entity.getUser();
                    UserDTO userDTO = modelMapper.map(user, UserDTO.class);

                    MeetupDTO meetupDTO = modelMapper.map(entity, MeetupDTO.class);
                    meetupDTO.setUser(userDTO);
                    return meetupDTO;

                }).collect(Collectors.toList());
        return new PageImpl<MeetupDTO>(meetups, pageRequest, result.getTotalElements());
    }

}
