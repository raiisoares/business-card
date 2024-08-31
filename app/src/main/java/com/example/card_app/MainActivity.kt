package com.example.card_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.card_app.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.Transparent.toArgb(), Color.Transparent.toArgb()
            ),

            navigationBarStyle = SystemBarStyle.light(
                Color.Transparent.toArgb(), Color.Transparent.toArgb()
            )
        )

        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .navigationBarsPadding()
                            .statusBarsPadding()
                    ) {
                        CardContainer(
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DeveloperName(name: String, slogan: String, modifier: Modifier = Modifier) {
    Column(
        modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = name,
            fontSize = 48.sp,
            lineHeight = 98.sp,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )

        Text(
            text = slogan,
            fontSize = 28.sp,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun BackgroundImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.undraw_programming_re_kg9v)
    Image(
        painter = image,
        contentDescription = null,
        modifier
    )
}

@Composable
fun ContactComponent(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentWidth()
            .padding(bottom = 40.dp),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Row(modifier) {
            Icon(
                painter = painterResource(R.drawable.email_24dp_e8eaed),
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 10.dp)
            )

            Text(
                text = stringResource(R.string.email_text),
                fontSize = 18.sp,
            )
        }

        Row(modifier) {
            Icon(
                painter = painterResource(R.drawable.call_24dp_e8eaed),
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 10.dp)
            )

            Text(
                text = stringResource(R.string.phone_text),
                fontSize = 18.sp,
            )
        }

        Row(modifier) {
            Icon(
                painter = painterResource(R.drawable.code_24dp_e8eaed),
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 10.dp)
            )

            Text(
                text = stringResource(R.string.github_text),
                fontSize = 18.sp,
            )
        }

    }
}


@Composable
fun CardContainer(modifier: Modifier = Modifier) {
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackgroundImage(
            modifier = Modifier.padding(
                start = 60.dp,
                end = 60.dp,
                top = 30.dp,
                bottom = 60.dp
            )
        )

        DeveloperName(
            name = stringResource(R.string.name_text),
            slogan = stringResource(R.string.slogan_text),
            modifier = Modifier.wrapContentSize()
        )

        ContactComponent(modifier = Modifier.padding(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        CardContainer(modifier = Modifier.fillMaxSize())
    }
}