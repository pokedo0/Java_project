package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.*;

/**
 * Created by pokedo on 2017/5/14.
 */
public class FileUploadAction extends ActionSupport {
    private File Afile;
    private String AfileFileName;
    private String AfileContentType;

    public void setAfile(File afile) {
        this.Afile = afile;
    }

    public void setAfileFileName(String afileFileName) {
        this.AfileFileName = afileFileName;
    }

    public void setAfileContentType(String afileContentType) {
        this.AfileContentType = afileContentType;
    }

    public File getAfile() {
        return Afile;
    }

    public String getAfileFileName() {
        return AfileFileName;
    }

    public String getAfileContentType() {
        return AfileContentType;
    }

    @Override
    public String execute() throws Exception {
        ServletContext context = ServletActionContext.getServletContext();
        String dir = context.getRealPath("/WEB-INF");
        System.out.println(dir);
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {
            FileInputStream fis = new FileInputStream(Afile);
            bis = new BufferedInputStream(fis);
            FileOutputStream fos = new FileOutputStream(new File(dir, AfileFileName));
            bos = new BufferedOutputStream(fos);

            byte[] buf = new byte[4096];
            int len = -1;
            while ((len = bis.read(buf)) != -1) {
                bos.write(buf, 0, len);
            }
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
        return SUCCESS;
    }
}
