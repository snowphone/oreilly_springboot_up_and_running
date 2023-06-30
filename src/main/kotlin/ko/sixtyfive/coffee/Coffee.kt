package ko.sixtyfive.coffee

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
class Coffee {
    @Id
    val id: String
    var name: String

    constructor(id: String, name: String) {
        this.id = id
        this.name = name
    }

    constructor(name: String) {
        this.id = UUID.randomUUID().toString()
        this.name = name

    }

}