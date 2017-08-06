package action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by pokedo on 2017/5/17.
 */
public class FileDownloadAction extends ActionSupport {
    private String downloadDir;

    public InputStream getInputStream() throws Exception {
        File file = new File("E:\\videotest.mp4");
        return new FileInputStream(file);
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getDownloadFileName() {
        String downFileName = "videotest.mp4";
        return downFileName;
    }

    public void setDownloadDir(String downloadDir) {
        this.downloadDir = downloadDir;
    }

    public String getDownloadDir() {
        return downloadDir;
    }
}
