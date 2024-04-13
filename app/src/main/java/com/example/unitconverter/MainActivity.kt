package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverterScree()
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun UnitConverterScree(){
    var enteredInput by remember { mutableStateOf("") }
    var isExpandedInput by remember { mutableStateOf(false) }
    var inputUnit by remember { mutableStateOf("Centimeter") }
    var isExpandedOutput by remember { mutableStateOf(false) }
    var outputUnit by remember { mutableStateOf("Centimeter") }
    var output by remember { mutableStateOf(0.0) }
    var conversionRate by remember { mutableStateOf(0.01) }

    fun convertUnit(){
       if(inputUnit == outputUnit){
            output = enteredInput.toDouble()
       }

        if(inputUnit == "Centimeter" && outputUnit == "Meter"){
            output = enteredInput.toDouble() / 100
        }

        if(inputUnit == "Centimeter" && outputUnit == "Millimeter"){
            output = enteredInput.toDouble() * 10
        }

        if(inputUnit == "Centimeter" && outputUnit == "Foot"){
            output = enteredInput.toDouble() / 30.48
        }

        if(inputUnit == "Meter" && outputUnit == "Centimeter"){
            output = enteredInput.toDouble() * 100
        }

        if(inputUnit == "Meter" && outputUnit == "Foot"){
            output = enteredInput.toDouble() * 3.281
        }

        if(inputUnit == "Meter" && outputUnit == "Millimeter"){
            output = enteredInput.toDouble() * 1000
        }

        if(inputUnit == "Millimeter" && outputUnit == "Centimeter"){
            output = enteredInput.toDouble() / 10
        }

        if(inputUnit == "Millimeter" && outputUnit == "Meter"){
            output = enteredInput.toDouble() / 1000
        }

        if(inputUnit == "Millimeter" && outputUnit == "Foot"){
            output = enteredInput.toDouble() / 304.8
        }
        if(inputUnit == "Foot" && outputUnit == "Centimeter"){
            output = enteredInput.toDouble() * 30.48
        }

        if(inputUnit == "Foot" && outputUnit == "Centimeter"){
            output = enteredInput.toDouble() / 3.281
        }

        if(inputUnit == "Foot" && outputUnit == "Centimeter"){
            output = enteredInput.toDouble() * 304.8
        }
    }



    Column  (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = "Unit Converter",
            style = MaterialTheme.typography.headlineMedium
            )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = enteredInput, onValueChange = {enteredInput = it}, label = { Text(
            text = "Enter a value"
        )} )
        Spacer(modifier = Modifier.height(16.dp))
        Row (){

            Box {
                Button(onClick = {isExpandedInput = true }) {
                    Text(text = "$inputUnit")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "dropDownIcon")
                }
                DropdownMenu(expanded = isExpandedInput, onDismissRequest = { isExpandedInput = false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeter") },
                        onClick = {
                            inputUnit = "Centimeter"
                            isExpandedInput = false
                            convertUnit()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meter") },
                        onClick = {
                            inputUnit = "Meter"
                            isExpandedInput = false
                            convertUnit()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Foot") },
                        onClick = {
                            inputUnit = "Foot"
                            isExpandedInput = false
                            convertUnit()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Millimeter") },
                        onClick = {
                            inputUnit = "Millimeter"
                            isExpandedInput = false
                            convertUnit()
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                Button(onClick = { isExpandedOutput = true }) {
                    Text(text = "$outputUnit")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "dropDownIcon")
                }
                DropdownMenu(expanded = isExpandedOutput, onDismissRequest = { isExpandedOutput = false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeter") },
                        onClick = {
                            outputUnit = "Centimeter"
                            isExpandedOutput = false
                            convertUnit()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meter") },
                        onClick = {
                            outputUnit = "Meter"
                            isExpandedOutput = false
                            convertUnit()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Foot") },
                        onClick = {
                            outputUnit = "Foot"
                            isExpandedOutput = false
                            convertUnit()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Millimeter") },
                        onClick = {
                            outputUnit = "Millimeter"
                            isExpandedOutput = false
                            convertUnit()
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result: $output $outputUnit",
            style = MaterialTheme.typography.headlineSmall
            )
    }
}



