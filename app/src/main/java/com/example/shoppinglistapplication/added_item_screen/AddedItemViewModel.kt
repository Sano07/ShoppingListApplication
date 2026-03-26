package com.example.shoppinglistapplication.added_item_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistapplication.dialog.DialogController
import com.example.shoppinglistapplication.dialog.DialogEvent
import com.example.shoppinglistapplication.roomData.entity.AddedItemTableEntity
import com.example.shoppinglistapplication.roomData.entity.ShoppingListTableEntity
import com.example.shoppinglistapplication.roomData.repository.AddedItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddedItemViewModel @Inject constructor(
    private val repository: AddedItemRepository,
    savedStateHandle: SavedStateHandle  // состояние которое хранит аргументы, которые передаем при навигации
) : ViewModel(), DialogController {

    var itemsList: Flow<List<AddedItemTableEntity>>? = null

    // проверка выбраного элемента, если null - новый элемент, если !null - редактирование
    var addedItem: AddedItemTableEntity? = null
    var listId: Int = -1
    var shoppingListItemForChange: ShoppingListTableEntity? = null


    // получение аргументов
    init {
        listId = savedStateHandle.get<String>("listId")?.toInt()!!
        itemsList =
            listId.let { repository.getAllItemsById(it) }  // если не null то дергаем репозиторий
        viewModelScope.launch {
            shoppingListItemForChange = repository.getListItemById(listId)
        }
    }

    var itemText = mutableStateOf("")
        private set
    override var dialogTitle = mutableStateOf("Edit name:")
        private set
    override var editableText = mutableStateOf("")
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var showEditableText = mutableStateOf(true)
        private set

    fun onEvent(event: AddedItemScreenUIEvent) {
        when (event) {
            is AddedItemScreenUIEvent.OnItemSave -> {
                viewModelScope.launch {
                    if (listId == -1) return@launch
                    repository.insertItem(
                        AddedItemTableEntity(
                            addedItem?.id,
                            itemText.value,
                            addedItem?.isChecked ?: false,
                            listId
                            )
                    )
                    itemText.value = ""
                    addedItem = null
                    updateShoppingListCount()
                }
            }

            is AddedItemScreenUIEvent.OnShowEditDialog -> {
                addedItem = event.item
                openDialog.value = true
                editableText.value = addedItem?.name ?: ""

            }

            is AddedItemScreenUIEvent.OnTextChange -> {
                itemText.value = event.text
            }

            is AddedItemScreenUIEvent.OnDelete -> {
                viewModelScope.launch {
                    repository.deleteItem(event.item)
                    updateShoppingListCount()
                }
            }

            is AddedItemScreenUIEvent.OnCheckedChange -> {
                viewModelScope.launch {
                    repository.insertItem(event.item)
                    updateShoppingListCount()
                }
            }

        }
    }

    override fun onDialogEvent(event: DialogEvent) {
        when (event) {
            is DialogEvent.onCancel -> {
                openDialog.value = false
                editableText.value = ""
            }

            is DialogEvent.onConfirm -> {
                openDialog.value = false
                itemText.value = editableText.value
                editableText.value = ""
            }

            is DialogEvent.onTextChange -> {
                editableText.value = event.text
            }
        }
    }

    private fun updateShoppingListCount() {
        viewModelScope.launch {
            itemsList?.collect { items ->
                var counter = 0

                items.forEach { item ->
                    if(item.isChecked)
                        counter++
                }
                shoppingListItemForChange?.copy(
                    allItemsCount = items.size,
                    allSelectedItemsCount = counter
                )?.let {
                    repository.insertItem(
                        it
                    )
                }
            }
        }
    }
}