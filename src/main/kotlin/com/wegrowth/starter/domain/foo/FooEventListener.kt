package com.wegrowth.starter.domain.foo

import com.wegrowth.starter.domain.todo.TodoAddedEvent
import com.wegrowth.starter.domain.todo.TodoCompletedEvent
import mu.KotlinLogging
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class FooEventListener {
    private val logger = KotlinLogging.logger {}

    @EventListener
    fun todoAddedHandler(event: TodoAddedEvent) {
        logger.debug { "$event" }
    }

    @EventListener
    fun todoCompletedHandler(event: TodoCompletedEvent) {
        logger.info { "Todo Completed :${event.payload}" }
    }
}