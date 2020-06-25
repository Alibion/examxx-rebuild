package com.extr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.extr.controller.domain.QuestionQueryResult;
import com.extr.domain.question.DialogClassify;
import com.extr.domain.question.DialogInfo;
import com.extr.security.UserInfo;
import com.extr.service.DialogService;
import com.extr.service.ExamService;
import com.extr.service.QuestionService;
import com.extr.util.QuestionAdapter;

@Controller
public class DialogController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private DialogService dialogService;

    @Autowired
    public ExamService examService;

    private static Logger log = Logger.getLogger(DialogController.class);

    /**
     * 响应默认路径（调试用）
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/student/dialog", method = RequestMethod.GET)
    public String practiceStartNew(Model model, HttpServletRequest request) {

        String strUrl = "http://" + request.getServerName() // 服务器地址
                + ":" + request.getServerPort() + "/";
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        List<Integer> fieldIdList = new ArrayList<Integer>();
        fieldIdList.add(userInfo.getFieldId());
        List<Integer> typeIdList = new ArrayList<Integer>();
        typeIdList.add(1);
        typeIdList.add(2);
        typeIdList.add(3);
        typeIdList.add(4);
        List<QuestionQueryResult> qqrList = questionService.getQuestionQueryResultListByFieldIdList(fieldIdList,
                typeIdList, 20);

        String fieldName = "";
        try {
            fieldName = qqrList.get(0).getPointName().split(">")[1];
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        int amount = qqrList.size();
        StringBuilder sb = new StringBuilder();
        for (QuestionQueryResult qqr : qqrList) {
            QuestionAdapter adapter = new QuestionAdapter(qqr, strUrl);
            sb.append(adapter.getStringFromXML());
        }
        // FileWriter fwriter = null;
        // try {
        // // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
        // fwriter = new FileWriter("C:/Users/liab/Desktop/sb.txt", true);
        // fwriter.write(sb.toString());
        // } catch (IOException ex) {
        // ex.printStackTrace();
        // } finally {
        // try {
        // fwriter.flush();
        // fwriter.close();
        // } catch (IOException ex) {
        // ex.printStackTrace();
        // }
        // }
        sb = new StringBuilder();
        sb.append("<li class=\"question qt-multiplechoice\">");
        sb.append("<div style=\"display: inline-block; width: 70px; height: 90px;\"></div>");
        sb.append("<div class=\"leftBubble\" style=\"display: inline-block;\">");
        sb.append("问题1");
        sb.append("</div>");
        sb.append("<div style=\"display: inline-block; width: 155px; height: 1px;\"></div>");
        sb.append("<div class=\"rightBubble\" style=\"display: inline-block;\">");
        sb.append("回答1");
        sb.append("</div>");
        sb.append("<div style=\"width: 10px; height: 50px;\"></div>");
        sb.append("</li>");
        model.addAttribute("dialogStr", sb.toString());
        model.addAttribute("amount", amount);
        model.addAttribute("fieldName", fieldName);
        return "student/show-dialog";
    }

    /**
     * 响应并转发
     *
     * @param model
     * @param request
     * @param dialogClassifyID
     * @return
     */
    @RequestMapping(value = "/student/dialog/{dialogClassifyID}", method = RequestMethod.GET)
    public String practiceImprove(Model model, HttpServletRequest request,
            @PathVariable("dialogClassifyID") int dialogClassifyID) {
        try {
            String strUrl = "http://" + request.getServerName() // 服务器地址
                    + ":" + request.getServerPort() + "/";
            DialogClassify dialogClassifyInfo = dialogService.getDialogClassifyName(dialogClassifyID);

            String fieldName = dialogClassifyInfo.getDialogClassifyName();

            List<DialogInfo> dialogList = dialogService.getAllDialogInfo(dialogClassifyID);
            int amount = dialogList.size();

            StringBuilder sb = new StringBuilder();
            for (DialogInfo dialog : dialogList) {
                sb.append("<li class=\"question qt-multiplechoice\">");
                sb.append("<div style=\"display: inline-block; width: 70px; height: 90px;\"></div>");
                sb.append("<div id=\"questionJ1\" class=\"leftBubble\" style=\"display: inline-block;\">");
                sb.append(dialog.getQuestionJapanese());
                sb.append("</div>");
                sb.append("<div id=\"questionC1\" class=\"leftBubble\" style=\"display: none;\">");
                sb.append(dialog.getQuestionChinese());
                sb.append("</div>");
                sb.append("<div style=\"display: inline-block; width: 155px; height: 1px;\"></div>");
                sb.append("<div id=\"answerJ1\" class=\"rightBubble\" style=\"display: inline-block;\">");
                sb.append(dialog.getAnswerJapanese1());
                sb.append("</div>");
                sb.append("<div id=\"answerC1\" class=\"rightBubble\" style=\"display: none;\">");
                sb.append(dialog.getAnswerChinese1());
                sb.append("</div>");
                sb.append("<div style=\"width: 10px; height: 50px;\"></div>");
                sb.append("</li>");
            }
            model.addAttribute("dialogStr", sb.toString());
            model.addAttribute("amount", amount);
            model.addAttribute("fieldName", fieldName);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "student/show-dialog";
    }
}
