package com.d29.practica5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.Dp

import com.d29.practica5.ui.theme.Practica5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {


                    }
                }
            }
        }
    }
}


// Pantalla 1: Login
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.TopCenter
    ) {
        DiagonalBackgrounds()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(28.dp)
        ) {
            Text("Aura Plus", color = Color.White, fontSize = 39.sp)

            Spacer(modifier = Modifier.height(120.dp))

            CustomOutlinedTextField(value = email, onValueChange = { email = it }, label = "Email")
            Spacer(modifier = Modifier.height(16.dp))
            CustomOutlinedTextField(value = password, onValueChange = { password = it }, label = "Password")
            Spacer(modifier = Modifier.height(24.dp))

            Button(modifier = Modifier.fillMaxWidth(), onClick = { /*  */ }) {
                Text("Log In")
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(onClick = { /* Handle registration */ }) {
                Text("Registrarse")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text("Continuar", color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))

            Button(modifier = Modifier.fillMaxWidth(), onClick = { /* Handle Google login */ }) {
                Text("Google")
            }
        }
    }
}

// Pantalla 2: CrearCuenta
@Composable
fun CrearCuentaScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.TopCenter
    ) {
        DiagonalBackgrounds()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(28.dp)
        ) {
            Text("Crear Cuenta", color = Color.White, fontSize = 39.sp)

            Spacer(modifier = Modifier.height(120.dp))

            CustomOutlinedTextField(value = email, onValueChange = { email = it }, label = "Email")
            Spacer(modifier = Modifier.height(16.dp))
            CustomOutlinedTextField(value = password, onValueChange = { password = it }, label = "Password")
            Spacer(modifier = Modifier.height(24.dp))

            Button(modifier = Modifier.fillMaxWidth(), onClick = { /* Handle create account */ }) {
                Text("Guardar")
            }
        }
    }
}

// Pantalla 3: EstadoDiario y Emociones
@Composable
fun EstadoDiarioScreen() {
    var notes by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F6F6))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DatePickerRow("vie, 10 de Octubre")
                Spacer(modifier = Modifier.height(30.dp))

                Text("Bienvenido, Willian.", style = TextStyle(fontSize = 24.sp, color = Color.Black))
                Text("¿Cómo te sentiste hoy?", style = TextStyle(fontSize = 16.sp, color = Color.Gray))

                Spacer(modifier = Modifier.height(30.dp))
                EmotionSelector()
                Spacer(modifier = Modifier.height(24.dp))

                Text("Añadir imagen...", style = TextStyle(fontSize = 14.sp, color = Color.Gray), modifier = Modifier.align(Alignment.Start))
                AddImageBox()

                Spacer(modifier = Modifier.height(16.dp))
                Text("Añadir notas...", style = TextStyle(fontSize = 14.sp, color = Color.Gray), modifier = Modifier.align(Alignment.Start))
                AddNotesBox(notes = notes, onNotesChange = { notes = it })

                Spacer(modifier = Modifier.height(16.dp))


            }
            BottomNavigationBar()
        }
    }
}

@Composable
fun CalendarioDeOctubre() {
    val semanas = listOf(
        listOf("", "", "", "1", "2", "3", "4"),
        listOf("5", "6", "7", "8", "9", "10", "11"),
        listOf("12", "13", "14", "15", "16", "17", "18"),
        listOf("19", "20", "21", "22", "23", "24", "25"),
        listOf("26", "27", "28", "29", "30", "31", "")
    )

    val diasDeLaSemana = listOf("Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(16.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Nombre del mes y año
        Text(
            text = "Octubre 2024",
            style = TextStyle(fontSize = 18.sp, color = Color.Black)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Días de la semana (cabeceras)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            diasDeLaSemana.forEach { dia ->
                Text(text = dia, color = Color.Gray, fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Calendario del mes
        semanas.forEach { semana ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                semana.forEach { dia ->
                    if (dia.isEmpty()) {
                        Spacer(modifier = Modifier.size(32.dp))
                    } else {
                        DayCell(dia = dia)
                    }
                }
            }
        }
    }
}

@Composable
fun DayCell(dia: String) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .background(Color.White, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(text = dia, color = Color.Black, fontSize = 14.sp)
    }
}

// Pantalla 4: PantallaCuenta (Pantalla del perfil)
@Composable
fun PantallaCuenta() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0F7FA))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UserProfileSection()
        Spacer(modifier = Modifier.height(24.dp))
        Text("My Reports:", fontSize = 18.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(16.dp))
        ReportSection()
        Spacer(modifier = Modifier.weight(1f))
        BottomNavigationBar()
    }
}

// Pantalla 5: Estadisticas
fun EstadisticasScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DatePickerRow("vie, 10 de Octubre")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* Acción para contador */ },
            colors = ButtonDefaults.buttonColors(Color(0xFF6200EA)),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Contador de Ánimo", color = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Gráfico de barras
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color(0xFF4CAF50), shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                BarWithIcon(height = 100.dp, color = Color.Black, icon = android.R.drawable.ic_menu_gallery)
                BarWithIcon(height = 80.dp, color = Color.Yellow, icon = android.R.drawable.ic_menu_camera)
                BarWithIcon(height = 60.dp, color = Color.Blue, icon = android.R.drawable.ic_menu_manage)
                BarWithIcon(height = 40.dp, color = Color.Magenta, icon = android.R.drawable.ic_menu_compass)
            }
        }
// Calendario
        Spacer(modifier = Modifier.size(32.dp))
        CalendarioDeOctubre()
        Spacer(modifier = Modifier.weight(1f))

        BottomNavigationBar()
    }
}

// Reutilización de componentes comunes
@Composable
fun DiagonalBackgrounds() {
    DiagonalBox(rotationZ = -45f, offset = Pair(-120.dp, -100.dp), color = Color.Red)
    DiagonalBox(rotationZ = 45f, offset = Pair(240.dp, -120.dp), color = Color.Blue)
}

@Composable
fun DiagonalBox(rotationZ: Float, offset: Pair<Dp, Dp>, color: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth(1.2f)
            .height(250.dp)
            .graphicsLayer(rotationZ = rotationZ)
            .offset(x = offset.first, y = offset.second)
            .border(1.dp, Color.White, RoundedCornerShape(16.dp))
            .background(color, RoundedCornerShape(16.dp))
    )
}

@Composable
fun CustomOutlinedTextField(value: String, onValueChange: (String) -> Unit, label: String) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun EmotionSelector() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        EmotionIcon(painterResource(id = android.R.drawable.ic_menu_camera), "Happy", Color(0xFFFFC0CB))
        EmotionIcon(painterResource(id = android.R.drawable.ic_menu_camera), "Calm", Color(0xFFB3E5FC))
        EmotionIcon(painterResource(id = android.R.drawable.ic_menu_camera), "Relax", Color(0xFFFFF9C4))
        EmotionIcon(painterResource(id = android.R.drawable.ic_menu_camera), "Focus", Color(0xFFD1C4E9))

    }

}


@Composable
fun EmotionIcon(painter: Painter, label: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(color, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painter, contentDescription = label, modifier = Modifier.size(30.dp))
        }
        Text(label, fontSize = 12.sp, color = Color.Gray)
    }
}

@Composable
fun AddImageBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color(0xFFE0E0E0), RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        Icon(painter = painterResource(id = android.R.drawable.ic_menu_add), contentDescription = "Añadir imagen", modifier = Modifier.size(48.dp), tint = Color.DarkGray)
    }
}

@Composable
fun AddNotesBox(notes: String, onNotesChange: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color(0xFFE0E0E0), RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            BasicTextField(value = notes, onValueChange = onNotesChange, textStyle = TextStyle(fontSize = 16.sp), modifier = Modifier.weight(1f))
            Icon(painter = painterResource(id = android.R.drawable.ic_menu_add), contentDescription = "Añadir nota", modifier = Modifier.size(40.dp), tint = Color.DarkGray)
        }
    }
}

@Composable
fun UserProfileSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color(0xFF00BCD4), RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                contentDescription = "Foto de perfil",
                modifier = Modifier.size(80.dp).background(Color.White, CircleShape),
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("William Name", fontSize = 20.sp, color = Color.White)
            Text("william******@gmail.com", fontSize = 14.sp, color = Color.White)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Editar", fontSize = 14.sp, color = Color.White)
        }
    }
}

@Composable
fun ReportSection() {
    Column {
        ReportRow(
            reports = listOf(
                ReportCardData("Días Importantes", Color(0xFFFFEB3B), android.R.drawable.ic_menu_today),
                ReportCardData("Galería de fotos", Color(0xFF4CAF50), android.R.drawable.ic_menu_gallery)
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        ReportRow(
            reports = listOf(
                ReportCardData("Informes Semanales", Color(0xFFF44336), android.R.drawable.ic_menu_report_image),
                ReportCardData("Control de Hábitos", Color(0xFFFFC107), android.R.drawable.ic_menu_agenda)
            )
        )
    }
}

data class ReportCardData(val title: String, val color: Color, val icon: Int)

@Composable
fun ReportRow(reports: List<ReportCardData>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        reports.forEach { ReportCard(it) }
    }
}

@Composable
fun ReportCard(data: ReportCardData) {
    Box(
        modifier = Modifier.size(140.dp).background(data.color, RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(painter = painterResource(id = data.icon), contentDescription = data.title, tint = Color.White, modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(data.title, color = Color.White, fontSize = 14.sp)
        }
    }
}

@Composable
fun BottomNavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        listOf(
            android.R.drawable.ic_menu_help to "Inicio",
            android.R.drawable.ic_menu_search to "Buscar",
            android.R.drawable.ic_menu_myplaces to "Actividad",
            android.R.drawable.ic_menu_manage to "Configuración"
        ).forEach { (icon, description) ->
            Icon(painter = painterResource(id = icon), contentDescription = description, tint = Color.Black, modifier = Modifier.size(40.dp))
        }
    }
}

@Composable
fun BarWithIcon(height: Dp, color: Color, icon: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .width(40.dp)
                .height(height)
                .background(color, shape = RoundedCornerShape(4.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun DatePickerRow(date: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* Previous date */ }) {
            Icon(painter = painterResource(id = android.R.drawable.ic_media_previous), contentDescription = "Previous Date", tint = Color.Black)
        }
        Text(text = date, style = TextStyle(fontSize = 18.sp, color = Color(0xFF00A8E8)), modifier = Modifier
            .background(Color(0xFFE0F7FA), shape = RoundedCornerShape(50))
            .padding(horizontal = 16.dp, vertical = 8.dp))
        IconButton(onClick = { /* Next date */ }) {
            Icon(painter = painterResource(id = android.R.drawable.ic_media_next), contentDescription = "Next Date", tint = Color.Black)
        }
    }
}

// Previews
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

@Preview(showBackground = true)
@Composable
fun CrearCuentaScreenPreview() {
    CrearCuentaScreen()
}

@Preview(showBackground = true)
@Composable
fun EstadoDiarioScreenPreview() {
    EstadoDiarioScreen()
}

@Preview(showBackground = true)
@Composable
fun PantallaCuentaPreview() {
    PantallaCuenta()
}

@Preview(showBackground = true)
@Composable
fun EstadisticasScreenPreview() {
    EstadisticasScreen()
}
