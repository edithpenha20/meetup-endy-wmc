package com.meetup.wmc.service.impl;

import com.meetup.wmc.model.dto.MeetupFilter;
import com.meetup.wmc.model.entity.Meetup;
import com.meetup.wmc.model.entity.User;
import com.meetup.wmc.repository.MeetupRepository;
import com.meetup.wmc.service.MeetupService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MeetupServiceImpl implements MeetupService {


    private MeetupRepository repository;

    public MeetupServiceImpl(MeetupRepository repository) {
        this.repository = repository;
    }

    @Override
    public Meetup save(Meetup meetup) {
        return repository.save(meetup);
    }

    @Override
    public Optional<Meetup> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Meetup update(Meetup meetup) {
        return repository.save(meetup);
    }

    @Override
    public Page<Meetup> findAllMeetups(MeetupFilter filter, Pageable pageable) {
        return repository.findByUserOnMeetup( filter.getLogin(), filter.getEvent(), pageable );
    }

    @Override
    public Page<Meetup> getUserByMeetup(User user, Pageable pageable) {
        return repository.findByUser(user, pageable);
    }

}
