package com.example.shoppinglistapplication.added_item_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.shoppinglistapplication.dialog.DialogController
import com.example.shoppinglistapplication.dialog.DialogEvent
import com.example.shoppinglistapplication.roomData.entity.AddedItemTableEntity
import com.example.shoppinglistapplication.roomData.repository.AddedItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class AddedItemViewModel @Inject constructor(
    private val repository: AddedItemRepository,
    savedStateHandle: SavedStateHandle  // состояние которое хранит аргументы, которые передаем при навигации
) : ViewModel() , DialogController {

    var itemsList : Flow<List<AddedItemTableEntity>>? = null
    // получение аргументов
    init {
        val listId = savedStateHandle.get<String>("listId")?.toInt()
        itemsList = listId?.let { repository.getAllItemsById(it) }  // если не null то дергаем репозиторий
    }


    override var dialogTitle = mutableStateOf("")
        private set
    override var editableText = mutableStateOf("")
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var showEditableText = mutableStateOf(true)
        private set

    fun onEvent() {

    }

    override fun onDialogEvent(event: DialogEvent) {
        when(event) {
            is DialogEvent.onCancel -> {
                openDialog.value = false
                editableText.value = ""
            }
            is DialogEvent.onConfirm -> {
                openDialog.value = false
                editableText.value = ""
            }
            is DialogEvent.onTextChange -> {
                editableText.value = event.text
            }
        }
    }
}