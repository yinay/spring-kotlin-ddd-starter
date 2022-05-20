package com.wegrowth.starter.infrastructure.repository

import com.wegrowth.starter.domain.todo.QTodo
import com.wegrowth.starter.domain.todo.Todo
import com.wegrowth.starter.infrastructure.AbstractBaseRepository
import com.wegrowth.starter.infrastructure.BaseRepository
import com.wegrowth.starter.infrastructure.JpaQueryDslRepository
import org.springframework.stereotype.Repository


interface TodoRepository : BaseRepository<Todo> {
    fun search(keyword: String): List<Todo>
}

@Repository
class TodoRepositoryImpl(
    val todoDslRepository: TodoDslRepository
) : TodoRepository, AbstractBaseRepository<Todo>(todoDslRepository) {
    interface TodoDslRepository : JpaQueryDslRepository<Todo>

    override fun search(keyword: String): List<Todo> {
        return todoDslRepository.findAll(QTodo.todo.description.like("%$keyword")).toList()
    }
}