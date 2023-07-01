package ko.sixtyfive.greeting

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/greeting")
class GreetingController(private val greeting: Greeting) {

    @get:GetMapping
    val name: String get() = greeting.name

    @get:GetMapping("/coffee")
    val coffee: String get() = greeting.coffee
}
