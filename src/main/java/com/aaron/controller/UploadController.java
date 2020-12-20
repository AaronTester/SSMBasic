package com.aaron.controller;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/6
 */
@Controller
public class UploadController {

    private Logger log = LoggerFactory.getLogger(UploadController.class);

    @RequestMapping(value="/file/upload", method=RequestMethod.POST)
    public String doUploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request, Model model) throws IOException{
        if(!file.isEmpty()){
            //originalFilename:文件原始名称
            log.debug("Process file: {}", file.getOriginalFilename());
            String path = request.getRealPath("/upload");
            //文件上传，将文件流拷贝到目标文件对象中
            String fileName = System.currentTimeMillis()+ file.getOriginalFilename();
            FileUtils.copyInputStreamToFile(file.getInputStream(),
                    new File(path, fileName));
            //上传的第二种方式，使用file提供的方法
            //file.transferTo(new File(path, System.currentTimeMillis()+ file.getOriginalFilename()));
            //返回成功页面
            model.addAttribute("msg", "文件"+fileName+"上传成功");
            model.addAttribute("filename", fileName);
            return "success";
        }
        return "error";
    }

    /*
     * 下载方式二：Spring框架技术
     */
    @RequestMapping(value = "/file/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> download(HttpServletRequest request, String filename) throws IOException {
        String realPath = request.getRealPath("/upload");//获取下载文件的路径
        File file = new File(realPath, filename);//把下载文件构成一个文件处理   filename:前台传过来的文件名称
        HttpHeaders headers = new HttpHeaders();//设置头信息
        String downloadFileName = new String(filename.getBytes("UTF-8"), "iso-8859-1");//设置响应的文件名
        headers.setContentDispositionFormData("attachment", downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // MediaType:互联网媒介类型 contentType：具体请求中的媒体类型信息
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

}
