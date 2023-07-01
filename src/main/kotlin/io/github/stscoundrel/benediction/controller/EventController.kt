package io.github.stscoundrel.benediction.controller

import io.github.stscoundrel.benediction.model.Event
import io.github.stscoundrel.benediction.repository.EventRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/events")
class EventController(private val eventRepository: EventRepository) {

    @PostMapping
    fun createEvent(@RequestBody event: Event): Event {
        return eventRepository.save(event)
    }

    @GetMapping
    fun getAllEvents(): List<Event> {
        return eventRepository.findAll()
    }
}