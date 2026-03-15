package com.example.shoppinglistapplication.main_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistapplication.dialog.DialogController
import com.example.shoppinglistapplication.dialog.DialogEvent
import com.example.shoppinglistapplication.roomData.entity.ShoppingListTableEntity
import com.example.shoppinglistapplication.roomData.repository.ShoppingListRepository
import com.example.shoppinglistapplication.shop_list_screen.ShoppingListEvent
import com.example.shoppinglistapplication.utils.UiEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: ShoppingListRepository
) : ViewModel() , DialogController{

    override var dialogTitle = mutableStateOf("List name: ")
        private set
    override var editableText = mutableStateOf("")
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var showEditableText = mutableStateOf(true)
        private set

    fun onEvent(event: MainScreenEvent) {
        when(event) {
            is MainScreenEvent.OnItemSave -> {
                if (editableText.value.isEmpty()) return
                viewModelScope.launch {
                    repository.insertItem(
                        ShoppingListTableEntity(
                            null,
                            name = editableText.value,
                            time = "12/12/2026 13:00",
                            allItemsCount =  0,
                            allSelectedItemsCount = 0
                        )
                    )
                }
            }
            is MainScreenEvent.OnShowEditDialog -> {
                openDialog.value = true
            }
        }
    }

    override fun onDialogEvent(event: DialogEvent) {
        when(event) {
            is DialogEvent.onCancel -> {
                openDialog.value = false
                editableText.value = ""
            }
            // если в диалоговом окне показываем текст филд , то данные нужно сохранять
            is DialogEvent.onConfirm -> {
                onEvent(MainScreenEvent.OnItemSave)
                openDialog.value = false
                editableText.value = ""
            }
            is DialogEvent.onTextChange -> {
                editableText.value = event.text
            }
        }
    }
}