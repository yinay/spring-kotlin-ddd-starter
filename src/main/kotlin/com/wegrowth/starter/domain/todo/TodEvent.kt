package com.wegrowth.starter.domain.todo

import com.wegrowth.starter.domain.event.BaseEvent

class TodoAddedEvent(added: Todo) : BaseEvent(added)


class TodoCompletedEvent(todo: Todo) : BaseEvent(todo)