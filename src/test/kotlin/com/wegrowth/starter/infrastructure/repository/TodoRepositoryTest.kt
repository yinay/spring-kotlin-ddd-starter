package com.wegrowth.starter.infrastructure.repository

import com.wegrowth.starter.domain.todo.Todo
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@DataJpaTest
class TodoRepositoryTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val todoRepository: TodoRepository
) {
    @TestConfiguration
    @EnableJpaRepositories(
        considerNestedRepositories = true,
        basePackages = ["com.wegrowth.starter.infrastructure"]
    )
    class Setup {
        @Bean
        fun todoRepository(
            todoDslRepository: TodoRepositoryImpl.TodoDslRepository
        ) = TodoRepositoryImpl(todoDslRepository)
    }

    @Test
    fun `Add Todo should ok`() {
        val todo = todoRepository.save(Todo(description = "test to do "))

        val saved = entityManager.find(Todo::class.java,todo.id)

        Assertions.assertThat(saved).isNotNull
    }
}