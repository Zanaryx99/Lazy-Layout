package com.example.lazygrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.unit.dp
import com.example.lazygrid.ui.theme.LazyGridTheme

class MainActivity : ComponentActivity() {

    val universitas = listOf(
        Universitas(
            1,
            "Universitas Brawijaya",
            "Malang, Jawa Timur",
            R.drawable.logo1
        ),
        Universitas(
            2,
            "Universitas Indonesia",
            "Depok, Jawa Barat",
            R.drawable.logo2
        ),
        Universitas(
            3,
            "Institut Teknologi Bandung",
            "Bandung, Jawa Barat",
            R.drawable.logo3
        ),
        Universitas(
            4,
            "Universitas Gadjah Mada",
            "Yogyakarta",
            R.drawable.logo4
        ),
        Universitas(
            5,
            "Institut Teknologi Sepuluh Nopember",
            "Surabaya, Jawa Timur",
            R.drawable.logo5
        ),
        Universitas(
            6,
            "Universitas Airlangga",
            "Surabaya, Jawa Timur",
            R.drawable.logo6
        ),
        Universitas(
            7,
            "Universitas Diponegoro",
            "Semarang, Jawa Tengah",
            R.drawable.logo7
        ),
        Universitas(
            8,
            "Universitas Padjadjaran",
            "Sumedang, Jawa Barat",
            R.drawable.logo8
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            LazyGridTheme {
                UniversitasList(universitas)
            }
        }
    }
}
@Composable
fun UniversitasItem(universitas: Universitas) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(
                    id = universitas.image
                ),
                contentDescription = universitas.nama,
                modifier = Modifier
                    .size(80.dp)
            )

            Spacer(
                modifier = Modifier.width(16.dp)
            )

            Column {

                Text(
                    text = universitas.nama,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = universitas.lokasi,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

// Komponen List Vertikal dg sticky header
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UniversitasList(universitas: List<Universitas>) {

    LazyColumn(
        contentPadding = PaddingValues(bottom = 16.dp),
        modifier = Modifier.fillMaxSize()
    ) {

        stickyHeader {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .statusBarsPadding()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 12.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "NIM: 245150400111017",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = "Nama: Kharan Naethan Nizam",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }

        items(universitas) { item ->
            UniversitasItem(item)
        }
    }
}
