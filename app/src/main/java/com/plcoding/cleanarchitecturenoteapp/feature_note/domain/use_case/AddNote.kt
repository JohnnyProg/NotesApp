package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case


import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository

class AddNote(
    private val noteRepository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if(note.title.isBlank()) {
            throw InvalidNoteException("missing title")
        }
        if(note.content.isBlank()) {
            throw InvalidNoteException("missing content")
        }
        noteRepository.insertNote(note)
    }

}