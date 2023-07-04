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