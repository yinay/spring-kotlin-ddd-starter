package com.wegrowth.starter.domain.todo

import com.fasterxml.jackson.annotation.JsonIgnore
import com.wegrowth.starter.domain.BaseEntity
import io.swagger.v3.oas.annotations.media.Schema
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
data class Todo(
    @Column
    @Schema(description = "描述")
    val description: String,

    @OneToMany(mappedBy = "parent")
    val children: List<Todo>? = null,

    @ManyToOne
    @JsonIgnore
    val parent: Todo? = null
) : BaseEntity<Todo>() {
    @Column
    var isCompleted: Boolean? = false

    fun complete() {
        isCompleted = true
        andEvent(TodoCompletedEvent(this))
    }

}
