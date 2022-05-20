package com.wegrowth.starter.api.rest

import com.ninjasquad.springmockk.MockkBean
import com.wegrowth.starter.infrastructure.repository.TodoRepository
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [ToDoController::class])
internal class ToDoControllerTest @Autowired constructor(
    val mockMvc: MockMvc
) {

    @MockkBean
    lateinit var todoRepository: TodoRepository

    @Test
    fun `get all Todo`() {
        every { todoRepository.getAll() } returns listOf()
        mockMvc.perform(get("/todos").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
    }
}