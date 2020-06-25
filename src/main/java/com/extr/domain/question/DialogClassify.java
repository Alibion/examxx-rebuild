package com.extr.domain.question;

import java.io.Serializable;

public class DialogClassify implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1188515268101760730L;

    private int dialogClassifyID;
    private String dialogClassifyName;

    public int getDialogClassifyID() {
        return dialogClassifyID;
    }

    public void setDialogClassifyID(int dialogClassifyID) {
        this.dialogClassifyID = dialogClassifyID;
    }

    public String getDialogClassifyName() {
        return dialogClassifyName;
    }

    public void setDialogClassifyName(String dialogClassifyName) {
        this.dialogClassifyName = dialogClassifyName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DialogClassify [dialogClassifyID=").append(dialogClassifyID).append(", dialogClassifyName=")
                .append(dialogClassifyName).append("]");
        return builder.toString();
    }

}
