package com.example.shoppinglistapplication.shop_list_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistapplication.roomData.entity.ShoppingListTableEntity
import com.example.shoppinglistapplication.roomData.repository.ShoppingListRepository
import com.example.shoppinglistapplication.utils.DialogController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val repository: ShoppingListRepository,
) : ViewModel(), DialogController {

    override var dialogTitle = mutableStateOf("")
        private set // признак того, что записывать в эту переменную можно только в рамках текущего класса
    override var editableText = mutableStateOf("")
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var showEditableText = mutableStateOf(false)
        private set

    private var listItem : ShoppingListTableEntity? = null

    fun onEvent(event: ShoppingListEvent) {
        when(event) {
            is ShoppingListEvent.OnItemSave -> {
                viewModelScope.launch {
                    repository.insertItem(
                        ShoppingListTableEntity(
                            id = listItem?.id,
                            name = editableText.value,
                            time = "12/12/2026 13:00",
                            allItemsCount = listItem?.allItemsCount ?: 0,
                            allSelectedItemsCount = listItem?.allSelectedItemsCount ?: 0
                        )
                    )
                }
            }
            is ShoppingListEvent.onShowItemClick -> {

            }
            is ShoppingListEvent.onShowEditDialog -> {
                listItem = event.item
            }
            is ShoppingListEvent.onShowDeleteDialog -> {

            }
        }
    }
}