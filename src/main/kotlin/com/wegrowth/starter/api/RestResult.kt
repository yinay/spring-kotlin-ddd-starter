package com.wegrowth.starter.api

class RestResult<T>(
    val code: Int? = 0,
    val message: String? = "",
    val data: T? = null
) {
    companion object {
        fun <T> ok(query: () -> T): RestResult<T> {
            return RestResult(data = query())
        }

        fun <T> success(
            id: String? = null,
            command: (id: String?) -> Unit
        ): RestResult<T> {
            command(id)
            return RestResult()
        }

        fun <T> failed(code: Int?, message: String): RestResult<T> {
            return RestResult(
                code = code,
                message = message
            )
        }
    }
}