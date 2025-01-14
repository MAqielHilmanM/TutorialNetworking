package sg.motion.tutorialnetworking.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import sg.motion.tutorialnetworking.data.model.Note
import sg.motion.tutorialnetworking.ui.home.widgets.NoteFormBottomSheet
import sg.motion.tutorialnetworking.ui.home.widgets.NoteItem

// Home Screen with Bottom Navigation
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    // State for notes and new note input
    var notes by remember { mutableStateOf(listOf<Note>()) }
    var selectedNotes = remember { Note() }
    var errorMessage by remember { mutableStateOf("") }
    var showBottomSheet by remember { mutableStateOf(false) }
    var isEditing by remember { mutableStateOf(false) }

    // TODO : init notes repository here !

    // Coroutine scope for async operations
    val scope = rememberCoroutineScope()

    // Function to load all data
    suspend fun loadAllData() {
        selectedNotes = Note()

        // TODO: call get all notes here!
    }

    // Collect notes for first time
    LaunchedEffect(Unit) {
        scope.launch {
            // TODO : call load all data here!
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Notes") },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    isEditing = false
                    showBottomSheet = true
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Note"
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Error Message
            if (errorMessage.isNotBlank()) {
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(16.dp)
                )
            }

            // Notes List
            LazyColumn {
                // Load all notes
                items(notes) { note ->
                    NoteItem(
                        note = note,
                        onUpdate = {
                            scope.launch {
                                selectedNotes = note
                                isEditing = true
                                showBottomSheet = true
                            }
                        },
                        onDelete = {
                            scope.launch {
                                // TODO: Call delete note here!
                            }
                        }
                    )
                }
            }
        }

        if (showBottomSheet) {
            NoteFormBottomSheet(
                oldNote = selectedNotes,
                isEditing = isEditing,
                onSave = { note ->
                    scope.launch {
                        if (isEditing) {
                            // TODO: Call update Note here!
                        } else {
                            // TODO: Call create new Note here!
                        }
                    }
                },
                onDismiss = {
                    showBottomSheet = false
                }
            )
        }
    }
}

