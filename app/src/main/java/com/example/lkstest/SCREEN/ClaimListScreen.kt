package com.example.lkstest.SCREEN

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.example.lkstest.DATA.AppViewModel

@Composable
fun ClaimListScreen (vm: AppViewModel){
    var search by mutableStateOf<String?>("")

    //coulumn
    var claimnumber by mutableStateOf<String?>("")
    var title by mutableStateOf<String?>("")
    var status by mutableStateOf<String?>("")
    var claimdate by mutableStateOf<String?>("")
    var totalAmount by mutableStateOf<Int?>(null)
    var category by mutableStateOf<String?>("")

    var
    Box(modifier = Modifier.fillMaxSize()){
        Column() {
            OutlinedTextField(
                value = search,
                onValueChange = {search = it}
            )

            Spacer(Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.Start) {

                Card(
                    shape = CardDefaults.outlinedShape,
                    modifier = Modifier.padding(2.dp)
                ) {
                    Text("ALL")
                }
                Card(
                    shape = CardDefaults.outlinedShape,
                    modifier = Modifier.padding(2.dp)
                ) {
                    Text("Draft")
                }
                Card(
                    shape = CardDefaults.outlinedShape,
                    modifier = Modifier.padding(2.dp)
                ) {
                    Text("Submitted")
                }
                Card(
                    shape = CardDefaults.outlinedShape,
                    modifier = Modifier.padding(2.dp)
                ) {
                    Text("Approved")
                }
                Card(
                    shape = CardDefaults.outlinedShape,
                    modifier = Modifier.padding(2.dp)
                ) {
                    Text("Rejected")
                }
            }

            Spacer(Modifier.height(12.dp))

            Column(modifier = Modifier.fillMaxSize()) {
                OutlinedCard(
                    modifier = Modifier.padding(12.dp)
                ) {
                    Row(horizontalArrangement = Arrangement.SpaceAround) {
                        Column() {
                            Text(
                                claimnumber
                            )
                            Text(
                                title
                            )
                            Row(horizontalArrangement = Arrangement.SpaceAround) {
                                Text(claimdate)
                                Spacer(Modifier.width(2.dp))
                                Text(category)
                            }
                        }
                        Column() {
                            Text(
                                status
                            )
                            Spacer(Modifier.height(10.dp))
                            Text(
                                totalAmount
                            )
                        }
                    }
                }
            }
            Button(
                onClick =
            ) {
                Text("+")
            }
        }
    }
}