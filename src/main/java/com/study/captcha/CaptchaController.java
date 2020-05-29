package com.study.captcha;

import com.study.captcha.utils.CaptchaUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Description:
 * @Author: rands
 * @Date: Created in 13:11 2020/5/29
 * @Modified By:
 */
@Controller
public class CaptchaController {
    @RequestMapping(value = "/pictureValidate", method = RequestMethod.GET)
    public void identifyPicture(HttpServletResponse response) {
        //1.在内存中创建一张图片
        BufferedImage bi = new BufferedImage(CaptchaUtils.WIDTH, CaptchaUtils.HEIGHT, BufferedImage.TYPE_INT_RGB);
        //2.得到图片
        Graphics g = bi.getGraphics();
        //3.设置图片的背影色
        CaptchaUtils.setBackGround(g);
        //4.设置图片的边框
        CaptchaUtils.setBorder(g);
        //5.在图片上画干扰线
        CaptchaUtils.drawRandomLines(g);
        //6.写在图片上随机数
        //根据客户端传递的 createTypeFlag标识生成验证码图片 createTypeFlag = ch /n1 /n /1
        String random = CaptchaUtils.drawRandomCharacter((Graphics2D) g,"ch");//生成中文验证码图片
        //String random = CaptchaUtils.drawRandomCharacter((Graphics2D) g,"nl");//生成数字和字母组合的验证码图片
        //String random = CaptchaUtils.drawRandomCharacter((Graphics2D) g,"n");//生成纯数字的验证码图片
        //String random = CaptchaUtils.drawRandomCharacter((Graphics2D) g,"l");//生成纯字母的验证码图片
        //String random = CaptchaUtils.drawRandomCharacter((Graphics2D) g, "nl");
        System.out.println(random);
        //7.将随机数存在session中
        //8.设置响应头通知浏览器以图片的形式打开
        response.setContentType("image/jpeg");//等同于response.setHeader("Content-Type", "image/jpeg");
        //9.设置响应头控制浏览器不要缓存
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        //10.将图片写给浏览器
        try {
            ImageIO.write(bi, "jpg", response.getOutputStream());
        } catch (Exception e) {

        }
    }

}
