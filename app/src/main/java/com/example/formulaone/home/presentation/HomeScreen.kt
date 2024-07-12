package com.example.formulaone.home.presentation

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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.formulaone.home.domain.HomeViewModel
import com.example.formulaone.result.data.Race

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val raceResource = produceState<Resource<Race>>(initialValue = Resource.Loading()) {
        value = viewModel.getMostRecentResult()
    }.value

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            when (raceResource) {
                is Resource.Success -> {
                    Podium(race = raceResource.data!!)
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
                        text = raceResource.message!!,
                    )
                }
            }
        }
    }
}

@Composable
fun Podium(race: Race) {
    val (first, second, third) = race.results.take(3)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(8.dp),
            )
            .padding(8.dp)
    ) {
        Text(
            text = race.raceName,
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            DriverImage(driver = second.driver)
            DriverImage(driver = first.driver)
            DriverImage(driver = third.driver)
        }
    }
}

@Composable
fun DriverImage(driver: Driver) {
    Image(
        painter = painterResource(id = driver.getImage()),
        contentDescription = driver.familyName,
        modifier = Modifier
            .size(69.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}
