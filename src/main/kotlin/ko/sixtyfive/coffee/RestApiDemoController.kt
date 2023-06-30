package ko.sixtyfive.coffee

import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/coffees")
class RestApiDemoController(private val coffeeRepository: CoffeeRepository) {
    @GetMapping
    fun getCoffees(): Iterable<Coffee> = this.coffeeRepository.findAll()

    @GetMapping("/{id}")
    fun getCoffeeById(@PathVariable id: String) = this.coffeeRepository.findByIdOrNull(id)

    @PostMapping
    fun postCoffee(@RequestBody coffee: Coffee): Coffee = this.coffeeRepository.save(coffee)

    @PutMapping("/{id}")
    fun putCoffee(@PathVariable id: String, @RequestBody coffee: Coffee) = if (this.coffeeRepository.existsById(id)) {
        ResponseEntity(this.coffeeRepository.save(coffee), HttpStatus.OK)
    } else {
        ResponseEntity(this.coffeeRepository.save(coffee), HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteCoffee(@PathVariable id: String) = this.coffeeRepository.deleteById(id)

}