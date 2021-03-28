package br.com.marceloazevedo.companymanager.mapper

import br.com.marceloazevedo.companymanager.dto.CreateClientDTO
import br.com.marceloazevedo.companymanager.enum.UserType
import br.com.marceloazevedo.companymanager.model.Client
import br.com.marceloazevedo.companymanager.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class UserMapper {

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    fun mapToClient(createClientDTO: CreateClientDTO): Client =
            Client(
                    user = User(
                            name = createClientDTO.name,
                            email = createClientDTO.email,
                            password = passwordEncoder.encode(createClientDTO.password),
                            userType = UserType.CLIENT,
                            roleGroup = null
                    )
            )

}