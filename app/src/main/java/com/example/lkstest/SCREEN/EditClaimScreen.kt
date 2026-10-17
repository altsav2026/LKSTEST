package com.example.lkstest.SCREEN

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lkstest.DATA.AppViewModel
import java.util.Date

@Composable
fun EditClaimScreen(vm: AppViewModel){
    var title by mutableStateOf<String?>("")
    var desc by mutableStateOf<String?>("")
    var date by mutableStateOf<Date?>(null)
    var category by mutableStateOf<String?>("")

    Box(modifier = Modifier.fillMaxSize()){
        Column() {
            OutlinedTextField(
                value = title,
                onValueChange = {title = it}
            )

            OutlinedTextField(
                value = desc,
                onValueChange = {desc = it}
            )

            Row(horizontalArrangement = Arrangement.SpaceAround) {
                OutlinedTextField(
                    value = date,
                    onValueChange = {date = it}
                )

                OutlinedTextField(
                    value = category,
                    onValueChange = {category = it}
                )
            }

        }
    }

}