package com.pluralsite.conferencedemo.repositories;

import com.pluralsite.conferencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
