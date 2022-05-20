package com.wegrowth.starter.infrastructure


import com.wegrowth.starter.domain.EntityNotFound
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.NoRepositoryBean
import java.util.*


@Configuration
@EnableJpaRepositories(considerNestedRepositories = true)
@EnableJpaAuditing
internal class Repository

@NoRepositoryBean
interface JpaQueryDslRepository<T> : JpaRepository<T, String>,
    QuerydslPredicateExecutor<T>

interface BaseRepository<T> {
    fun findById(id: String): Optional<T>
    fun getAll(): List<T>
    fun existOrElseThrow(id: String, name: String?)
    fun getByIdOrElseThrow(id: String, name: String? = null): T
    fun <S : T> save(entity: S): S
    fun deleteById(id: String)

}

abstract class AbstractBaseRepository<T>(
    protected open val queryDslRepository: JpaQueryDslRepository<T>
) : BaseRepository<T> {

    override fun findById(id: String) = queryDslRepository.findById(id)

    override fun getAll(): List<T> = queryDslRepository.findAll()

    override fun existOrElseThrow(id: String, name: String?) {
        if (!queryDslRepository.existsById(id))
            throw EntityNotFound(id = id, name = name)
    }

    override fun getByIdOrElseThrow(id: String, name: String?): T {
        return findById(id).orElseThrow { throw EntityNotFound(id = id, name = name) }
    }

    override fun <S : T> save(entity: S) = queryDslRepository.save(entity!!)

    override fun deleteById(id: String) = queryDslRepository.deleteById(id)
}