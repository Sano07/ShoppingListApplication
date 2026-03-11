package com.example.shoppinglistapplication.dialog

import androidx.compose.runtime.MutableState

// контроллер для переиспользования диалогового окна ( добаавление , удаление, изменение item-ов  )

interface DialogController {
    val dialogTitle : MutableState<String>
    val editableText : MutableState<String>
    val openDialog : MutableState<Boolean>
    val showEditableText : MutableState<Boolean>
    fun onDialogEvent(event: DialogEvent)
}