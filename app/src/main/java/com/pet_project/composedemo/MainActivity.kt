package com.pet_project.composedemo

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pet_project.composedemo.ui.data.*
import com.pet_project.composedemo.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(darkTheme = false) {
                PreviewConversation()
            }
        }
    }
}

@Composable
fun ContactCard(vararg card: Pair<Int, Pair<String, String>>) {
    card.takeLast(1).asIterable().forEach {
        ContactCard(it.toContact())
    }

}

//@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode", showSystemUi = true)
@Preview(name = "Light mode", uiMode = UI_MODE_NIGHT_NO, showBackground = true, showSystemUi = true)
@Composable
fun PreviewConversation() {
    Conversation(messages = sampleConversation)
}

@Composable
fun CardTextView(
    text: String,
    colorAuthor: Color = Color.Black,
    style: TextStyle = MaterialTheme.typography.caption
) {
    Text(
        text = text,
        modifier = Modifier.padding(horizontal = 8.dp),
        color = colorAuthor,
        style = style
    )
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            ContactMessage(message = message)
        }
    }
}

@Composable
fun ContactMessage(message: Message) {

    var isExpanded by remember {
        mutableStateOf(false)
    }
    val messageColor: Color by animateColorAsState(targetValue = if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface)
    Surface(shape = MaterialTheme.shapes.medium, elevation = 4.dp) {
        Row(
            modifier = Modifier
                .background(color = Color.White)
                .padding(all = 8.dp)
        ) {
            Image(
                alignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape),
                painter = painterResource(id = message.photoID),
                contentDescription = "Contact profile picture"
            )

            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                CardTextView(
                    text = message.name,
                    colorAuthor = MaterialTheme.colors.secondary,
                    style = MaterialTheme.typography.body1
                )
                Spacer(modifier = Modifier.height(4.dp))
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    elevation = 1.dp,
                    color = messageColor,
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                ) {
                    Text(
                        text = message.message,
                        style = MaterialTheme.typography.body2,
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1
                    )
                }
            }
        }
    }

}

@Composable
fun ContactCard(contact: Contact) {
    Surface(shape = MaterialTheme.shapes.medium, elevation = 4.dp) {
        Row(
            modifier = Modifier
                .background(color = Color.White)
                .padding(all = 8.dp)
        ) {
            Image(
                alignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape),
                painter = painterResource(id = contact.photoID),
                contentDescription = "Contact profile picture"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column() {
                CardTextView(
                    text = contact.name,
                    colorAuthor = MaterialTheme.colors.secondary,
                    style = MaterialTheme.typography.body1
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = contact.phone, style = MaterialTheme.typography.body2)
            }
        }
    }

}
