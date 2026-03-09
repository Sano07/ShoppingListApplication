package com.example.shoppinglistapplication.dialog

// События при работе с диалоговым окном
sealed class DialogEvent {
    data class onTextChange( val text : String) : DialogEvent()
    object onCancel : DialogEvent()
    object onConfirm : DialogEvent()
}
