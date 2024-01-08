package edu.paggiluis.login.ui.strategy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class SearchType : Parcelable {
    CLIENTS,
    BUDGETS,
    ISSUED_INVOICES,
    SUPPLIERS,
    RECEIVED_INVOICES
}