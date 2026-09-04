package com.example.exploracioncomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.exploracioncomponentes.ui.theme.ExploracionComponentesTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExploracionComponentesTheme {
                GaleriaComponentes()
            }
        }
    }
}

@Composable
fun SectionCard(title: String, content: @Composable () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            content()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun GaleriaComponentes() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Galería de Componentes M3", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // ==================== CONTENEDORES ====================
            item {
                Text(
                    text = "CONTENEDORES",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                )
            }

            // 1. LazyRow
            item {
                SectionCard(title = "Componente: LazyRow") {
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(6) { index ->
                            Surface(
                                color = MaterialTheme.colorScheme.secondaryContainer,
                                shape = MaterialTheme.shapes.small,
                                modifier = Modifier.size(width = 100.dp, height = 50.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text("Item ${index + 1}")
                                }
                            }
                        }
                    }
                }
            }

            // 2. LazyVerticalGrid (Grid)
            item {
                SectionCard(title = "Componente: LazyVerticalGrid (Grid)") {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(6) { index ->
                            Surface(
                                color = MaterialTheme.colorScheme.tertiaryContainer,
                                shape = MaterialTheme.shapes.small,
                                modifier = Modifier.height(55.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text("Celda ${index + 1}")
                                }
                            }
                        }
                    }
                }
            }

            // 3. ConstraintLayout
            item {
                SectionCard(title = "Componente: ConstraintLayout") {
                    ConstraintLayout(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    ) {
                        val (btn, txt, icon) = createRefs()

                        Button(
                            onClick = { },
                            modifier = Modifier.constrainAs(btn) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                            }
                        ) {
                            Text("Botón A")
                        }

                        Text(
                            text = "Texto a la derecha",
                            modifier = Modifier.constrainAs(txt) {
                                top.linkTo(btn.top)
                                bottom.linkTo(btn.bottom)
                                start.linkTo(btn.end, margin = 12.dp)
                            }
                        )

                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.constrainAs(icon) {
                                top.linkTo(btn.bottom, margin = 8.dp)
                                start.linkTo(btn.start)
                            }
                        )
                    }
                }
            }

            // 4. Scaffold
            item {
                SectionCard(title = "Componente: Scaffold") {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Scaffold(
                            topBar = {
                                Surface(color = MaterialTheme.colorScheme.primaryContainer) {
                                    Text(
                                        "Mini TopBar de Scaffold",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(8.dp)
                                    )
                                }
                            }
                        ) { subPadding ->
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(subPadding),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Contenido de Scaffold")
                            }
                        }
                    }
                }
            }

            // 5. Surface
            item {
                SectionCard(title = "Componente: Surface") {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = MaterialTheme.shapes.medium,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shadowElevation = 4.dp
                    ) {
                        Box(
                            modifier = Modifier.padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Surface con elevación de sombra y color personalizado")
                        }
                    }
                }
            }

            // 6. AssistChip (Chip)
            item {
                SectionCard(title = "Componente: AssistChip (Chip)") {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        AssistChip(
                            onClick = { },
                            label = { Text("AssistChip") },
                            leadingIcon = {
                                Icon(
                                    Icons.Default.Star,
                                    contentDescription = null,
                                    modifier = Modifier.size(AssistChipDefaults.IconSize)
                                )
                            }
                        )
                        FilterChip(
                            selected = true,
                            onClick = { },
                            label = { Text("FilterChip") }
                        )
                    }
                }
            }

            // 7. FlowRow
            item {
                SectionCard(title = "Componente: FlowRow") {
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        val tags = listOf("Jetpack", "Compose", "Material 3", "Android", "FlowRow", "UI")
                        tags.forEach { tag ->
                            SuggestionChip(
                                onClick = { },
                                label = { Text(tag) }
                            )
                        }
                    }
                }
            }

            // 8. FlowColumn
            item {
                SectionCard(title = "Componente: FlowColumn") {
                    FlowColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(110.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        val itemsList = listOf("Col 1 - Item A", "Col 1 - Item B", "Col 1 - Item C", "Col 2 - Item D", "Col 2 - Item E")
                        itemsList.forEach { item ->
                            Surface(
                                color = MaterialTheme.colorScheme.secondaryContainer,
                                shape = MaterialTheme.shapes.extraSmall
                            ) {
                                Text(
                                    text = item,
                                    modifier = Modifier.padding(6.dp),
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                    }
                }
            }

            // ==================== CONTROLES BÁSICOS ====================
            item {
                Text(
                    text = "CONTROLES BÁSICOS",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
                )
            }

            // 9. AlertDialog
            item {
                SectionCard(title = "Componente: AlertDialog") {
                    var showDialog by remember { mutableStateOf(false) }

                    Button(onClick = { showDialog = true }) {
                        Text("Mostrar AlertDialog")
                    }

                    if (showDialog) {
                        AlertDialog(
                            onDismissRequest = { showDialog = false },
                            title = { Text("Diálogo de Ejemplo") },
                            text = { Text("Este es el mensaje dentro del AlertDialog.") },
                            confirmButton = {
                                TextButton(onClick = { showDialog = false }) {
                                    Text("Aceptar")
                                }
                            },
                            dismissButton = {
                                TextButton(onClick = { showDialog = false }) {
                                    Text("Cancelar")
                                }
                            }
                        )
                    }
                }
            }

            // 10. Card
            item {
                SectionCard(title = "Componente: Card") {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Título dentro de Card", style = MaterialTheme.typography.titleMedium)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text("Contenido descriptivo en el contenedor de tarjeta.")
                        }
                    }
                }
            }

            // 11. Checkbox
            item {
                SectionCard(title = "Componente: Checkbox") {
                    var checkedState by remember { mutableStateOf(true) }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = checkedState,
                            onCheckedChange = { checkedState = it }
                        )
                        Text("Casilla activada: $checkedState")
                    }
                }
            }

            // 12. FloatingActionButton
            item {
                SectionCard(title = "Componente: FloatingActionButton") {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        FloatingActionButton(onClick = { }) {
                            Icon(Icons.Default.Add, contentDescription = "Agregar")
                        }
                        ExtendedFloatingActionButton(
                            onClick = { },
                            icon = { Icon(Icons.Default.Add, contentDescription = null) },
                            text = { Text("FAB Extendido") }
                        )
                    }
                }
            }

            // 13. Icon
            item {
                SectionCard(title = "Componente: Icon") {
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favorito",
                            tint = Color.Red,
                            modifier = Modifier.size(32.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Estrella",
                            tint = Color(0xFFFFB300),
                            modifier = Modifier.size(32.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "Info",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            }

            // 14. Image
            item {
                SectionCard(title = "Componente: Image") {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = "Ejemplo Image",
                            modifier = Modifier
                                .size(60.dp)
                                .background(MaterialTheme.colorScheme.secondaryContainer)
                        )
                        Text("Imagen cargada desde recursos drawable")
                    }
                }
            }

            // 15. CircularProgressIndicator (ProgressBar)
            item {
                SectionCard(title = "Componente: CircularProgressIndicator (ProgressBar)") {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        CircularProgressIndicator()
                        LinearProgressIndicator(
                            progress = { 0.7f },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            // 16. RadioButton
            item {
                SectionCard(title = "Componente: RadioButton") {
                    var selectedOption by remember { mutableStateOf("Opción A") }
                    val options = listOf("Opción A", "Opción B")

                    Column {
                        options.forEach { option ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(vertical = 2.dp)
                            ) {
                                RadioButton(
                                    selected = (option == selectedOption),
                                    onClick = { selectedOption = option }
                                )
                                Text(text = option)
                            }
                        }
                    }
                }
            }

            // 17. Slider
            item {
                SectionCard(title = "Componente: Slider") {
                    var sliderValue by remember { mutableFloatStateOf(0.5f) }

                    Column {
                        Text("Valor del Slider: ${(sliderValue * 100).toInt()}%")
                        Slider(
                            value = sliderValue,
                            onValueChange = { sliderValue = it }
                        )
                    }
                }
            }

            // 18. Spacer
            item {
                SectionCard(title = "Componente: Spacer") {
                    Column {
                        Text("Texto superior")
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.outlineVariant)
                        ) {
                            Spacer(modifier = Modifier.height(20.dp))
                        }
                        Text("Texto inferior (separado por Spacer de 20.dp)")
                    }
                }
            }

            // 19. Switch
            item {
                SectionCard(title = "Componente: Switch") {
                    var isSwitchedOn by remember { mutableStateOf(true) }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Estado Switch: ${if (isSwitchedOn) "ENCENDIDO" else "APAGADO"}")
                        Switch(
                            checked = isSwitchedOn,
                            onCheckedChange = { isSwitchedOn = it }
                        )
                    }
                }
            }

            // 20. TopAppBar
            item {
                SectionCard(title = "Componente: TopAppBar") {
                    Surface(
                        shadowElevation = 2.dp,
                        shape = MaterialTheme.shapes.small
                    ) {
                        TopAppBar(
                            title = { Text("Ejemplo TopAppBar", style = MaterialTheme.typography.titleMedium) },
                            navigationIcon = {
                                IconButton(onClick = { }) {
                                    Icon(Icons.Default.Menu, contentDescription = "Menú")
                                }
                            },
                            actions = {
                                IconButton(onClick = { }) {
                                    Icon(Icons.Default.Settings, contentDescription = "Ajustes")
                                }
                            }
                        )
                    }
                }
            }

            // ==================== CONTROLES AVANZADOS ====================
            item {
                Text(
                    text = "CONTROLES AVANZADOS",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
                )
            }

            // 21. NavigationBar (BottomNavigation)
            item {
                SectionCard(title = "Componente: NavigationBar (BottomNavigation)") {
                    var selectedNavIndex by remember { mutableIntStateOf(0) }
                    val navItems = listOf("Inicio", "Buscar", "Ajustes")
                    val navIcons = listOf(Icons.Default.Home, Icons.Default.Search, Icons.Default.Settings)

                    NavigationBar(modifier = Modifier.fillMaxWidth()) {
                        navItems.forEachIndexed { index, item ->
                            NavigationBarItem(
                                icon = { Icon(navIcons[index], contentDescription = item) },
                                label = { Text(item) },
                                selected = selectedNavIndex == index,
                                onClick = { selectedNavIndex = index }
                            )
                        }
                    }
                }
            }

            // 22. Dialog
            item {
                SectionCard(title = "Componente: Dialog") {
                    var showCustomDialog by remember { mutableStateOf(false) }

                    Button(onClick = { showCustomDialog = true }) {
                        Text("Abrir Dialog Custom")
                    }

                    if (showCustomDialog) {
                        Dialog(onDismissRequest = { showCustomDialog = false }) {
                            Surface(
                                shape = MaterialTheme.shapes.large,
                                color = MaterialTheme.colorScheme.surface,
                                tonalElevation = 6.dp,
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Column(
                                    modifier = Modifier.padding(24.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text("Diálogo Personalizado", style = MaterialTheme.typography.headlineSmall)
                                    Spacer(modifier = Modifier.height(12.dp))
                                    Text("Vista flotante renderizada mediante Dialog().")
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Button(onClick = { showCustomDialog = false }) {
                                        Text("Cerrar")
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // 23. HorizontalDivider (Divider)
            item {
                SectionCard(title = "Componente: HorizontalDivider (Divider)") {
                    Column {
                        Text("Contenido Superior")
                        HorizontalDivider(
                            modifier = Modifier.padding(vertical = 8.dp),
                            thickness = 2.dp,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text("Contenido Inferior")
                    }
                }
            }

            // 24. DropdownMenu
            item {
                SectionCard(title = "Componente: DropdownMenu") {
                    var expanded by remember { mutableStateOf(false) }
                    var selectedOptionText by remember { mutableStateOf("Selecciona una opción") }

                    Box {
                        OutlinedButton(onClick = { expanded = true }) {
                            Text(selectedOptionText)
                            Icon(Icons.Default.MoreVert, contentDescription = null)
                        }

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Opción 1") },
                                onClick = {
                                    selectedOptionText = "Opción 1"
                                    expanded = false
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Opción 2") },
                                onClick = {
                                    selectedOptionText = "Opción 2"
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }

            // 25. NavigationRail
            item {
                SectionCard(title = "Componente: NavigationRail") {
                    var selectedRailItem by remember { mutableIntStateOf(0) }

                    Surface(
                        modifier = Modifier.height(160.dp),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                    ) {
                        Row {
                            NavigationRail {
                                NavigationRailItem(
                                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                                    label = { Text("Inicio") },
                                    selected = selectedRailItem == 0,
                                    onClick = { selectedRailItem = 0 }
                                )
                                NavigationRailItem(
                                    icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
                                    label = { Text("Perfil") },
                                    selected = selectedRailItem == 1,
                                    onClick = { selectedRailItem = 1 }
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("Pestaña activa: ${if (selectedRailItem == 0) "Inicio" else "Perfil"}")
                            }
                        }
                    }
                }
            }

            // 26. OutlinedTextField
            item {
                SectionCard(title = "Componente: OutlinedTextField") {
                    var textValue by remember { mutableStateOf("") }

                    OutlinedTextField(
                        value = textValue,
                        onValueChange = { textValue = it },
                        label = { Text("Nombre de usuario") },
                        placeholder = { Text("Ingresa tu texto...") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                }
            }

            // 27. HorizontalPager (Pager)
            item {
                SectionCard(title = "Componente: HorizontalPager (Pager)") {
                    val pagerState = rememberPagerState(pageCount = { 3 })

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        HorizontalPager(
                            state = pagerState,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(90.dp)
                        ) { page ->
                            Surface(
                                color = when (page) {
                                    0 -> MaterialTheme.colorScheme.primaryContainer
                                    1 -> MaterialTheme.colorScheme.secondaryContainer
                                    else -> MaterialTheme.colorScheme.tertiaryContainer
                                },
                                shape = MaterialTheme.shapes.medium,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(4.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(
                                        text = "Página ${page + 1} del Pager (Desliza lateralmente)",
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            }
                        }
                        Text(
                            text = "Página actual: ${pagerState.currentPage + 1} de 3",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }

            // 28. Snackbar
            item {
                SectionCard(title = "Componente: Snackbar") {
                    val snackbarHostState = remember { SnackbarHostState() }
                    val coroutineScope = rememberCoroutineScope()

                    Column {
                        Button(onClick = {
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar("¡Mensaje mostrado desde Snackbar!")
                            }
                        }) {
                            Text("Mostrar Snackbar")
                        }

                        SnackbarHost(hostState = snackbarHostState)
                    }
                }
            }

            // 29. TabRow
            item {
                SectionCard(title = "Componente: TabRow") {
                    var selectedTabIndex by remember { mutableIntStateOf(0) }
                    val tabTitles = listOf("Pestaña 1", "Pestaña 2", "Pestaña 3")

                    Column {
                        TabRow(selectedTabIndex = selectedTabIndex) {
                            tabTitles.forEachIndexed { index, title ->
                                Tab(
                                    selected = selectedTabIndex == index,
                                    onClick = { selectedTabIndex = index },
                                    text = { Text(title) }
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Contenido visible: ${tabTitles[selectedTabIndex]}")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GaleriaComponentesPreview() {
    ExploracionComponentesTheme {
        GaleriaComponentes()
    }
}
