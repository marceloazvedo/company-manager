package br.com.marceloazevedo.companymanager.model

import br.com.marceloazevedo.companymanager.enum.UserType
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        var name: String,
        @Column(unique = true, nullable = false)
        var email: String,
        var password: String,
        @Enumerated(EnumType.STRING)
        var userType: UserType,
        @ManyToOne
        var roleGroup: RoleGroup?,
        var status: Boolean = true,
        @CreatedDate val createdAt: LocalDateTime = LocalDateTime.now(),
        @LastModifiedDate var updatedAt: LocalDateTime? = null,
)