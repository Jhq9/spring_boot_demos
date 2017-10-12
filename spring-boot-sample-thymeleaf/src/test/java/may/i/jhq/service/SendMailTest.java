package may.i.jhq.service;

import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jinhuaquan on 2017/6/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SendMailTest {

    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    public  void  sendSimpleMail(){

        SimpleMailMessage simpleMailMessage= new SimpleMailMessage();
        simpleMailMessage.setFrom("1044038055@qq.com");
        simpleMailMessage.setTo("1044038055@qq.com");
        simpleMailMessage.setSubject("主题：测试");
        simpleMailMessage.setText("邮件测试");

        javaMailSender.send(simpleMailMessage);

    }

    @Test
    public  void  testSendAtthchEmail() throws Exception{

        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage,true);

        mimeMessageHelper.setFrom("1044038055@qq.com");
        mimeMessageHelper.setTo("1044038055@qq.com");
        mimeMailMessage.setSubject("主题：符件及嵌入图片邮件测试");

        mimeMessageHelper.setText("有附件的邮件+嵌入图片" +
                "<html><body><img src=\"cid:girl\"></body></html>",true);

        mimeMessageHelper.addAttachment("girl.jpg",new File("/Users/jinhuaquan/Pictures/dreamGirl.jpg"));
        mimeMessageHelper.addInline("girl",new File("/Users/jinhuaquan/Pictures/dreamGirl.jpg"));
        javaMailSender.send(mimeMailMessage);

    }


    @Test
    public  void  sendTemplateEmail() throws MessagingException {
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage);

        mimeMessageHelper.setFrom("1044038055@qq.com");
        mimeMessageHelper.setTo("1044038055@qq.com");
        mimeMessageHelper.setSubject("主题：发送模板邮件");

        Map<String,Object> model = new HashMap<>();

        model.put("username","jhq");

        String text = VelocityEngineUtils.mergeTemplateIntoString(new  VelocityEngine(),"/template.vm","UTF-8",model);
    }

}
