package action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by pokedo on 2017/5/18.
 */
public class FileDownloadAction extends ActionSupport {
    private String fileName;    //通过链接获取
    private String downloadDir;

    public void setDownloadDir(String downloadDir) {
        this.downloadDir = downloadDir;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDownloadDir() {
        return downloadDir;
    }

    public InputStream getInputStream() throws Exception {
        File file = new File(downloadDir + "\\" + fileName);
        System.out.println(file);
        return new FileInputStream(file);
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getDownloadFileName() {
        return fileName;
    }
}
