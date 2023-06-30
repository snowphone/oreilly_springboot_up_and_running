package ko.sixtyfive.coffee

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component

@Component
class DataLoader(private val coffeeRepository: CoffeeRepository) {

    @PostConstruct
    private fun loadData() {
        this.coffeeRepository.saveAll(
            listOf(
                Coffee("Cafe Cereza"),
                Coffee("Cafe Ganador"),
                Coffee("Cafe Lareno"),
                Coffee("Cafe Tres Pontas"),
            )
        )
    }
}