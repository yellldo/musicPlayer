package com.music.player.spi;

import java.lang.annotation.*;

/**
 * ClassName : Join<br>
 * Description : Join Adding this annotation to a class indicates joining the extension mechanism.<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Join {
}
