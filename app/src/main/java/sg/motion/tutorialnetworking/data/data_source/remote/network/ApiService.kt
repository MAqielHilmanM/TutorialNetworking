package sg.motion.tutorialnetworking.data.data_source.remote.network

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import sg.motion.tutorialnetworking.data.data_source.remote.dto.NoteDeleteResponseDto
import sg.motion.tutorialnetworking.data.data_source.remote.dto.NoteRequestDto
import sg.motion.tutorialnetworking.data.data_source.remote.dto.NoteResponseDto
import sg.motion.tutorialnetworking.data.model.Note

interface ApiService {
    @GET("api/notes")
    suspend fun getAllNotes(): List<NoteResponseDto>

    @GET("api/notes/{noteId}")
    suspend fun getNoteById(
        @Path("noteId") noteId: String
    ): NoteResponseDto

    @POST("api/notes")
    suspend fun postNote(
        @Body body: NoteRequestDto
    ): NoteResponseDto

    @PUT("api/notes/{noteId}")
    suspend fun putNote(
        @Path("noteId") noteId: String,
        @Body body: NoteRequestDto
    ): NoteResponseDto

    @PATCH("api/notes/{noteId}")
    suspend fun patchNote(
        @Path("noteId") noteId: String,
        @Body body: NoteRequestDto
    ): NoteResponseDto

    @DELETE("api/notes/{noteId}")
    suspend fun deleteNote(
        @Path("noteId") noteId: String,
    ): NoteDeleteResponseDto
}