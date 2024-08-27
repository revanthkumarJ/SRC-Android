package com.example.src_android.features.about.presentation

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.src_android.R
import com.example.src_android.features.profile.presentation.ProfileUIComponenents.ImageButton
import com.example.src_android.utils.DecodeBase64ToBitmap
import com.example.src_android.utils.Loader
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight

@Composable
fun About(modifier: Modifier, officialViewModel: OfficialViewModel) {

    val officials by officialViewModel.officialLiveData.observeAsState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome to the SRC (Student Recreation Center), a dynamic club initiated by the Computer Science department of RGUKT RK Valley in 2024. Our mission is to foster increased interaction between seniors and juniors, promoting a culture of mutual learning, collaboration, and support within our college community.",
            modifier = Modifier.padding(vertical = 10.dp),
            fontSize = 19.sp
        )
        Text(
            text = "Our Coordinators",
            fontSize = 25.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        if (officialViewModel.isLoading.value) {
            Loader()
        } else {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 10.dp) // Adjust this padding as needed
                ) {
                    officials?.let {
                        val decoder = DecodeBase64ToBitmap()
                        val bitmap = decoder.decodeBase64ToBitmap(it.data.first().photo)
                        itemsIndexed(it.data) { index, official ->
                            AboutCoordinatorItem(
                                photo = bitmap,
                                name = official.name,
                                linkedin = official.linkedin,
                                department = official.department,
                                qualification = official.qualifications,
                                email = official.email
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                        }
                    } ?: run {
                        item {
                            Text(
                                text = "No Coordinators Found",
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold,
                                fontSize = 19.sp
                            )
                        }
                    }
                }
            }
        }
    }

}


@Composable
fun AboutCoordinatorItem(
    photo: Bitmap?, name: String, linkedin: String, department: String,
    qualification: String, email: String
) {

    val containerColor = if (MaterialTheme.colorScheme.primaryContainer == Color.Black) {
        Color(0xFF1A1A1A)
    } else {
        Color(0xFFFAF9F6)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(containerColor, RoundedCornerShape(15.dp))
            .padding(horizontal = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.fillMaxWidth(0.6f)) {
                Text(text = name, fontSize = 19.sp, modifier = Modifier.padding(start = 15.dp))
                Spacer(modifier = Modifier.height(7.dp))

                Text(text = department, modifier = Modifier.padding(start = 15.dp))
                Spacer(modifier = Modifier.height(7.dp))
                Text(text = qualification, modifier = Modifier.padding(start = 15.dp))
                Spacer(modifier = Modifier.height(7.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ImageButton(
                        painter = painterResource(id = R.drawable.linkdein_white),
                        url = linkedin,
                        contentDescription = "Image 1",
                        size = 30
                    )
                    ImageButton(
                        painter = painterResource(id = R.drawable.github_white),
                        url = email,
                        contentDescription = "Image 1",
                        size = 30
                    )
                }
            }
            photo?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "profile",
                    modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(50)),
                    contentScale = ContentScale.FillBounds
                )
            } ?: run {
                // Placeholder in case of null bitmap
                Image(
                    painter = painterResource(id = R.drawable.src_logo),
                    contentDescription = "src-logo",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(RoundedCornerShape(50)),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}