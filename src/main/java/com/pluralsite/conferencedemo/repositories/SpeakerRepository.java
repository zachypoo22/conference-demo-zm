package com.pluralsite.conferencedemo.repositories;

import com.pluralsite.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}
