package com.springboot.book.component;

import com.springboot.book.entity.FileResult;
import com.springboot.book.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Controller
@ResponseBody
public class UploadImg {



    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    @Autowired
    LoSrcService losrcService;

    @Autowired
    BookSrcService booksrcService;

    @Autowired
    BookHeaderService bookheaderService;

    @RequestMapping("/upload")
    public FileResult upload(@RequestParam("uploadType") String uploadType,@RequestParam("id") int id, @RequestParam("picture") MultipartFile picture, HttpServletRequest request) {

        System.out.println(uploadType);

        //获取文件在服务器的储存位置
        String pathPre = "D://img";
        String path="";
        String urlPre="http://localhost:8181/image/";

        switch (uploadType){
            case "avatar":
                path=pathPre+"//avatar";
                break;
            case "adminavatar":
                path=pathPre+"//adminavatar";
                break;
            case "logoimg":
                path=pathPre+"//logoimg";
                break;
            case "imgsrc":
                path=pathPre+"//imgsrc";
                break;
//            case "headersrc":
//                path=pathPre+"//headersrc";
//                break;
        }

        File filePath = new File(path);
        System.out.println("文件的保存路径：" + path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称(包含格式)
        String originalFileName = picture.getOriginalFilename();
        System.out.println("原始文件名称：" + originalFileName);

        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        System.out.println("文件类型：" + type);
        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

        String uuid= UUID.randomUUID().toString().replace("-", "");
        String fileName =uuid+ "." + type;
        System.out.println("新文件名称：" + fileName);

        //在指定路径下创建一个文件
        File targetFile = new File(path, fileName);
        String imageUrl=path+"/"+fileName;
        System.out.println("图片地址："+path+"/"+fileName);
        //将文件保存到服务器指定位置
        try {
            picture.transferTo(targetFile);
            System.out.println("上传成功");
            switch (uploadType){
                case "avatar":
                    userService.setUserAvatar(id,urlPre+"avatar/"+fileName);
                    break;
                case "adminavatar":
                    adminService.setAdminAvatar(id,urlPre+"adminavatar/"+fileName);
                    break;
                case "logoimg":
                    losrcService.setLogoImg(id,urlPre+"logoimg/"+fileName);
                    break;
                case "imgsrc":
                    booksrcService.setImgSrc(id,urlPre+"imgsrc/"+fileName);
                    bookheaderService.setHeaderSrc(id,urlPre+"imgsrc/"+fileName);
                    break;


            }
            //将文件在服务器的存储路径返回
            return new FileResult(true,fileName,path+"/"+fileName);
        } catch (IOException e) {
            System.out.println("上传失败");
            e.printStackTrace();
            return new FileResult(false, "上传失败","");
        }
    }

    @RequestMapping("/delFile")
    public String delFile(String path) {
        System.out.println("进入图片删除！！");
        String resultInfo = null;
        File file = new File(path);
        System.out.println("图片删除本地链接："+file);
        System.out.println(file.exists());
        if (file.exists()) {//文件是否存在
            if (file.delete()) {//存在就删了，返回1
                System.out.println("图片删除成功");
                resultInfo =  "1";
            } else {
                System.out.println("图片删除失败");
                resultInfo =  "0";
            }
        } else {
            resultInfo = "文件不存在！";
        }
        return resultInfo;
    }



//    @RequestMapping("/viewPhoto/{photopath}")
//    public void getFeedBackPicture(HttpServletResponse response, @PathVariable("photopath")String photopath) throws Exception{
//        String realPath="D://img"+photopath;
//        FileInputStream inputStream = new FileInputStream(realPath);
//        int i = inputStream.available();
//        //byte数组用于存放图片字节数据
//        byte[] buff = new byte[i];
//        inputStream.read(buff);
//        //记得关闭输入流
//        inputStream.close();
//        //设置发送到客户端的响应内容类型
//        response.setContentType("image/*");
//        OutputStream out = response.getOutputStream();
//        out.write(buff);
//        //关闭响应输出流
//        out.close();
//    }



}
