package com.extr.domain.question;

import java.io.Serializable;

public class DialogInfo implements Serializable {

    private static final long serialVersionUID = 3372458215239600883L;

    private int dialogID;
    private int dialogClassifyID;
    private String questionJapanese;
    private String answerJapanese1;
    private String answerJapanese2;
    private String answerJapanese3;
    private String questionChinese;
    private String answerChinese1;
    private String answerChinese2;
    private String answerChinese3;

    public int getDialogID() {
        return dialogID;
    }

    public void setDialogID(int dialogID) {
        this.dialogID = dialogID;
    }

    public int getDialogClassifyID() {
        return dialogClassifyID;
    }

    public void setDialogClassifyID(int dialogClassifyID) {
        this.dialogClassifyID = dialogClassifyID;
    }

    public String getQuestionJapanese() {
        return questionJapanese;
    }

    public void setQuestionJapanese(String questionJapanese) {
        this.questionJapanese = questionJapanese;
    }

    public String getAnswerJapanese1() {
        return answerJapanese1;
    }

    public void setAnswerJapanese1(String answerJapanese1) {
        this.answerJapanese1 = answerJapanese1;
    }

    public String getAnswerJapanese2() {
        return answerJapanese2;
    }

    public void setAnswerJapanese2(String answerJapanese2) {
        this.answerJapanese2 = answerJapanese2;
    }

    public String getAnswerJapanese3() {
        return answerJapanese3;
    }

    public void setAnswerJapanese3(String answerJapanese3) {
        this.answerJapanese3 = answerJapanese3;
    }

    public String getQuestionChinese() {
        return questionChinese;
    }

    public void setQuestionChinese(String questionChinese) {
        this.questionChinese = questionChinese;
    }

    public String getAnswerChinese1() {
        return answerChinese1;
    }

    public void setAnswerChinese1(String answerChinese1) {
        this.answerChinese1 = answerChinese1;
    }

    public String getAnswerChinese2() {
        return answerChinese2;
    }

    public void setAnswerChinese2(String answerChinese2) {
        this.answerChinese2 = answerChinese2;
    }

    public String getAnswerChinese3() {
        return answerChinese3;
    }

    public void setAnswerChinese3(String answerChinese3) {
        this.answerChinese3 = answerChinese3;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DialogInfo [dialogID=").append(dialogID).append(", dialogClassifyID=").append(dialogClassifyID)
                .append(", questionJapanese=").append(questionJapanese).append(", answerJapanese1=")
                .append(answerJapanese1).append(", answerJapanese2=").append(answerJapanese2)
                .append(", answerJapanese3=").append(answerJapanese3).append(", questionChinese=")
                .append(questionChinese).append(", answerChinese1=").append(answerChinese1).append(", answerChinese2=")
                .append(answerChinese2).append(", answerChinese3=").append(answerChinese3).append("]");
        return builder.toString();
    }

}
