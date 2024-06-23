package ui.mainScreen.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import data.ResponseDto.Article
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
    LazyColumn(modifier = Modifier.fillMaxSize().padding(start = 10.dp, end = 10.dp, top = 6.dp)) {
        items(trendingNewsListObserver) {
            if (it.urlToImage?.isNotEmpty() == true) {
                NewsSingleComponent(it)
            }

        }
    }
}

@Composable
fun NewsSingleComponent(item: Article) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.elevatedCardElevation(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)

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
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Text(
                text = item.author.toString(),
                fontWeight = FontWeight.Black,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                color = Color.DarkGray,
                modifier = Modifier.fillMaxSize().padding(10.dp),
            )
            Spacer(modifier = Modifier.padding(top = 1.dp))
            Text(
                text = item.title.toString(),
                fontWeight = FontWeight.Black,
                fontSize = 20.sp,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.fillMaxSize().padding(10.dp),
            )
            Spacer(modifier = Modifier.padding(top = 2.dp))
            HorizontalDivider(
                modifier = Modifier.padding(
                    start = 10.dp,
                    end = 10.dp
                )
            )

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = item.publishedAt.toString(),
                    fontWeight = FontWeight.Black,
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Normal,
                    modifier = Modifier.wrapContentWidth().padding(10.dp),
                )
                Spacer(modifier = Modifier.padding(start = 2.dp))
                if (item.author?.isNotEmpty() == true) {
                    Text(
                        text = item.author.toString(),
                        fontWeight = FontWeight.Black,
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier.wrapContentHeight().padding(10.dp),
                    )
                }

            }

        }

    }

}