package sg.motion.tutorialnetworking.data.mapper

import sg.motion.tutorialnetworking.data.data_source.remote.dto.NoteRequestDto
import sg.motion.tutorialnetworking.data.data_source.remote.dto.NoteResponseDto
import sg.motion.tutorialnetworking.data.model.Note

fun NoteResponseDto.toModel() = Note(
    id = this.id,
    content = this.content,
    userId = this.userId,
    createdAt = this.createdAt,
    updatedAt = this.updatedAt,
)

fun Note.toRequestDto() = NoteRequestDto(
    content = this.content,
    userId = this.userId,
    createdAt = this.createdAt,
    updatedAt = this.updatedAt,
)