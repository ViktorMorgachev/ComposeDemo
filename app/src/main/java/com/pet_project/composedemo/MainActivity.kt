package com.pet_project.composedemo

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pet_project.composedemo.ui.data.Contact
import com.pet_project.composedemo.ui.data.toContact
import com.pet_project.composedemo.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(darkTheme = false) {
                PreviewMessageCard()
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

@Preview(name = "Light mode", uiMode = UI_MODE_NIGHT_NO, showBackground = true, showSystemUi = true)
//@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode", showSystemUi = true)
@Composable
fun PreviewMessageCard() {
    ContactCard(
        R.drawable.brother to ("Brother" to "+78959276370"),
        R.drawable.anastasia to ("Anastasia" to "+79995753220"),
        R.drawable.olga to ("Olga" to "+79912087747"),
        R.drawable.elizabet to ("Elizabet" to "+79877854748")
    )
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
fun ContactCard(contact: Contact) {
    Surface(shape = MaterialTheme.shapes.medium, elevation = 4.dp) {
        Row(modifier = Modifier
            .background(color = Color.White)
            .padding(all = 8.dp)) {
            Image(
                alignment = Alignment.Center,
                modifier = Modifier.size(40.dp)
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
