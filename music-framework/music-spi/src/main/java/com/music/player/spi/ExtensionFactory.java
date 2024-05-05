package com.music.player.spi;

/**
 * ClassName : ExtensionFactory<br>
 * Description : The interface Extension factory.<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@SPI("spi")
public interface ExtensionFactory {

    /**
     * Gets Extension.
     *
     * @param <T>   the type parameter
     * @param key   the key
     * @param clazz the clazz
     * @return the extension
     */
    <T> T getExtension(String key, Class<T> clazz);
}
