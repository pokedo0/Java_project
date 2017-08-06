package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.List;

/**
 * Created by pokedo on 2017/5/15.
 */
public class FileUploadAction2 extends ActionSupport {
    private List<File> file;
    private List<String> fileFileName;
    private List<String> fileContentType;

    public void setFile(List<File> file) {
        this.file = file;
    }

    public void setFileFileName(List<String> fileFileName) {
        this.fileFileName = fileFileName;
    }

    public void setFileContentType(List<String> fileContentType) {
        this.fileContentType = fileContentType;
    }

    public List<File> getFile() {

        return file;
    }

    public List<String> getFileFileName() {
        return fileFileName;
    }

    public List<String> getFileContentType() {
        return fileContentType;
    }

    @Override
    public String execute() throws Exception {
        ServletContext context = ServletActionContext.getServletContext();
        String dir = context.getRealPath("/WEB-INF");

        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;

        for (int i = 0; i < 3; i++) {
            try {
                FileInputStream fis = new FileInputStream(file.get(i));
                bis = new BufferedInputStream(fis);
                FileOutputStream fos = new FileOutputStream(new File(dir, fileFileName.get(i)));
                bos = new BufferedOutputStream(fos);
                byte[] buf = new byte[4096];
                int len = -1;
                while ((len = bis.read(buf)) != -1)
                    bos.write(buf, 0, len);
            } finally {
                try {
                    if (null != bis)
                        bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (null != bos)
                        bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return SUCCESS;
    }
}
