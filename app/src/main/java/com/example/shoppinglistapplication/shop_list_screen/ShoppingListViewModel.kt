package com.example.shoppinglistapplication.shop_list_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistapplication.dialog.DialogEvent
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

    private val list = repository.getAllItems()
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
                // когда редактируем список покупок , сохраняем его в глобальную переменную listItem
                listItem = event.item
                openDialog.value = true
                editableText.value = listItem?.name ?: "" // если редактирование элемента, то отображаем текст существующего элемента
                                                          // если добавление нового, то пустая строка
                dialogTitle.value = "List name:"
                showEditableText.value = true             // отображать ли текст филд
            }
            is ShoppingListEvent.onShowDeleteDialog -> {
                // когда хотим удалить список покупок, сохраняем выбраный список в глобальную переменную listItem и показываем диалоговое окно
                listItem = event.item
                openDialog.value = true
                dialogTitle.value = "Delete this item?"
                showEditableText.value = false              // отображать ли текст филд
            }
        }
    }

    // обработка действий в диалоговом окне
    fun onDialogEvent(event: DialogEvent) {
        when(event) {
            is DialogEvent.onCancel -> {
                openDialog.value = false
            }
            // если в диалоговом окне показываем текст филд , то данные нужно сохранять
            is DialogEvent.onConfirm -> {
                if(showEditableText.value) {
                    onEvent(ShoppingListEvent.OnItemSave)
                } else {
                    // корутина , потому что удаление трудоемкий процес
                    // удаляем тот список покупок, который записываем в глобальную переменную listItem
                    viewModelScope.launch {
                        // проверка на то , что репозиторий может быть null
                        listItem?.let { repository.deleteItem(it) }
                    }
                }
                openDialog.value = false
            }
            is DialogEvent.onTextChange -> {
                editableText.value = event.text
            }
        }
    }
}