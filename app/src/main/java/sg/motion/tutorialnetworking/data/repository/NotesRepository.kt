package sg.motion.tutorialnetworking.data.repository

import sg.motion.tutorialnetworking.data.model.Note

class NotesRepository {
    // TODO : create global variable for api service here!

    // TODO : define getAllNotes from retrofit
    suspend fun getAllNotes() : Result<List<Note>> { return Result.failure(Exception()) }

    // TODO : define getSelectedNote from retrofit
    suspend fun getSelectedNote(id: String) : Result<Note> { return Result.failure(Exception()) }

    // TODO : define createNote from retrofit
    suspend fun createNote(newNote: Note) : Result<Note> { return Result.failure(Exception()) }

    // TODO : define updateNoteWithPut from retrofit
    suspend fun updateNoteWithPut(newNote: Note) : Result<Note> { return Result.failure(Exception()) }

    // TODO : define updateNoteWithPatch from retrofit
    suspend fun updateNoteWithPatch(newNote: Note) : Result<Note> { return Result.failure(Exception()) }

    // TODO : define deleteNote from retrofit
    suspend fun deleteNote(noteId: String) : Result<Boolean> { return Result.failure(Exception()) }
}