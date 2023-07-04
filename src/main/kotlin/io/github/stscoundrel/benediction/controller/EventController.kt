package io.github.stscoundrel.benediction.controller

import io.github.stscoundrel.benediction.model.Event
import io.github.stscoundrel.benediction.service.EventService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/events")
class EventController(private val eventService: EventService) {

    @PostMapping
    fun createEvent(@RequestBody event: Event): Event {
        return eventService.saveEvent(event)
    }

    @GetMapping
    fun getAllEvents(): List<Event> {
        return eventService.getAllEvents()
    }
}