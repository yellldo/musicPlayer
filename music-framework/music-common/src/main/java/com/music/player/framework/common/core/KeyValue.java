package com.music.player.framework.common.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName : KeyValue<br>
 * Description : KeyValue<br>
 *
 * @author : sj
 * @date : 9/1/25
 */
@Setter
@Getter
@ToString
public class KeyValue<K, V> implements Serializable {

    private K key;
    private V value;
}
