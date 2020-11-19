package cn.com.ylw.generator.controller;

import cn.com.ylw.generator.service.SysGeneratorService;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import io.swagger.annotations.*;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


/**
 * MyBatisPlus代码生成器
 *
 * @author YangLinWei
 */
@RestController
@Api(tags = "MyBatisPlus代码生成器")
@RequestMapping("/generator")
public class SysGeneratorController {
    @Autowired
    private SysGeneratorService sysGeneratorService;


    @ApiOperation("生成zip")
    @GetMapping("/generateZip")
    public void generateZip(String[] tables, HttpServletResponse response) throws IOException {
        byte[] data = sysGeneratorService.generateZip(tables);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"generator.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }

    @ApiOperation("生成到目录")
    @GetMapping("/generateDiretory")
    public String generateDiretory(String[] tables, String destPath) throws IOException {
        byte[] data = sysGeneratorService.generateZip(tables);
        String zipFilePath = destPath + "/generator.zip";
        FileUtil.writeBytes(data, zipFilePath);
        ZipUtil.unzip(zipFilePath);
        FileUtil.del(zipFilePath);
        FileUtil.move(new File(destPath + "/generator" + "/main" + "/java"), new File(destPath), true);
        FileUtil.move(new File(destPath + "/generator" + "/main" + "/resources"), new File(destPath), true);
        FileUtil.del(destPath + "/generator");
        return "success";
    }

    @ApiOperation("生成到target")
    @GetMapping("/generateTarget")
    public String generateTarget(String[] tables) throws IOException {
        String filePath = ResourceUtils.getURL("classpath:").getPath();
        filePath = filePath.replace("/classes", "/逆向生成代码");
        byte[] data = sysGeneratorService.generateZip(tables);
        String zipFilePath = filePath + "/generator.zip";
        FileUtil.writeBytes(data, zipFilePath);
        ZipUtil.unzip(zipFilePath);
        FileUtil.del(zipFilePath);
        FileUtil.move(new File(filePath + "/generator" + "/main" + "/java"), new File(filePath), true);
        FileUtil.move(new File(filePath + "/generator" + "/main" + "/resources"), new File(filePath), true);
        FileUtil.del(filePath + "/generator");
        return "success";
    }
}
