package edu.paggiluis.login.domain.model.module

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Client(
    @SerializedName("id")
    val id: Int,

    @SerializedName("nif")
    val nif: String?,

    @SerializedName("name")
    val name: String,

    @SerializedName("lastName")
    val lastName: String?,

    @SerializedName("phone")
    val phone: String,

    @SerializedName("address")
    val address: String,

    @SerializedName("email")
    val email: String?,

    @SerializedName("active")
    val active: Boolean?
): Module {

    override fun areContentsTheSame(other: Module): Boolean {
        if (other !is Client) return false
        return  (id == other.id) &&
                (nif == other.nif) &&
                (name == other.name) &&
                (lastName == other.lastName) &&
                (phone == other.phone) &&
                (address == other.address) &&
                (email == other.email) &&
                (active == other.active)
    }
}
