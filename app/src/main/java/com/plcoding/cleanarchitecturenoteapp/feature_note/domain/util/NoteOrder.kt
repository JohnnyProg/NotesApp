package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util

sealed class NoteOrder(val type: OrderType) {
    class Title(type: OrderType): NoteOrder(type)
    class Date(type: OrderType): NoteOrder(type)
    class Color(type: OrderType): NoteOrder(type)

    fun copy(orderType: OrderType) : NoteOrder {
        return when(this) {
            is Title -> Title(orderType)
            is Color -> Color(orderType)
            is Date -> Date(orderType)
        }
    }
}