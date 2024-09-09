package com.baidu.fsg.uid;

import com.baidu.fsg.uid.exception.UidGenerateException;

/**
 * ClassName : UidGenerator<br>
 * Description : UidGenerator<br>
 *
 * @author : sj
 * @date : 2024/9/7
 */
public interface UidGenerator {


    long getUID() throws UidGenerateException;


    String parseUID(long uid);
}
