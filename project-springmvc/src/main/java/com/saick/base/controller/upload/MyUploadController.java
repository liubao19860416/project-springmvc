package com.saick.base.controller.upload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传测试Controller类
 * 
 * @author Liubao
 * @Version 1.0
 * 
 */
@Controller
@RequestMapping("/myUpload")
public class MyUploadController {

    @SuppressWarnings("unused")
    @RequestMapping("/0.action")
    public String mySingleFileUpload(HttpServletRequest request,HttpServletResponse response,
            MultipartFile multiFile) throws Exception {
        // ModelAndView modelAndView = new ModelAndView("upload");
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        /**
         * 获取文件的格式，可以按照这种格式，使用response进行输出流设置
         */
        // MultipartFile mutFile =new CommonsMultipartFile(fileItem);
        //String contentType = multiFile.getContentType();
        String originalFileName = multiFile.getOriginalFilename();
        
        System.out.println("文件名为:"+originalFileName);
        
//        PrintWriter printWriter = response.getWriter();
//        printWriter.write("ok...");
//        printWriter.flush();
        
        return null;
    }

    /**
     * 多文件上传如何控制文件顺序
     */
    @RequestMapping("/1.action")
    public String myMutiliFileUpload(HttpServletRequest request,HttpServletResponse response
            ,@RequestParam("multiFile") /*CommonsMultipartFile[]*/ MultipartFile[] multiFiles) throws Exception {
        for (MultipartFile multiFile : multiFiles) {
            if (multiFile.isEmpty()) {
                continue;
            }
            String contentType = multiFile.getContentType();
            /**
             * 以指定格式的流信息给浏览器输出
             */
            response.setContentType(contentType);
            String originalFileName = multiFile.getOriginalFilename();
            System.out.println("文件名为:"+originalFileName);
            //。。。。。。
        }
        return "upload";
    }

}
