/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Trung Duc
 */
public class FileUploadUtil {

    private static String PATH_REPORT = "D:/StudentChecking/";

    public static String uploadSingleFile(File file, String fileName, String fileType, String path) {
        String pathFile = "";
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        String dt = dateFormat.format(date);
        File destFile = new File("C:/FilePackageUpload/" + dt + fileName);

        try {
            FileUtils.copyFile(file, destFile);
            pathFile = path + dt + fileName;
        } catch (IOException ex) {
            System.err.println("Could not copy file " + fileName);
            System.err.println(ex.getMessage());
        }

        return pathFile;
    }


    public static boolean donwlaodReport(HttpServletResponse response, String fileName) throws Exception {
        boolean result;
        try {

            OutputStream out = response.getOutputStream();
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            FileInputStream in = new FileInputStream(PATH_REPORT + fileName);

            byte[] buffer = new byte[4096];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.flush();
            out.close();

            result = true;

        } catch (Exception e) {
            result = false;
        }

        return result;
    }

}
