package com.music.player.spi;

import java.lang.annotation.*;

/**
 * ClassName : SPI<br>
 * Description : SPI Extend the processing. All spi system reference the apache implementation of
 * <a href="https://github.com/apache/dubbo/blob/master/dubbo-common/src/main/java/org/apache/dubbo/common/extension">Apache Dubbo Common Extension
 * <br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SPI {

    /**
     * Value string.
     *
     * @return the string
     */
    String value() default "";
}
