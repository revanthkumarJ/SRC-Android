package com.example.src_android.features.home.presentaion.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.src_android.R
import com.example.src_android.core.Domain
import com.example.src_android.features.home.presentaion.HomeViewModel
import com.example.src_android.features.home.presentaion.homeComponents.DomainCard

@Composable
fun Domains(homeViewModel: HomeViewModel) {

    val domains by homeViewModel.domainsData.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, top = 15.dp)
    ) {
        Text(
            text = "Domains",
            fontWeight = FontWeight.Bold,
            fontSize = 21.sp,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 9.dp),
            color = MaterialTheme.colorScheme.primary
        )
        LazyRow(modifier = Modifier.fillMaxWidth(0.95f)) {
            domains?.let {
                it.map {domainItem ->
                    item {
                        DomainCard(domain = domainItem)
                    }
                }
            }

        }
    }
}