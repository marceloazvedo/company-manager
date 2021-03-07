package br.com.marceloazevedo.companymanager.security

class SecurityConstant {
    companion object {
        const val EXPIRATION_TIME = 864_000_000
        const val SECRET = "THIS_IS_MY_SECRET_65A1S65D4A65D4SA"
        const val HEADER_STRING = "Authorization"
        const val TOKEN_PREFIX = "Bearer "
    }
}