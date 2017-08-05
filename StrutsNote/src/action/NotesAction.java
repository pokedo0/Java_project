package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.NotesDaoImpl;
import model.Notes;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class NotesAction extends ActionSupport {
    private Notes note;
    private List<Notes> notesList = new ArrayList<>();
    private int noteId;
    //上传文件相关属性
    private String uploadDir;   //上传文件相对路径，从struts中获得
    private File upfile;
    private String upfileFileName;
    private String upfileContentType;

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    public void setUpfile(File upfile) {
        this.upfile = upfile;
    }

    public void setUpfileFileName(String upfileFileName) {
        this.upfileFileName = upfileFileName;
    }

    public void setUpfileContentType(String upfileContentType) {
        this.upfileContentType = upfileContentType;
    }

    public String getUploadDir() {
        return uploadDir;
    }

    public File getUpfile() {
        return upfile;
    }

    public String getUpfileFileName() {
        return upfileFileName;
    }

    public String getUpfileContentType() {
        return upfileContentType;
    }

    public List<Notes> getNotesList() {
        return notesList;
    }

    public void setNotesList(List<Notes> notesList) {
        this.notesList = notesList;
    }

    public Notes getNote() {
        return note;
    }

    public void setNote(Notes note) {
        this.note = note;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String list() {
        NotesDaoImpl notesDao = new NotesDaoImpl();
        notesList = notesDao.getAllNotes();
        ActionContext.getContext().put("notesList", notesList);
        //System.out.println("list :" + notesList);
        return SUCCESS;
    }

    public String add() {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        User user = (User) session.get("user");
//        if (null == user)   //如果用户未登录，返回login
//            return "loginpage";
        if (null == note || note.getTitle().equals("")) //验证留言是否为空
            return INPUT;
        upload();
        note.setUser(user);
        NotesDaoImpl notesDao = new NotesDaoImpl();
        notesDao.addNote(note);
        return SUCCESS;
    }

    private void upload() {
        if (upfile == null) {   //如果文件为空，attachment字段设置为""
            note.setAttachment("");
            return;
        }
        System.out.println(uploadDir);
        String newFileName;
        long now = new Date().getTime();
        int index = upfileFileName.lastIndexOf(".");

        if (index == -1)
            newFileName = Long.toString(now);
        else
            newFileName = now + this.upfileFileName.substring(index);

        byte[] buf = new byte[4096];
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            FileInputStream fis = new FileInputStream(upfile);
            bis = new BufferedInputStream(fis);
            FileOutputStream fos = new FileOutputStream(new File(uploadDir, newFileName));
            bos = new BufferedOutputStream(fos);

            int len = -1;
            while ((len = bis.read(buf)) != -1)
                bos.write(buf, 0, len);
            String content = note.getContent();
//            content += "</br>";
//            content += "<a href='";
//            content += "download.action?fileName=" + newFileName;
//            content += "'>附件</a>";

            note.setAttachment(newFileName);//存放attachment字段
            note.setContent(content);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bis)
                    bis.close();
                if (null != bos)
                    bos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String detail() {    //根据 noteid 查找对于的note
        NotesDaoImpl notesDao = new NotesDaoImpl();
        note = notesDao.getNoteById(noteId);
        System.out.println(noteId);
        return SUCCESS;
    }
}
