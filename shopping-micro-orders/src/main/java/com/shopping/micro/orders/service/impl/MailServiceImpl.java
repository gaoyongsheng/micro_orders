package com.shopping.micro.orders.service.impl;

import com.shopping.micro.orders.service.MailService;
import com.shopping.micro.orders.vo.MailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @Author Gao
 * @Date 2020/12/25 23:53
 * @Version 1.0
 */

@Slf4j
@Service
@Transactional
public class MailServiceImpl extends AbstractBaseImpl  implements MailService {

    @Autowired
    private JavaMailSenderImpl mailSender;//注入邮件工具类

    @Async // 基于@Async标注的方法，称之为异步方法；这些方法将在执行的时候，将会在独立的线程中被执行，调用者无需等待它的完成，即可继续其他的操作。
    @Override
    public MailVo sendMail(MailVo mailVo) {
        try {
            checkMail(mailVo); //1.检测邮件
            sendMimeMail(mailVo); //2.发送邮件
            return saveMail(mailVo); //3.保存邮件
        } catch (Exception e) {
            mailVo.setStatus("fail");
            mailVo.setError(e.getMessage());
            return mailVo;
        }
    }

    //检测邮件信息类
    private void checkMail(MailVo mailVo) {
        if (StringUtils.isEmpty(mailVo.getTo())) {
            throw new RuntimeException("邮件收信人不能为空");
        }
        if (StringUtils.isEmpty(mailVo.getSubject())) {
            throw new RuntimeException("邮件主题不能为空");
        }
        if (StringUtils.isEmpty(mailVo.getText())) {
            throw new RuntimeException("邮件内容不能为空");
        }
    }

    //构建复杂邮件信息类
    private void sendMimeMail(MailVo mailVo) {
        //简单邮件
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setFrom(getMailSendFrom());
//        simpleMailMessage.setTo(mailVo.getTo());
//        simpleMailMessage.setSubject("BugBugBug");
//        simpleMailMessage.setText("一杯茶，一根烟，一个Bug改一天");
//        mailSender.send(simpleMailMessage);

        //复杂邮件
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
//        messageHelper.setFrom("jiuyue@163.com");
//        messageHelper.setTo("September@qq.com");
//        messageHelper.setSubject("BugBugBug");
//        messageHelper.setText("一杯茶，一根烟，一个Bug改一天！");
//        messageHelper.addInline("bug.gif", new File("xx/xx/bug.gif"));
//        messageHelper.addAttachment("bug.docx", new File("xx/xx/bug.docx"));
//        mailSender.send(mimeMessage);


        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mailSender.createMimeMessage(), true);//true表示支持复杂类型
            mailVo.setFrom(getMailSendFrom());//邮件发信人从配置项读取
            messageHelper.setFrom(mailVo.getFrom());//邮件发信人
            messageHelper.setTo(mailVo.getTo().split(","));//邮件收信人
            messageHelper.setSubject(mailVo.getSubject());//邮件主题
            messageHelper.setText(mailVo.getText());//邮件内容

            if (!StringUtils.isEmpty(mailVo.getCc())) {//抄送
                messageHelper.setCc(mailVo.getCc().split(","));
            }
            if (!StringUtils.isEmpty(mailVo.getBcc())) {//密送
                messageHelper.setCc(mailVo.getBcc().split(","));
            }
            if (mailVo.getMultipartFiles() != null) {//添加邮件附件
                for (MultipartFile multipartFile : mailVo.getMultipartFiles()) {
                    messageHelper.addAttachment(multipartFile.getOriginalFilename(), multipartFile);
                }
            }
            if (StringUtils.isEmpty(mailVo.getSentDate())) {//发送时间
                mailVo.setSentDate(new Date());
                messageHelper.setSentDate(mailVo.getSentDate());
            }
            mailSender.send(messageHelper.getMimeMessage());//正式发送邮件
            mailVo.setStatus("ok");
        } catch (Exception e) {
            throw new RuntimeException(e);//发送失败
        }
    }

    //保存邮件
    private MailVo saveMail(MailVo mailVo) {

        //将邮件保存到数据库..

        return mailVo;
    }

    //获取邮件发信人
    public String getMailSendFrom() {
        return mailSender.getJavaMailProperties().getProperty("from");
    }



}
