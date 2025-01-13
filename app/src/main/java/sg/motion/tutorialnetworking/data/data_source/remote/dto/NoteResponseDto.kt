package sg.motion.tutorialnetworking.data.data_source.remote.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class NoteResponseDto(
    @SerializedName("id") val id: String? = null,
    @SerializedName("content") val content: String? = null,
    @SerializedName("userId") val userId: String? = null,
    @SerializedName("createdAt") val createdAt: String? = null,
    @SerializedName("updatedAt") val updatedAt: String? = null,

    @SerializedName("error") val error: ErrorResponseDto? = null,
)