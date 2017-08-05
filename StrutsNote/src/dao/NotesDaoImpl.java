package dao;

import model.Notes;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pokedo on 2017/4/14.
 */
public class NotesDaoImpl extends BaseDao implements NotesDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public int addNote(Notes note) {
        String sql = "insert into notes(content, pubTime, title, userId, attachment) values (?,?,?,?,?)";
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String[] param = {
                note.getContent(), time, note.getTitle(), note.getUser().getUserId().toString(), note.getAttachment()
        };
        return this.executeSQL(sql, param);
    }

    @Override
    public List<Notes> getAllNotes() {
        List<Notes> list = new ArrayList<>();
        String sql = "select * from notes order by pubTime desc";
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Notes note = new Notes();
                note.setNoteId(rs.getInt("noteId"));
                note.setTitle(rs.getString("title"));
                note.setAttachment(rs.getString("attachment"));
                User user = new UserDaoImpl().findUser(rs.getInt("userId"));
                note.setUser(user);
                list.add(note);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return list;
    }

    @Override
    public Notes getNoteById(int noteId) {
        Notes note = new Notes();
        String sql = "select * from notes where noteId =" + noteId;
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                note.setNoteId(rs.getInt("noteId"));
                note.setContent(rs.getString("content"));
                note.setPubTime(rs.getTimestamp("pubTime"));
                note.setTitle(rs.getString("title"));
                note.setAttachment(rs.getString("attachment"));
                User user = new UserDaoImpl().findUser(rs.getInt("userId"));
                note.setUser(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return note;
    }
}
