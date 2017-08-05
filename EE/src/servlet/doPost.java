package servlet;

import Bean.Notes;
import Bean.User;
import Dao.NotesDao;
import Dao.NotesDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class doPost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = new String(request.getParameter("title"));
        String content = new String(request.getParameter("content"));
        System.out.println(title);
        System.out.println(content);
        Notes note = new Notes();
        note.setContent(content);
        note.setTitle(title);
        note.setUser((User) request.getSession().getAttribute("user"));
        NotesDao notesDao = new NotesDaoImpl();
        notesDao.addNote(note);
        response.sendRedirect("/index.jsp");
    }
}
