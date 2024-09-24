package org.huifeng.execise.match;

import java.util.function.BiFunction;

/**
 * 字符串匹配移除
 * For a given string that only contains alphabet characters a-z,
 * if 3 or more consecutivecharacters are identical, remove them from the string.
 * Repeat this process untilthere is no more than 3 identical characters sitting besides each other.
 */
public class RemovedCharacterMatch extends AbstractCharacterMatch implements CharMatchLifeCycle {

    public RemovedCharacterMatch() {

    }

    /**
     * @return
     */
    @Override
    BiFunction<String, Integer, String> initialedConsumer() {
        return null;//ignore
    }


    /**
     * @param in
     * @return
     */
    @Override
    public String prepareLaunch(String in) {
        return super.process(in);
    }

    /**
     *
     */
    @Override
    public void recycle() {
        //ignore
    }
}
