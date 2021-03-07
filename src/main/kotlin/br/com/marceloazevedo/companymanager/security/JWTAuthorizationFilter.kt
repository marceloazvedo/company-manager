package br.com.marceloazevedo.companymanager.security

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthorizationFilter(authenticationManager: AuthenticationManager?) : BasicAuthenticationFilter(authenticationManager) {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val header = request.getHeader(SecurityConstant.HEADER_STRING)
        if (header != null && header.startsWith(SecurityConstant.TOKEN_PREFIX)) {
            val authentication: UsernamePasswordAuthenticationToken? = getAuthenticationToken(request)
            SecurityContextHolder.getContext().authentication = authentication
            chain.doFilter(request, response)
        } else {
            chain.doFilter(request, response)
        }
    }

    private fun getAuthenticationToken(request: HttpServletRequest): UsernamePasswordAuthenticationToken? {
        val token = request.getHeader(SecurityConstant.HEADER_STRING)
        if (token != null) {
            val user = JWT.require(Algorithm.HMAC512(SecurityConstant.SECRET))
                    .build()
                    .verify(token.replace(SecurityConstant.TOKEN_PREFIX, ""))
                    .subject

            if (user != null) {
                return UsernamePasswordAuthenticationToken(user, null, emptyList())
            }
            return null
        }
        return null
    }
}