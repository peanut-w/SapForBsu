package com.haiqiu.cfadata.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * Created by peanut on 2019/4/26 下午1:08
 */
@Controller
@RequestMapping("/gfx")
public class PictureController {
    @Value("${userHome}")
    private String userHome;


    /**
     * 从本地获取图片部分
     */


    /**
     * 球员
     * @param pictureId
     * @param response
     * @param request
     */
    @GetMapping("/person/l/{pictureId}.jpg")
    public void getPersonPic(@PathVariable String pictureId, HttpServletResponse response, HttpServletRequest request) {
        String path =  userHome+"/gfx/person/l/" + pictureId + ".jpg";
        picUtils(response, path);
    }

    /**
     * 赛事
     */

    @GetMapping("/competition/png/normal/500x500/{pictureId}.png")
    public void getCompetitionPic(@PathVariable String pictureId, HttpServletResponse response, HttpServletRequest request) {
        String path =  userHome+"/gfx/competition/png/normal/500x500/" + pictureId + ".png";
        picUtils(response, path);
    }

    /**
     * 球队
     */

    @GetMapping("/emblem/common/500x500/{pictureId}.png")
    public void getTeamPic(@PathVariable String pictureId, HttpServletResponse response, HttpServletRequest request) {
        String path = userHome+"/gfx/emblem/common/500x500/" + pictureId + ".png";
        picUtils(response, path);
    }

    /**
     * 国旗
     */

    @GetMapping("/flags/common/100x100/{pictureId}.png")
    public void getCountryPic(@PathVariable String pictureId, HttpServletResponse response, HttpServletRequest request) {
        String path = userHome+"/gfx/flags/common/100x100/" + pictureId + ".png";
        picUtils(response, path);
    }

    public static void picUtils(HttpServletResponse response, String path) {
        response.setContentType("text/html; charset=UTF-8");
        response.setContentType("image/jpeg");
        InputStream in = null;
        OutputStream os = null;
        try {
            //读取本地图片输入流
            in = new FileInputStream(path);
            os = response.getOutputStream();
            IOUtils.copy(in, os);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
