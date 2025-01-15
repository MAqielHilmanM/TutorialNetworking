package sg.motion.tutorialnetworking.data.repository

import android.util.Log
import sg.motion.tutorialnetworking.data.data_source.remote.network.RetrofitInstance
import sg.motion.tutorialnetworking.data.mapper.toModel
import sg.motion.tutorialnetworking.data.mapper.toRequestDto
import sg.motion.tutorialnetworking.data.model.Note
import kotlin.math.log

class NotesRepository {
    // TODO : create global variable for api service here!
    private val service = RetrofitInstance.apiService

    // TODO : define getAllNotes from retrofit
    suspend fun getAllNotes() : Result<List<Note>> {
        return try {
            val result = service.getAllNotes().map { item -> item.toModel()  }

            Result.success(result)
        } catch (e: Exception) {
            Log.e("NotesRepository", "getAllNotes: "+e.message )
            Result.failure(e)
        }
    }

    // TODO : define getSelectedNote from retrofit
    suspend fun getSelectedNote(id: String) : Result<Note> {
        return try {
            val resultData = service.getNoteById(id)
            if(resultData.error != null) {
                Log.e("NotesRepository", "getSelectedNote: "+resultData.error.message )
                Result.failure(Exception(resultData.error.message))
            } else {
                Result.success(resultData.toModel())
            }
        } catch (e: Exception) {
            Log.e("NotesRepository", "getSelectedNote: "+e.message )
            Result.failure(e)
        }
    }

    // TODO : define createNote from retrofit
    suspend fun createNote(newNote: Note) : Result<Note> {
        return try {
            val resultData = service.postNote(newNote.toRequestDto())

            if(resultData.error != null) {
                Log.e("NotesRepository", "createNote: "+resultData.error.message )
                Result.failure(Exception(resultData.error.message))
            } else {
                Result.success(resultData.toModel())
            }
        } catch (e: Exception) {
            Log.e("NotesRepository", "createNote: "+e.message )
            Result.failure(e)
        }
    }

    // TODO : define updateNoteWithPut from retrofit
    suspend fun updateNoteWithPut(newNote: Note) : Result<Note> {
        return try {
            val resultData = service.putNote(
                noteId = newNote.id.orEmpty(),
                request = newNote.toRequestDto()
            )

            if(resultData.error != null) {
                Log.e("NotesRepository", "updateNoteWithPut: "+resultData.error.message )
                Result.failure(Exception(resultData.error.message))
            } else {
                Result.success(resultData.toModel())
            }
        } catch (e: Exception) {
            Log.e("NotesRepository", "updateNoteWithPut: "+e.message )
            Result.failure(e)
        }
    }

    // TODO : define updateNoteWithPatch from retrofit
    suspend fun updateNoteWithPatch(newNote: Note) : Result<Note> {
        return try {
            val resultData = service.patchNote(
                noteId = newNote.id.orEmpty(),
                request = newNote.toRequestDto()
            )

            if(resultData.error != null) {
                Log.e("NotesRepository", "updateNoteWithPatch: "+resultData.error.message )
                Result.failure(Exception(resultData.error.message))
            } else {
                Result.success(resultData.toModel())
            }
        } catch (e: Exception) {
            Log.e("NotesRepository", "updateNoteWithPatch: "+e.message )
            Result.failure(e)
        }
    }

    // TODO : define deleteNote from retrofit
    suspend fun deleteNote(noteId: String) : Result<Boolean> {
        return try {
            val resultData = service.deleteNote(
                noteId = noteId,
            )

            if(resultData.error != null) {
                Log.e("NotesRepository", "deleteNote: "+resultData.error.message )
                Result.failure(Exception(resultData.error.message))
            } else {
                Result.success(true)
            }
        } catch (e: Exception) {
            Log.e("NotesRepository", "deleteNote: "+e.message )
            Result.failure(e)
        }
    }
}