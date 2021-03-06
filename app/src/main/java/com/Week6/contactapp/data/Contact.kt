package com.Week6.contactapp.data

import com.google.firebase.database.Exclude

data class Contact(
    @get:Exclude
    var id: String? = null,
    var fullName: String? = null,
    var ContactNumber: String? = null,
    @get:Exclude
    var isDeleted: Boolean = false

) {
    override fun equals(other: Any?): Boolean {
        return if (other is Contact) {
            other.id == id
        } else false
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (fullName?.hashCode() ?: 0)
        result = 31 * result + (ContactNumber?.hashCode() ?: 0)
        result = 31 * result + isDeleted.hashCode()
        return result
    }
}
