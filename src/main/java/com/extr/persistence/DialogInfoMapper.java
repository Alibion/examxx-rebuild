package com.extr.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.extr.domain.question.DialogClassify;
import com.extr.domain.question.DialogInfo;

public interface DialogInfoMapper {

    /**
     * 添加会话并返回该记录的主键
     *
     * @param dialog
     * @return
     */
    public int insertDialog(DialogInfo dialog);

    /**
     * 根据指定id返回会话内容
     *
     * @param dialogID
     * @return
     */
    DialogInfo getDialogInfoByDialogID(@Param("dialogID") int dialogID);

    /**
     * 返回某分类下所有会话内容
     *
     * @return
     */
    List<DialogInfo> getAllDialogInfo(@Param("dialogClassifyID") int dialogClassifyID);

    /**
     * 根据指定id返回会话分类名
     *
     * @param dialogClassifyID
     * @return
     */
    DialogClassify getDialogClassifyName(@Param("dialogClassifyID") int dialogClassifyID);

    /**
     * 返回所有会话分类
     *
     * @return
     */
    List<DialogClassify> getAllDialogClassify();

}
