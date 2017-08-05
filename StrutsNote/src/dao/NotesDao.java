package dao;


import model.Notes;

import java.util.List;

/**
 * Created by pokedo on 2017/4/14.
 */
public interface NotesDao {
    public int addNote(Notes note);

    public List<Notes> getAllNotes();

    public Notes getNoteById(int noteId);
}
