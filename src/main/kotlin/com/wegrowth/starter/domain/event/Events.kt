package com.wegrowth.starter.domain.event

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component


abstract class BaseEvent(val payload: Any)

@Component(value = "eventBus")
final class EventBus() {

    private var applicationContext: ApplicationContext? = null

    @Autowired
    constructor(applicationContext: ApplicationContext) : this() {
        this.applicationContext = applicationContext
        eventBus = this
    }

    companion object {
        private var eventBus: EventBus? = null
        fun instance(): EventBus {
            return eventBus!!
        }
    }

    fun fireEvent(event: Any) {
        applicationContext?.publishEvent(event)
    }
}



