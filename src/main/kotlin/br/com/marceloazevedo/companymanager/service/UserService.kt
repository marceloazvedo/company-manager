package br.com.marceloazevedo.companymanager.service

import br.com.marceloazevedo.companymanager.model.User

interface UserService {
    fun create(user: User): User
    fun findAll(): List<User>
}