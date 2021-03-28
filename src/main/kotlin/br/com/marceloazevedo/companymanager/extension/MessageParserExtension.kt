package br.com.marceloazevedo.companymanager.extension

import org.springframework.context.MessageSource
import java.util.*

fun getMessageBySqlStateAndCode(sqlState: String, code: Int, messageSource: MessageSource, arguments: Array<String>): String =
        if(sqlState == "23000" && code == 1062) messageSource.getMessage("field.duplicated", arguments, Locale.ENGLISH)
        else "not found"
