package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                PantallaComponentes()
            }
        }
    }

    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    fun PantallaComponentes() {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item { funcionLazyColumn() }
            item { funcionLazyRow() }
            item { funcionGrid() }
            item { funcionConstraintLayout() }
            item { funcionScaffold() }
            item { funcionSurface() }
            item { funcionChip() }
            item { funcionBackdropScaffold() }
            item { funcionFlowRow() }
            item { funcionFlowColumn() }

            item { funcionAlertDialog() }
            item { funcionCard() }
            item { funcionCheckbox() }
            item { funcionFloatingActionButton() }
            item { funcionIcon() }
            item { funcionImage() }
            item { funcionProgressBar() }
            item { funcionRadioButton() }
            item { funcionSlider() }
            item { funcionSpacer() }
            item { funcionSwitch() }
            item { funcionTopAppBar() }

            item { funcionBottomNavigation() }
            item { funcionDialog() }
            item { funcionDivider() }
            item { funcionDropDownMenu() }
            item { funcionLazyVerticalGrid() }
            item { funcionNavigationRail() }
            item { funcionOutlinedTextField() }
            item { funcionPager() }
            item { funcionSnackbar() }
            item { funcionTabRow() }
            item { funcionTooltip() }
        }
    }

    @Composable
    fun funcionLazyColumn() {
        Column {
            Text("Lazy Column")
            Text("Elemento vertical")
        }
    }

    @Composable
    fun funcionLazyRow() {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Text("Uno")
            }
            item {
                Text("Dos")
            }
            item {
                Text("Tres")
            }
        }
    }

    @Composable
    fun funcionGrid() {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                "A",
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(15.dp)
            )

            Text(
                "B",
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(15.dp)
            )

            Text(
                "C",
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(15.dp)
            )
        }
    }

    @Composable
    fun funcionConstraintLayout() {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {

            val texto = createRef()

            Text(
                "ConstraintLayout",
                modifier = Modifier.constrainAs(texto) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
            )
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun funcionScaffold() {

        Scaffold(
            modifier = Modifier.height(100.dp),
            topBar = {
                TopAppBar(
                    title = {
                        Text("Scaffold")
                    }
                )
            }
        ) { padding ->

            Text(
                "Contenido",
                modifier = Modifier.padding(padding)
            )
        }
    }

    @Composable
    fun funcionSurface() {

        Surface(
            modifier = Modifier.fillMaxWidth(),
            tonalElevation = 4.dp
        ) {
            Text(
                "Surface",
                modifier = Modifier.padding(16.dp)
            )
        }
    }

    @Composable
    fun funcionChip() {

        AssistChip(
            onClick = {},
            label = {
                Text("Chip")
            }
        )
    }

    @Composable
    fun funcionBackdropScaffold() {

        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.surfaceVariant
        ) {
            Text(
                "BackdropScaffold",
                modifier = Modifier.padding(16.dp)
            )
        }
    }

    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    fun funcionFlowRow() {

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text("Uno")
            Text("Dos")
            Text("Tres")
        }
    }

    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    fun funcionFlowColumn() {

        FlowColumn {
            Text("Uno")
            Text("Dos")
            Text("Tres")
        }
    }

    @Composable
    fun funcionAlertDialog() {

        var mostrar by remember {
            mutableStateOf(false)
        }

        Button(
            onClick = {
                mostrar = true
            }
        ) {
            Text("AlertDialog")
        }

        if (mostrar) {

            AlertDialog(
                onDismissRequest = {
                    mostrar = false
                },
                title = {
                    Text("Aviso")
                },
                text = {
                    Text("Este es un AlertDialog")
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            mostrar = false
                        }
                    ) {
                        Text("Aceptar")
                    }
                }
            )
        }
    }

    @Composable
    fun funcionCard() {

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "Card",
                modifier = Modifier.padding(16.dp)
            )
        }
    }

    @Composable
    fun funcionCheckbox() {

        var seleccionado by remember {
            mutableStateOf(false)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = seleccionado,
                onCheckedChange = {
                    seleccionado = it
                }
            )

            Text("Checkbox")
        }
    }

    @Composable
    fun funcionFloatingActionButton() {

        FloatingActionButton(
            onClick = {}
        ) {
            Text("+")
        }
    }

    @Composable
    fun funcionIcon() {

        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Inicio",
            modifier = Modifier.size(40.dp)
        )
    }

    @Composable
    fun funcionImage() {

        Image(
            imageVector = Icons.Default.Star,
            contentDescription = "Imagen",
            modifier = Modifier.size(50.dp)
        )
    }

    @Composable
    fun funcionProgressBar() {

        LinearProgressIndicator(
            progress = {
                0.6f
            },
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun funcionRadioButton() {

        var seleccionado by remember {
            mutableStateOf(false)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            RadioButton(
                selected = seleccionado,
                onClick = {
                    seleccionado = !seleccionado
                }
            )

            Text("RadioButton")
        }
    }

    @Composable
    fun funcionSlider() {

        var valor by remember {
            mutableStateOf(0.5f)
        }

        Slider(
            value = valor,
            onValueChange = {
                valor = it
            }
        )
    }

    @Composable
    fun funcionSpacer() {

        Column {

            Text("Texto arriba")

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text("Texto abajo")
        }
    }

    @Composable
    fun funcionSwitch() {

        var activo by remember {
            mutableStateOf(false)
        }

        Switch(
            checked = activo,
            onCheckedChange = {
                activo = it
            }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun funcionTopAppBar() {

        TopAppBar(
            title = {
                Text("TopAppBar")
            }
        )
    }

    @Composable
    fun funcionBottomNavigation() {

        var seleccionado by remember {
            mutableStateOf(0)
        }

        NavigationBar {

            NavigationBarItem(
                selected = seleccionado == 0,
                onClick = {
                    seleccionado = 0
                },
                icon = {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = "Inicio"
                    )
                },
                label = {
                    Text("Inicio")
                }
            )

            NavigationBarItem(
                selected = seleccionado == 1,
                onClick = {
                    seleccionado = 1
                },
                icon = {
                    Icon(
                        Icons.Default.Star,
                        contentDescription = "Favoritos"
                    )
                },
                label = {
                    Text("Favoritos")
                }
            )
        }
    }

    @Composable
    fun funcionDialog() {

        var mostrar by remember {
            mutableStateOf(false)
        }

        Button(
            onClick = {
                mostrar = true
            }
        ) {
            Text("Dialog")
        }

        if (mostrar) {

            Dialog(
                onDismissRequest = {
                    mostrar = false
                }
            ) {

                Card {

                    Text(
                        "Contenido del Dialog",
                        modifier = Modifier.padding(20.dp)
                    )
                }
            }
        }
    }

    @Composable
    fun funcionDivider() {

        Column {

            Text("Texto arriba")

            HorizontalDivider()

            Text("Texto abajo")
        }
    }

    @Composable
    fun funcionDropDownMenu() {

        var expandido by remember {
            mutableStateOf(false)
        }

        Box {

            Button(
                onClick = {
                    expandido = true
                }
            ) {
                Text("DropDownMenu")
            }

            DropdownMenu(
                expanded = expandido,
                onDismissRequest = {
                    expandido = false
                }
            ) {

                DropdownMenuItem(
                    text = {
                        Text("Opción 1")
                    },
                    onClick = {
                        expandido = false
                    }
                )

                DropdownMenuItem(
                    text = {
                        Text("Opción 2")
                    },
                    onClick = {
                        expandido = false
                    }
                )
            }
        }
    }

    @Composable
    fun funcionLazyVerticalGrid() {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.height(120.dp)
        ) {

            items(
                listOf(
                    "Uno",
                    "Dos",
                    "Tres",
                    "Cuatro"
                )
            ) {

                Text(
                    it,
                    modifier = Modifier
                        .padding(5.dp)
                        .background(Color.LightGray)
                        .padding(15.dp)
                )
            }
        }
    }

    @Composable
    fun funcionNavigationRail() {

        NavigationRail {

            NavigationRailItem(
                selected = true,
                onClick = {},
                icon = {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = "Inicio"
                    )
                },
                label = {
                    Text("Inicio")
                }
            )
        }
    }

    @Composable
    fun funcionOutlinedTextField() {

        var texto by remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = texto,
            onValueChange = {
                texto = it
            },
            label = {
                Text("Nombre")
            }
        )
    }

    @Composable
    fun funcionPager() {

        val pagerState = rememberPagerState(
            pageCount = {
                3
            }
        )

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.height(70.dp)
        ) { pagina ->

            Text(
                "Página ${pagina + 1}",
                modifier = Modifier.padding(20.dp)
            )
        }
    }

    @Composable
    fun funcionSnackbar() {

        val snackbarHostState = remember {
            SnackbarHostState()
        }

        SnackbarHost(
            hostState = snackbarHostState
        )
    }

    @Composable
    fun funcionTabRow() {

        var seleccionado by remember {
            mutableStateOf(0)
        }

        TabRow(
            selectedTabIndex = seleccionado
        ) {

            Tab(
                selected = seleccionado == 0,
                onClick = {
                    seleccionado = 0
                },
                text = {
                    Text("Tab 1")
                }
            )

            Tab(
                selected = seleccionado == 1,
                onClick = {
                    seleccionado = 1
                },
                text = {
                    Text("Tab 2")
                }
            )
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun funcionTooltip() {

        TooltipBox(
            positionProvider =
                TooltipDefaults.rememberPlainTooltipPositionProvider(),
            tooltip = {
                PlainTooltip {
                    Text("Información")
                }
            },
            state = rememberTooltipState()
        ) {

            Button(
                onClick = {}
            ) {
                Text("Tooltip")
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun VistaPrevia() {

    MaterialTheme {
        MainActivity().PantallaComponentes()
    }
}