package com.meetup.wmc.service;

import com.meetup.wmc.model.dto.MeetupFilter;
import com.meetup.wmc.model.entity.Meetup;
import com.meetup.wmc.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MeetupService {

    Meetup save(Meetup meetup);

    Optional<Meetup> getById(Long id);

    Meetup update(Meetup meetup);

    Page<Meetup> findAllMeetups(MeetupFilter filter, Pageable pageable);

    Page<Meetup> getUserByMeetup(User user, Pageable pageable);
}
