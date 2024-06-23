package ui.mainScreen.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import io.ktor.http.ContentType
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import utils.DateAndTime.returnCurrentDate

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App(navHostController: NavHostController) {
    pre()
}

@Composable
fun pre() {
    KoinContext {
        MaterialTheme {
            Scaffold(modifier = Modifier.fillMaxWidth()) {
                Column {
                    Column(
                        modifier = Modifier.fillMaxWidth().height(150.dp).padding(start = 10.dp)
                    ) {
                        Text(
                            "🍎 News",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 30.sp,
                            modifier = Modifier.padding(top = 14.dp)
                        )
                        Spacer(modifier = Modifier.padding(2.dp))
                        Text(
                            "${returnCurrentDate()}",
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.DarkGray,
                            fontSize = 30.sp
                        )
                        Spacer(modifier = Modifier.padding(2.dp))
                        HorizontalDivider(
                            modifier = Modifier.padding(
                                start = 10.dp,
                                end = 10.dp
                            )
                        )
                    }
                    Text(
                        "Top Stories",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 36.sp,
                        color = Color.Red,
                        modifier = Modifier.padding(start = 14.dp)
                    )
                    GetNewsScreen()
                }
            }
        }
    }
}
