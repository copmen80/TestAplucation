package ua.devserhii.testaplication

/**
 * Created by Vladislav Boiko on 20.04.2021.
 */
class User() {
    var id: String? = null
    var name: String? = null
    var number: Int? = null
    var email: String? = null

    constructor(id: String, name: String, number: Int, email: String) : this() {
        this.id = id
        this.name = name
        this.number = number
        this.email = email
    }
}