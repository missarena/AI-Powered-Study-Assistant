package com.example.security_test.repository;

import com.example.security_test.Entity.Note;
import com.example.security_test.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByUserAndDeletedFalse(User user);

    List<Note> findByUserAndTitleContainingIgnoreCase(User user, String keyword);

    List<Note> findByUserOrderByPinnedDesc(User user);

    List<Note> findByUserAndDeletedTrue(User user);

    List<Note> findByUserAndDeletedFalseOrderByPinnedDesc(User user);
}
