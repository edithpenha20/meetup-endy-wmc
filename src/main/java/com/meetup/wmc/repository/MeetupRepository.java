package com.meetup.wmc.repository;

import com.meetup.wmc.model.entity.Meetup;
import com.meetup.wmc.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MeetupRepository extends JpaRepository<Meetup, Long> {

    Optional<Meetup> findByEvent(String event);

    @Query( value = " select m from Meetup as m join m.user as u where u.login = :login or m.event = :event ")
    Page<Meetup> findByUserOnMeetup(
            @Param("login") String login,
            @Param("event") String event,
            Pageable pageable
    );

    Page<Meetup> findByUser(User user, Pageable pageable );

}
