package ko.sixtyfive.greeting

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/greeting")
class GreetingController(
    @Value("\${greeting-name: Mirage}")
    @get:GetMapping
    val name: String,

    @Value("\${greeting-coffee: \${greeting-name} is drinking Cafe Ganador}")
    @get:GetMapping("/coffee")
    val coffee: String
);
