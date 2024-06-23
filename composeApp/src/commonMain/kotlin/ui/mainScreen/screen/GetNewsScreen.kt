package ui.mainScreen.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import data.ResponseDto.Article
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import ui.mainScreen.viewmodels.HomeViewModels

@Composable
fun GetNewsScreen(viewModels: HomeViewModels = koinInject()) {
    viewModels.callApi()
    val trendingNewsListObserver = viewModels.trendingNews.collectAsState()
    NewsList(trendingNewsListObserver.value)
}

@Composable
fun NewsList(trendingNewsListObserver: List<Article>) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(10.dp)) {
        items(trendingNewsListObserver) {
            NewsSingleComponent(it)
        }
    }
}

@Composable
fun NewsSingleComponent(item: Article) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = item.urlToImage,
                    contentDescription = "img",
                    contentScale = ContentScale.FillHeight
                )
            }


            Spacer(modifier = Modifier.padding(top = 15.dp))
            Text(
                text = item.title.toString(),
                fontWeight = FontWeight.Black,
                fontSize = 20.sp,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.fillMaxSize().padding(10.dp),
            )
        }

    }

}