package ko.sixtyfive.coffee

import java.util.UUID

class Coffee {
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