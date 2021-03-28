package br.com.marceloazevedo.companymanager.service

import br.com.marceloazevedo.companymanager.dto.CreateClientDTO
import br.com.marceloazevedo.companymanager.mapper.UserMapper
import br.com.marceloazevedo.companymanager.model.Client
import br.com.marceloazevedo.companymanager.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClientServiceImpl: ClientService {

    @Autowired
    private lateinit var clientRepository: ClientRepository
    @Autowired
    private lateinit var userMapper: UserMapper


    override fun create(createClient: CreateClientDTO): Client {

        return clientRepository.save(userMapper.mapToClient(createClient))
    }
}