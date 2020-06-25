package com.extr.service;

import java.util.List;

import com.extr.domain.question.DialogClassify;
import com.extr.domain.question.DialogInfo;

/**
 * @author liab
 * @date 2020年6月11日
 */
public interface DialogService {

    int addDialog(DialogInfo dialog);

    public DialogInfo getDialogInfoByDialogID(int dialogID);

    public List<DialogInfo> getAllDialogInfo(int dialogClassifyID);

    public DialogClassify getDialogClassifyName(int dialogClassifyID);

    public List<DialogClassify> getAllDialogClassify();
}
