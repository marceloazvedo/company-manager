package br.com.marceloazevedo.companymanager.service

import br.com.marceloazevedo.companymanager.dto.CreateClientDTO
import br.com.marceloazevedo.companymanager.mapper.UserMapper
import br.com.marceloazevedo.companymanager.model.User
import br.com.marceloazevedo.companymanager.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClientServiceImpl: ClientService {

    @Autowired
    private lateinit var userRepository: UserRepository
    @Autowired
    private lateinit var userMapper: UserMapper


    override fun create(createClient: CreateClientDTO): User {
        return userRepository.save(userMapper.map(createClient))
    }
}