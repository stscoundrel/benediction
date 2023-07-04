package io.github.stscoundrel.benediction.service

import io.github.stscoundrel.benediction.model.Event
import io.github.stscoundrel.benediction.repository.EventRepository
import org.springframework.stereotype.Service

@Service
class EventService(private val eventRepository: EventRepository) {

    fun saveEvent(event: Event): Event {
        return eventRepository.save(event)
    }

    fun getAllEvents(): List<Event> {
        return eventRepository.findAll()
    }
}