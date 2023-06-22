package ko.sixtyfive.coffee

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/coffees")
class RestApiDemoController {
    private val coffees: MutableList<Coffee> = mutableListOf(
        Coffee("Cafe Cereza"),
        Coffee("Cafe Ganador"),
        Coffee("Cafe Lareno"),
        Coffee("Cafe Tres Pontas"),
    )

    @GetMapping
    fun getCoffees(): Iterable<Coffee> = this.coffees

    @GetMapping("/{id}")
    fun getCoffeeById(@PathVariable id: String) = this.coffees.firstOrNull { it.id == id }

    @PostMapping
    fun postCoffee(@RequestBody coffee: Coffee): Coffee = coffee.also {
        coffees.add(it)
    }

    @PutMapping("/{id}")
    fun putCoffee(@PathVariable id: String, @RequestBody coffee: Coffee) = coffees
        .withIndex()
        .firstOrNull { it.value.id == id }
        ?.index
        ?.let {
            coffees[it] = coffee
            ResponseEntity(coffee, HttpStatus.OK)
        } ?: ResponseEntity(postCoffee(coffee), HttpStatus.CREATED)

    @DeleteMapping("/{id}")
    fun deleteCoffee(@PathVariable id: String) = coffees.removeIf { it.id == id }

}