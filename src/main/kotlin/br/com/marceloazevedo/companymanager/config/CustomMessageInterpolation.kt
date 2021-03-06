package br.com.marceloazevedo.companymanager.config

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import java.util.*

@Configuration
class CustomMessageInterpolation {

    val messageSource = ReloadableResourceBundleMessageSource()

    @Bean
    fun messageSource(): MessageSource {
        println("messageSource")
        messageSource.setBasename("classpath:messages")
        messageSource.setDefaultEncoding("UTF-8")
        return messageSource
    }

    @Bean
    fun getValidator(messageSource: MessageSource): LocalValidatorFactoryBean? {
        println("getValidator")
        val bean = LocalValidatorFactoryBean()
        bean.setValidationMessageSource(messageSource)
        return bean
    }

}
