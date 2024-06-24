package com.example.formulaone.driver.presentation

import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.formulaone.core.util.Resource
import com.example.formulaone.driver.data.Driver
import com.example.formulaone.driver.domain.DriverListViewModel

@Composable
fun DriverListScreen(
    viewModel: DriverListViewModel = hiltViewModel(),
) {
    val driverResource = produceState<Resource<List<Driver>>>(initialValue = Resource.Loading()) {
        value = viewModel.getCurrentDrivers()
    }.value

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Drivers",
                fontSize = 48.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.size(16.dp))

            when (driverResource) {
                is Resource.Success -> {
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .weight(weight = 1f, fill = false)
                    ) {
                        driverResource.data!!.forEach {
                            DriverCard(
                                driver = it,
                                modifier = Modifier.padding(vertical = 8.dp)
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
                    Text(
                        text = driverResource.message!!,
                    )
                }
            }
        }
    }
}

@Composable
fun DriverCard(driver: Driver, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = driver.getImage()),
            contentDescription = driver.familyName,
            modifier = Modifier
                .size(69.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = driver.permanentNumber.toString(), fontSize = 32.sp)
            Text(text = "${driver.givenName} ${driver.familyName}", fontSize = 16.sp)
        }
    }
}
