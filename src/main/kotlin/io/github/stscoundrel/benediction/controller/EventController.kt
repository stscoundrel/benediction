package io.github.stscoundrel.benediction.controller

import io.github.stscoundrel.benediction.model.Event
import io.github.stscoundrel.benediction.service.EventService
import org.springframework.web.bind.annotation.*
import java.time.Instant

@RestController
@RequestMapping("/api/events")
class EventController(private val eventService: EventService) {

    @PostMapping
    fun createEvent(@RequestBody event: Event): Event {
        return eventService.saveEvent(event)
    }

    @GetMapping("/query")
    fun getEventsByProjectAndTimestampRange(
        @RequestParam("projectName") projectName: String,
        @RequestParam("start") start: Instant,
        @RequestParam("end") end: Instant
    ): List<Event> {
        return eventService.getEventsByProjectNameAndTimestampRange(projectName, start, end)
    }

    @GetMapping
    fun getAllEvents(): List<Event> {
        return eventService.getAllEvents()
    }
}