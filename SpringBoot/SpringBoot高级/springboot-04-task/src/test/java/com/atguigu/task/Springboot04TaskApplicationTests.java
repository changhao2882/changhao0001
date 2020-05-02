package com.atguigu.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot04TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();

        //邮件设置
        message.setSubject("今晚开会");
        message.setText("送给你哦对比度宁波i的牛逼哦");

        message.setTo("changhao2882@163.com");
        message.setFrom("675575392@qq.com");

        mailSender.send(message);

    }

    @Test
    void test02() throws Exception{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        //邮件设置
        helper.setSubject("今晚开会");
        helper.setText("<b style='color:red'>送给你哦对比度宁波i的牛逼哦</b>",true);

        helper.setTo("changhao2882@163.com");
        helper.setFrom("675575392@qq.com");

        //上传文件
        helper.addAttachment("2882.jpg",new File("C:\\Users\\67557\\Pictures\\2882.jpg"));

        mailSender.send(mimeMessage);

    }

}
