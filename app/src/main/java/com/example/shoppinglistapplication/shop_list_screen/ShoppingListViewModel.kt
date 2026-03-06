package com.example.shoppinglistapplication.shop_list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistapplication.roomData.entity.ShoppingListTableEntity
import com.example.shoppinglistapplication.roomData.repository.ShoppingListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val repository: ShoppingListRepository
) : ViewModel() {

    private var listItem : ShoppingListTableEntity? = null

    fun onEvent(event: ShoppingListEvent) {
        when(event) {
            is ShoppingListEvent.OnItemSave -> {
                viewModelScope.launch {
                    repository.insertItem(
                        ShoppingListTableEntity(
                            id = listItem?.id,
                            name = "",
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