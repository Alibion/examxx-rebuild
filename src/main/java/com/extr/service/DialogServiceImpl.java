package com.extr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.extr.domain.question.DialogClassify;
import com.extr.domain.question.DialogInfo;
import com.extr.persistence.DialogInfoMapper;

@Service("dialogService")
public class DialogServiceImpl implements DialogService {

    @Autowired
    public DialogInfoMapper dialogInfoMapper;

    @Override
    @Transactional
    public int addDialog(DialogInfo dialog) {
        int dialogID = -1;
        try {
            dialogInfoMapper.insertDialog(dialog);
            dialogID = dialog.getDialogID();
        } catch (Exception e) {
            System.out.println("exception");
        }
        // -1不成功 正常的主键id 成功
        return dialogID;
    }

    @Override
    public DialogInfo getDialogInfoByDialogID(int dialogID) {
        return dialogInfoMapper.getDialogInfoByDialogID(dialogID);
    }

    @Override
    public List<DialogInfo> getAllDialogInfo(int dialogClassifyID) {
        return dialogInfoMapper.getAllDialogInfo(dialogClassifyID);
    }

    @Override
    public DialogClassify getDialogClassifyName(int dialogClassifyID) {
        return dialogInfoMapper.getDialogClassifyName(dialogClassifyID);
    }

    @Override
    public List<DialogClassify> getAllDialogClassify() {
        return dialogInfoMapper.getAllDialogClassify();
    }

}
