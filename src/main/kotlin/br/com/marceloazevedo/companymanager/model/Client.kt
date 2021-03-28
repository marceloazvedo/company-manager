package br.com.marceloazevedo.companymanager.model

import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Client(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        @OneToOne(cascade = [CascadeType.ALL])
        val user: User,
        @LastModifiedDate var updatedAt: LocalDateTime? = null
)