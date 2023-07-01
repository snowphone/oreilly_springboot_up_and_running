package ko.sixtyfive.greeting

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "greeting")
data class Greeting(
    val name: String,
    val coffee: String,
)
