package br.com.marceloazevedo.companymanager.extension

import br.com.marceloazevedo.companymanager.dto.response.FieldError
import org.hibernate.exception.ConstraintViolationException
import org.springframework.context.MessageSource

fun ConstraintViolationException.toFieldError(messageSource: MessageSource): FieldError =
        FieldError(
                field = this.constraintName,
                message = getMessageBySqlStateAndCode(this.sqlState, this.sqlException.errorCode, messageSource, arrayOf(this.constraintName)),
                value = null
        )