package com.wegrowth.starter.domain.todo

import com.wegrowth.starter.domain.event.BaseEvent

class TodoCompletedEvent(todo: Todo) : BaseEvent(todo)

class TodoUpdatedEvent(todo: Todo) : BaseEvent(todo)