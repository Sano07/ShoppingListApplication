package com.example.shoppinglistapplication.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppinglistapplication.ui.theme.Orange
import com.example.shoppinglistapplication.ui.theme.PurpleGrey40
import com.example.shoppinglistapplication.ui.theme.PurpleGrey80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAlertDialog(
    dialogController: DialogController
) {
    if (dialogController.openDialog.value) {
        BasicAlertDialog(
            onDismissRequest = {
                dialogController.onDialogEvent(DialogEvent.onCancel)
            }
        ) {
            Card {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = dialogController.dialogTitle.value,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold,
                        color = PurpleGrey40
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    if (dialogController.showEditableText.value)
                        TextField(
                            value = dialogController.editableText.value,
                            onValueChange = {
                                dialogController.onDialogEvent(DialogEvent.onTextChange(it))
                            },
                            label = {
                                Text("List name:")
                            },
                            singleLine = true,
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = PurpleGrey80,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            )
                        )
                    Row(
                        modifier = Modifier.align(alignment = Alignment.End)
                    ) {
                        TextButton(
                            onClick = {
                                dialogController.onDialogEvent(DialogEvent.onCancel)
                            }
                        ) {
                            Text(
                                text = "Cancel",
                                fontSize = 18.sp,
                                color = Orange
                            )
                        }
                        TextButton(
                            onClick = {
                                dialogController.onDialogEvent(DialogEvent.onConfirm)
                            }
                        ) {
                            Text(
                                text = "OK",
                                fontSize = 18.sp,
                                color = Orange
                            )
                        }
                    }
                }
            }
        }
    }
}