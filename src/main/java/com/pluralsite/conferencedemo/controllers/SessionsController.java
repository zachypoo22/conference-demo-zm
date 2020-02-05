package com.pluralsite.conferencedemo.controllers;

import com.pluralsite.conferencedemo.models.Session;
import com.pluralsite.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list() {
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return sessionRepository.getOne(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session) {
        // save it AND push to DB (flush)
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value ="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        // also need to check for child records before deleting
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        // because this is a put we expect all attributes to be passed in (rest will be null), a PATCH would only need some
        // todo: add validation that all attributes that are passed in, otherwise would return 401 bad payload
        Session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)  // can make it return http 201
//    public Session create(@RequestBody final Session session) {
//        return sessionRepository.saveAndFlush(session);
//    }
}
