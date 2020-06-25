package com.extr.service;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.extr.domain.question.DialogClassify;
import com.extr.domain.question.DialogInfo;

/**
 *
 * @author scar
 *
 */
public class DialogServiceTest {

    @Test
    public void testAddDialog() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "src/main/webapp/WEB-INF/spring/root-context.xml");
        DialogService dialogService = (DialogService) ctx.getBean("dialogService");

        DialogInfo dialogInfo = new DialogInfo();
        dialogInfo.setQuestionJapanese("日本語問題");
        dialogInfo.setAnswerJapanese1("日本語回答");
        dialogInfo.setQuestionChinese("中文问题");
        dialogInfo.setAnswerChinese1("中文回答");
        System.out.println("result : " + dialogService.addDialog(dialogInfo));
    }

    @Test
    public void testSelectDialog() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "src/main/webapp/WEB-INF/spring/root-context.xml");
        DialogService dialogService = (DialogService) ctx.getBean("dialogService");

        DialogInfo dialogInfo = dialogService.getDialogInfoByDialogID(2);
        System.out.println(dialogInfo);
    }

    @Test
    public void testSelectAllDialog() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "src/main/webapp/WEB-INF/spring/root-context.xml");
        DialogService dialogService = (DialogService) ctx.getBean("dialogService");

        List<DialogInfo> dialogList = dialogService.getAllDialogInfo(1);
        for (DialogInfo dialogInfo : dialogList) {
            System.out.println(dialogInfo);
        }
    }

    @Test
    public void testSelectDialogClassify() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "src/main/webapp/WEB-INF/spring/root-context.xml");
        DialogService dialogService = (DialogService) ctx.getBean("dialogService");

        DialogClassify dialogInfo = dialogService.getDialogClassifyName(1);
        System.out.println(dialogInfo);
    }

    @Test
    public void testGetAllDialogClassify() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "src/main/webapp/WEB-INF/spring/root-context.xml");
        DialogService dialogService = (DialogService) ctx.getBean("dialogService");

        List<DialogClassify> dialogList = dialogService.getAllDialogClassify();
        for (DialogClassify dialogInfo : dialogList) {
            System.out.println(dialogInfo);
        }
    }
}
