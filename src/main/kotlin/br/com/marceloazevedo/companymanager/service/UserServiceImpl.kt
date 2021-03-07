package br.com.marceloazevedo.companymanager.service

import br.com.marceloazevedo.companymanager.model.User
import br.com.marceloazevedo.companymanager.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun create(user: User): User {

        return userRepository.save(user)
    }

    override fun findAll(): List<User> = userRepository.findAll()
}