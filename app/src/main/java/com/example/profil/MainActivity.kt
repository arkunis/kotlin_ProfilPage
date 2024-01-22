package com.example.profil


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profil.ui.theme.ProfilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfilTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
Box1(modifier = Modifier.fillMaxSize(),
    image = painterResource(id = R.drawable.background_dimension_3d_graphic_message_board_for_text_and_message_design_line_shadow_for_modern_web_design_free_vector),
    prop = false,
    scale = ContentScale.FillHeight,
    modifierImg = Modifier.fillMaxSize()
    )
}

@Composable
fun Box1(modifier: Modifier,
         image: Painter,
         desc: String?=null,
         prop: Boolean,
         scale: ContentScale,
         modifierImg: Modifier){
    Box(modifier = modifier, propagateMinConstraints = prop,){
        Image(painter = image, contentDescription = desc, contentScale = scale, modifier = modifierImg)

    }
Column(verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
Spacer(modifier = Modifier.height(5.dp))
    Row(modifier = Modifier.clip(CircleShape),
        ) {
        Profil(image = painterResource(id = R.drawable.ic_launcher_foreground),
            desc=null,
            scale = ContentScale.Fit,
            modifImg = Modifier
                .background(color = Color.Black.copy(alpha = 0.8F))
                .padding(2.dp)
                .width(100.dp)
                .height(100.dp)
                .clip(CircleShape),
            )

    }

    Divider()
    Spacer(modifier = Modifier.height(10.dp))
    Row(horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxWidth()) {
        Column {
            for(i in 1..5) {
                Profil(
                    image = painterResource(id = R.drawable.what_is_css_flex_),
                    scale = ContentScale.Fit,
                    modifImg = Modifier
                        .height(130.dp)
                        .width(130.dp)
                        .padding(start = 5.dp)
                )
            }
        }

        MaDesc(text = R.string.test, maSize = 20.sp,
            textModif = Modifier.padding(start= 10.dp, end=5.dp),
            colorText = Color.Blue,
            textLine = 35.sp)
    }
}
}

@Composable
fun Profil(image:Painter,
           desc: String?=null,
           scale: ContentScale,
           modifImg: Modifier
){
   Image(painter = image,
       contentDescription = desc,
       contentScale = scale,
       modifier = modifImg
       )
}

@Composable
fun MaDesc(text: Int, maSize: TextUnit, textModif: Modifier, colorText: Color, textLine: TextUnit){
    Text(text = stringResource(id = text), fontSize = maSize,
        modifier = textModif,
        color = colorText,
        lineHeight = textLine)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProfilTheme {
        Greeting()
    }
}