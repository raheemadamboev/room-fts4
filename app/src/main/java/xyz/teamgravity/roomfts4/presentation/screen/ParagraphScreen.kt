package xyz.teamgravity.roomfts4.presentation.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import xyz.teamgravity.roomfts4.R
import xyz.teamgravity.roomfts4.presentation.viewmodel.ParagraphViewModel

@Composable
fun ParagraphScreen(
    topAppBarState: TopAppBarState = rememberTopAppBarState(),
    topAppBarScroll: TopAppBarScrollBehavior = remember { TopAppBarDefaults.enterAlwaysScrollBehavior(state = topAppBarState) },
    viewmodel: ParagraphViewModel = hiltViewModel(),
) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.paragraphs))
                },
                scrollBehavior = topAppBarScroll
            )
        },
        modifier = Modifier.nestedScroll(topAppBarScroll.nestedScrollConnection)
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            items(viewmodel.paragraphs) { paragraph ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = paragraph,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}