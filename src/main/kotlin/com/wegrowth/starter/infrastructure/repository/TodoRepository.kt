package com.wegrowth.starter.infrastructure.repository

import com.wegrowth.starter.domain.todo.Todo
import com.wegrowth.starter.infrastructure.AbstractBaseRepository
import com.wegrowth.starter.infrastructure.BaseRepository
import com.wegrowth.starter.infrastructure.JpaQueryDslRepository
import org.springframework.stereotype.Repository


interface TodoRepository : BaseRepository<Todo>

@Repository
class TodoRepositoryImple(
    queryDslRepository: TodoDslRepository
) : TodoRepository, AbstractBaseRepository<Todo>(queryDslRepository) {
    interface TodoDslRepository : JpaQueryDslRepository<Todo>
}