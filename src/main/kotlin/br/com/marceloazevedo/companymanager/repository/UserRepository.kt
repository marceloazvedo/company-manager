package br.com.marceloazevedo.companymanager.repository

import br.com.marceloazevedo.companymanager.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {
    fun findOneByEmail(email: String): User
    fun existsByEmail(email: String): Boolean
}