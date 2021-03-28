package br.com.marceloazevedo.companymanager.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Company(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        var cnpj: String,
        var fullName: String,
        @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        var users: List<User> = mutableListOf(),
        @CreatedDate
        val createdAt: LocalDateTime = LocalDateTime.now(),
        @LastModifiedDate
        var updatedAt: LocalDateTime? = null,
)