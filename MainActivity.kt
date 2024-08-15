package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.sharp.Email
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import com.example.businesscard.ui.theme.Pink80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier) {
                    BusinessCardApp(
                        namedev = stringResource(R.string.name),
                        title = stringResource(R.string.title),
                        modifier = Modifier.background(White))
                }
            }
        }
    }
}

@Composable
fun ProfileText(namedev:String, title:String, modifier: Modifier = Modifier ){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = namedev,
            fontSize = 36.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(
                top = 24.dp,
                bottom = 8.dp
            )
        )

        Text(
            text = title,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}


@Composable
fun ContactRow(
    text: String, icon: ImageVector, textBlur: Dp = 0.dp
) {
    Row(
        horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Pink80,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = text, color = Color.Black, modifier = Modifier
                .weight(3f)
                .blur(textBlur)
        )
    }
}


@Composable
fun BusinessCardApp(namedev:String, title:String, modifier: Modifier = Modifier ){
    val image = painterResource(R.drawable.pngtreebeautiful_android_logo_vector_glyph_5152856)
    Column(modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        ){
        Spacer(modifier = Modifier.padding(top = 100.dp))
        Image(
            painter = image,
            contentDescription = null,
            Modifier.size(150.dp)

        )
        //Add some space between the image and text
        Spacer(modifier = Modifier.height(16.dp))
        ProfileText(
            namedev = stringResource(R.string.name),
            title = stringResource(R.string.title),
            modifier = modifier
        )
        Spacer(modifier = Modifier.padding(bottom = 100.dp))

        Divider(modifier = Modifier.fillMaxWidth(),color = Color.White)
        ContactRow(
            text = stringResource(R.string.phone_number),
            textBlur = 0.dp,
            icon = Icons.Rounded.Phone
        )
        Divider(modifier = Modifier.fillMaxWidth(),color = Color.White)
        ContactRow(
            text = stringResource(R.string.share),
            textBlur = 0.dp,
            icon = Icons.Rounded.Share
        )
        Divider(modifier = Modifier.fillMaxWidth(),color = Color.White)
        ContactRow(
            text = stringResource(R.string.email),
            textBlur = 0.dp,
            icon = Icons.Sharp.Email
        )
    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp(
            namedev = stringResource(R.string.name),
            title =  stringResource(R.string.title),
            modifier =  Modifier
        )
    }
}