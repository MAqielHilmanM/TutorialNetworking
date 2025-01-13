package sg.motion.tutorialnetworking.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import sg.motion.tutorialnetworking.data.data_source.remote.network.RetrofitInstance
import sg.motion.tutorialnetworking.data.mapper.toModel
import sg.motion.tutorialnetworking.data.mapper.toRequestDto
import sg.motion.tutorialnetworking.data.model.Note

class NotesRepository {
    private val apiServices = RetrofitInstance.api

    suspend fun getAllNotes() : Result<List<Note>> = try {
        val result = apiServices.getAllNotes().map { dto -> dto.toModel() }
        Result.success(result)
    } catch (e : Exception) {
        Log.e("NotesRepository", "getAllNotes: "+e.message )
        Result.failure(e)
    }

    suspend fun getSelectedNote(id: String) : Result<Note> = try {
        val result = apiServices.getNoteById(id)
        if(result.error == null) {
            val resultNote = result.toModel()
            Result.success(resultNote)
        } else {
            Result.failure(Exception(result.error.message))
        }
    } catch (e : Exception) {
        Log.e("NotesRepository", "getSelectedNote: with id: $id message: "+e.message )
        Result.failure(e)
    }

    suspend fun createNote(newNote: Note) : Result<Note> = try {
        val result = apiServices.postNote(newNote.toRequestDto())
        if(result.error == null) {
            val resultNote = result.toModel()
            Result.success(resultNote)
        } else {
            Result.failure(Exception(result.error.message))
        }
    } catch (e : Exception) {
        Log.e("NotesRepository", "createNote: "+e.message )
        Result.failure(e)
    }

    suspend fun updateNoteWithPut(newNote: Note) : Result<Note> = try {
        val result = apiServices.putNote(newNote.id.orEmpty(), newNote.toRequestDto())
        if(result.error == null) {
            val resultNote = result.toModel()
            Result.success(resultNote)
        } else {
            Result.failure(Exception(result.error.message))
        }
    } catch (e : Exception) {
        Log.e("NotesRepository", "updateNoteWithPut: "+e.message )
        Result.failure(e)
    }

    suspend fun updateNoteWithPatch(newNote: Note) : Result<Note> = try {
        val result = apiServices.patchNote(newNote.id.orEmpty(), newNote.toRequestDto())
        if(result.error == null) {
            val resultNote = result.toModel()
            Result.success(resultNote)
        } else {
            Result.failure(Exception(result.error.message))
        }
    } catch (e : Exception) {
        Log.e("NotesRepository", "updateNoteWithPatch: "+e.message )
        Result.failure(e)
    }

    suspend fun deleteNote(noteId: String) : Result<Boolean> = try {
        val result = apiServices.deleteNote(noteId)

        if(result.success == true) {
            Result.success(true)
        } else {
            Result.failure(Exception(result.error?.message))
        }
    } catch (e : Exception) {
        Log.e("NotesRepository", "updateNoteWithPatch: "+e.message )
        Result.failure(e)
    }
}