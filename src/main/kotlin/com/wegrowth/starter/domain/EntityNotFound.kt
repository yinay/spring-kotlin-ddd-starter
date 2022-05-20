package com.wegrowth.starter.domain

class EntityNotFound(id: String, name: String?) : Throwable("$name($id) not found.")