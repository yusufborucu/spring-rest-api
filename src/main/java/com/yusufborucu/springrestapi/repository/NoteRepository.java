package com.yusufborucu.springrestapi.repository;

import com.yusufborucu.springrestapi.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
