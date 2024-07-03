package com.example.formulaone.circuit.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.formulaone.circuit.data.Circuit
import com.example.formulaone.circuit.domain.CircuitListViewModel
import com.example.formulaone.core.util.Resource

@Composable
fun CircuitListScreen(
    viewModel: CircuitListViewModel = hiltViewModel(),
) {
    val circuitResource = produceState<Resource<List<Circuit>>>(
        initialValue = Resource.Loading()
    ) {
        value = viewModel.getCurrentCircuits()
    }.value

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Circuits",
                fontSize = 48.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.size(16.dp))

            when (circuitResource) {
                is Resource.Success -> {
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .weight(weight = 1f, fill = false)
                    ) {
                        circuitResource.data!!.forEach {
                            CircuitCard(
                                circuit = it,
                                modifier = Modifier.padding(vertical = 8.dp),
                            )
                        }
                    }
                }

                is Resource.Loading -> {
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .size(100.dp)
                            .align(Alignment.CenterHorizontally)
                            .padding(16.dp)
                    )
                }

                is Resource.Error -> {
                    Text(text = circuitResource.message!!)
                }
            }
        }
    }
}

@Composable
fun CircuitCard(circuit: Circuit, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp)
    ) {
        Text(text = circuit.circuitName, fontSize = 24.sp)
    }
}
