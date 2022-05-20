package com.wegrowth.starter.api.rest

import com.wegrowth.starter.api.*
import com.wegrowth.starter.domain.todo.Todo
import com.wegrowth.starter.infrastructure.repository.TodoRepository
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ToDoController(private val todoRepository: TodoRepository) {

    @RestGet(path = "/todos", tag = "todo", summary = "获取所有待办事项")
    fun getAllTodos(): RestResult<List<Todo>> {
        return RestResult.ok {
            todoRepository.getAll()
        }
    }

    @RestPost(path = "/", tag = "todo", summary = "新建待办事项")
    fun addTodo(@RequestBody todo: Todo): RestResult<Todo> {
        return RestResult.success {
            todoRepository.save(todo)
        }
    }

    @RestPut(path = "/{id}/completed", tag = "todo", summary = "完成待办事项")
    fun completedTodo(@PathVariable id: String): RestResult<Todo> {
        return RestResult.success {
            todoRepository.findById(id).ifPresent {
                it.complete()
                todoRepository.save(it)
            }
        }
    }

    @RestDelete(path = "/{id}", tag = "todo", summary = "删除待办事项")
    fun deleteToDo(@PathVariable id: String): RestResult<Todo> {
        return RestResult.success {
            todoRepository.deleteById(id)
        }
    }

}