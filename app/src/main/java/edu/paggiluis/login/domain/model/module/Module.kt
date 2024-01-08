package edu.paggiluis.login.domain.model.module

import android.os.Parcelable

interface Module : Parcelable {
    fun areContentsTheSame(other: Module): Boolean
}