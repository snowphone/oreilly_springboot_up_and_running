package ko.sixtyfive.coffee

import org.springframework.data.repository.CrudRepository

interface CoffeeRepository: CrudRepository<Coffee, String> {
}