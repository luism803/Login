package edu.paggiluis.login.domain.model.module

import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import edu.paggiluis.login.utils.LocalDateAdapter
import kotlinx.parcelize.Parcelize
import java.time.LocalDate


@Parcelize
data class Budget(
    @SerializedName("id")
    val id: Int,

    @JsonAdapter(LocalDateAdapter::class)
    @SerializedName("budgetDate")
    val budgetDate: LocalDate,

    @SerializedName("description")
    val description: String,

    @SerializedName("cost")
    val cost: Double,

    @SerializedName("paymentMethod")
    val paymentMethod: String,

    @SerializedName("note")
    val note: String,

    @SerializedName("showAccount")
    val showAccount: Boolean,

    @SerializedName("client")
    val client: Client,

    @SerializedName("invoiceId")
    val invoiceId: Int?
): Module {

    override fun areContentsTheSame(other: Module): Boolean {
        if (other !is Budget) return false
        return  (id == other.id) &&
                (budgetDate == other.budgetDate) &&
                (description == other.description) &&
                (cost == other.cost) &&
                (paymentMethod == other.paymentMethod) &&
                (note == other.note) &&
                (showAccount == other.showAccount) &&
                (client.areContentsTheSame(other.client)) &&
                (invoiceId == other.invoiceId)
    }
}