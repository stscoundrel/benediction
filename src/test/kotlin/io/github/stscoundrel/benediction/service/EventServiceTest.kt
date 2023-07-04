package io.github.stscoundrel.benediction.service

import io.github.stscoundrel.benediction.model.Event
import io.github.stscoundrel.benediction.repository.EventRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class EventServiceTest {

    @Mock
    private lateinit var eventRepository: EventRepository

    private lateinit var eventService: EventService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        eventService = EventService(eventRepository)
    }

    @Test
    fun savesEventUsingEventRepository() {
        val event = Event(
            projectName = "old-norse",
            path = "/",
            userIdentifier = "666"
        )

        `when`(eventRepository.save(event)).thenReturn(event)

        eventService.saveEvent(event)

        // Verify that the save method was called on the eventRepository with the correct event object
        verify(eventRepository).save(event)
    }

    @Test
    fun getAllEventsFromRepository() {
        val events = listOf(
            Event(
                projectName = "old-norse",
                path = "/",
                userIdentifier = "666"
            ),
            Event(
                projectName = "old-icelandic",
                path = "/letter/a",
                userIdentifier = "777"
            ),
            Event(
                projectName = "old-swedish",
                path = "/word/fadhir",
                userIdentifier = "888",
            )
        )
        `when`(eventRepository.findAll()).thenReturn(events)

        val result = eventService.getAllEvents()

        assertEquals(events, result)
    }
}