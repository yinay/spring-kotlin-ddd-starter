package com.wegrowth.starter.api.request

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "待办请求")
data class TodoRequest(
    @Schema(description = "描述")
    val desc: String
)


