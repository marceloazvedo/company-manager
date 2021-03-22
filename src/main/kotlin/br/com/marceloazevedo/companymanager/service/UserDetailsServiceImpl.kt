package br.com.marceloazevedo.companymanager.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class UserDetailsServiceImpl: UserDetailsService {

    @Autowired
    private lateinit var userService: UserService

    override fun loadUserByUsername(email: String): UserDetails {
        val user = userService.findByEmail(email)
        if (user.id == null)
            throw UsernameNotFoundException(email)
        return User(user.email, user.password, emptyList())
    }
}