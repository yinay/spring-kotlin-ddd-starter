package com.wegrowth.starter.api

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.core.annotation.AliasFor
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Target(allowedTargets = [AnnotationTarget.FUNCTION])
@Retention
@RequestMapping(method = [RequestMethod.GET])
@Operation
@Tag(name = "")
annotation class RestGet(
    @get:AliasFor(annotation = RequestMapping::class, attribute = "path")
    val path: String,

    @get:AliasFor(annotation = Tag::class, attribute = "name")
    val tag: String,

    @get:AliasFor(annotation = Operation::class)
    val summary: String,

    @get:AliasFor(annotation = RequestMapping::class, attribute = "produces")
    val produces: Array<String> = [MediaType.APPLICATION_JSON_VALUE],

    )


@Target(allowedTargets = [AnnotationTarget.FUNCTION])
@Retention
@RequestMapping(method = [RequestMethod.POST])
@Operation
@Tag(name = "")
annotation class RestPost(
    @get:AliasFor(annotation = RequestMapping::class, attribute = "path")
    val path: String,

    @get:AliasFor(annotation = Tag::class, attribute = "name")
    val tag: String,


    @get:AliasFor(annotation = Operation::class)
    val summary: String,

    @get:AliasFor(annotation = RequestMapping::class, attribute = "produces")
    val produces: Array<String> = [MediaType.APPLICATION_JSON_VALUE],
)


@Target(allowedTargets = [AnnotationTarget.FUNCTION])
@Retention
@RequestMapping(method = [RequestMethod.PUT])
@Operation
@Tag(name = "")
annotation class RestPut(
    @get:AliasFor(annotation = RequestMapping::class, attribute = "path")
    val path: String,

    @get:AliasFor(annotation = Tag::class, attribute = "name")
    val tag: String,

    @get:AliasFor(annotation = Operation::class)
    val summary: String,


    @get:AliasFor(annotation = RequestMapping::class, attribute = "produces")
    val produces: Array<String> = [MediaType.APPLICATION_JSON_VALUE],

    )


@Target(allowedTargets = [AnnotationTarget.FUNCTION])
@Retention
@RequestMapping(method = [RequestMethod.DELETE])
@Operation
@Tag(name = "")
annotation class RestDelete(
    @get:AliasFor(annotation = RequestMapping::class, attribute = "path")
    val path: String,
    @get:AliasFor(annotation = Tag::class, attribute = "name")
    val tag: String,
    @get:AliasFor(annotation = Operation::class)
    val summary: String,
)

