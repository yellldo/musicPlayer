package com.music.player.spi;

import java.util.Optional;

/**
 * ClassName : SpiExtensionFactory<br>
 * Description : SpiExtensionFactory<br>
 *
 * @author : sj
 * @date : 2024/5/5
 */
@Join
public class SpiExtensionFactory implements ExtensionFactory {
    @Override
    public <T> T getExtension(final String key, final Class<T> clazz) {
        return Optional.ofNullable(clazz)
                .filter(Class::isInterface)
                .filter(cls -> cls.isAnnotationPresent(SPI.class))
                .map(ExtensionLoader::getExtensionLoader)
                .map(ExtensionLoader::getDefaultJoin)
                .orElse(null);
    }
}
