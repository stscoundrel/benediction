package io.github.stscoundrel.benediction.controller

import io.github.stscoundrel.benediction.model.Event
import io.github.stscoundrel.benediction.service.EventService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.time.Instant

class EventControllerTest {
    @Mock
    private lateinit var eventService: EventService

    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        mockMvc = MockMvcBuilders.standaloneSetup(EventController(eventService)).build()
    }

    @Test
    fun getsEventByProjectAndRTimestamp() {
        val events = listOf(
            Event(
                projectName = "old-norwegian",
                path = "/letter/oe",
                userIdentifier = "666",
            ),
            Event(
                projectName = "old-norwegian",
                path = "/letter/a",
                userIdentifier = "667",
            ),
            Event(
                projectName = "old-norwegian",
                path = "/letter/b",
                userIdentifier = "668",
            )
        )

        // Controller should've parsed params from the payload.
        // Other than that, its just spring data magic.
        `when`(
            eventService.getEventsByProjectNameAndTimestampRange(
                projectName = "old-norwegian",
                startTimestamp = Instant.parse("2023-01-01T00:00:00Z"),
                endTimestamp = Instant.parse("2023-01-02T23:59:59Z")
            )
        ).thenReturn(events)


        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/events/query")
                .contentType(MediaType.APPLICATION_JSON)
                .param("projectName", "old-norwegian")
                .param("start", "2023-01-01T00:00:00Z")
                .param("end", "2023-01-02T23:59:59Z")
        )
            .andExpect(status().isOk)
    }

    @Test
    fun createsEventFromPayload() {
        val expectedEvent = Event(
            projectName = "old-norwegian",
            path = "/letter/oe",
            userIdentifier = "666",
        )

        // Controller should've parsed event from payload and called service with it.
        `when`(eventService.saveEvent(expectedEvent)).thenReturn(expectedEvent)


        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/events")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""{"projectName": "old-norwegian","path": "/letter/oe","userIdentifier": "666"}""")
        )
            .andExpect(status().isOk)
    }
}