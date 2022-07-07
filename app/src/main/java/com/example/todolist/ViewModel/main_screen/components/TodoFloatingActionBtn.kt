package com.example.todolist.ViewModel.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun TodoFloatingActionBtn(
    openDialog: () -> Unit
) {
    FloatingActionButton(
        modifier = Modifier.size(80.dp),
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        onClick =
        { openDialog() },
        shape = AbsoluteRoundedCornerShape(100)
    ) {
        Icon(imageVector = Icons.Filled.Add,
            contentDescription = "Add Book",
            tint = MaterialTheme.colorScheme.onBackground
        )
    }
}