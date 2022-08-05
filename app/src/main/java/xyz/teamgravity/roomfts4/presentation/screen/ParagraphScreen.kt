package xyz.teamgravity.roomfts4.presentation.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ireward.htmlcompose.HtmlText
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
                    if (viewmodel.searchExpanded) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            IconButton(onClick = viewmodel::onSearchCollapsed) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = stringResource(id = R.string.cd_cancel_search)
                                )
                            }
                            OutlinedTextField(
                                value = viewmodel.query,
                                onValueChange = viewmodel::onQueryChange,
                                singleLine = true,
                                placeholder = {
                                    Text(
                                        text = stringResource(id = R.string.search),
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                },
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    unfocusedBorderColor = Color.Transparent,
                                    focusedBorderColor = Color.Transparent
                                ),
                                textStyle = MaterialTheme.typography.bodyLarge
                            )
                        }
                    } else {
                        Text(text = stringResource(id = R.string.paragraphs))
                    }
                },
                actions = {
                    if (!viewmodel.searchExpanded) {
                        IconButton(onClick = viewmodel::onSearchExpanded) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = stringResource(id = R.string.cd_search)
                            )
                        }
                    }
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
                    HtmlText(
                        text = paragraph,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}