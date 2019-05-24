package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DownLoadController {
    @RequestMapping("/static/article/download.do/")
    @ResponseBody
    public Map downloadFile(@RequestParam(name = "path1") String path1, HttpServletRequest request, HttpServletResponse response) throws Exception{
        //替换\需要\\ 两个\则是\\\\
        String fileName = path1.replaceAll("/","\\\\");
        //System.out.println(fileName);
        String[] downFileName = fileName.split("\\\\");
        String downFile = downFileName[downFileName.length-1];
        //System.out.println(fileName);
        //String fileName = "src\\main\\resources\\static\\file\\Java开发工程师-河南工业大学-软件工程-王进.pdf";
        if (fileName != null) {
            //设置文件路径
            //String realPath = "E://music_eg/";
            File file = new File(fileName);
            // 如果文件名存在，则进行下载
            if (file.exists()) {

                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(downFile, "UTF-8"));

                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    System.out.println();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                }
                catch (Exception e) {
                    System.out.println("Download the song failed!");
                }
                finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        //hashMap.put("msg","success");
        return null;
    }
    @RequestMapping("/static/article/downlog.do")
    @ResponseBody
    public Map downlog(HttpServletRequest request, HttpServletResponse response) throws Exception{

        //String[] downFileName = fileName.split("\\\\");
        String downFile = "log.log";
        //System.out.println(fileName);
        String fileName = "F:\\workspace\\demo1\\demo.log";
        if (fileName != null) {
            File file = new File(fileName);
            if (file.exists()) {
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(downFile, "UTF-8"));
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    //System.out.println("Download the song successfully!");
                }
                catch (Exception e) {
                    //System.out.println("Download the song failed!");
                }
                finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        //hashMap.put("msg","success");
        return null;
    }
    @RequestMapping("/static/article/downloadEmailFile.do")
    @ResponseBody
    public Map downloadEmailFile(@RequestParam(name = "path1") String path1,HttpServletRequest request, HttpServletResponse response) throws Exception{
        String fileName = path1.replaceAll("/","\\\\");
        String[] str = fileName.split("\\\\");
        String downFile = str[str.length-1];
        System.out.println(fileName);
        if (fileName != null) {
            File file = new File(fileName);
            // 如果文件名存在，则进行下载
            if (file.exists()) {
                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(downFile, "UTF-8"));

                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    System.out.println("test");
                    OutputStream os = response.getOutputStream();
                    System.out.println();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                }
                catch (Exception e) {
                }
                finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}
/*
String fileName = "setting.db";
        //设置文件路径
        //String filePath = request.getParameter("path1");
        //String filePath = "src\\main\\resources\\static\\file\\Java开发工程师-河南工业大学-软件工程-王进.pdf";
        String filePath = "src\\main\\resources\\static\\file\\setting.db";
        System.out.println(filePath);
        File file = new File(filePath);
        if (file.exists()) {
            //System.out.println("test");
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    //System.out.println("test");
                    i = bis.read(buffer);
                }
                //System.out.println("test");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        hashMap.put("msg","success");
        return hashMap;
* */