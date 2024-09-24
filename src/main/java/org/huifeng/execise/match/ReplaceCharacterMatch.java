package org.huifeng.execise.match;

import java.util.function.BiFunction;

/**
 * 字符串匹配替换
 * HStage 2-advanced requirementInstead ofremoving the consecutively identical characters,
 * replace them with asingle characerthat comes before it alphabetically.
 */
public class ReplaceCharacterMatch extends AbstractCharacterMatch implements CharMatchLifeCycle{

    public ReplaceCharacterMatch(){
       super.postFunc = initialedConsumer();
    }

    private static final char ZERO = '\0';

    // 函数：获取字母表中前一个字符
    private char getPreviousChar(char ch) {
        if (ch == 'a') {
            return ZERO; // 不替换 'a'
        }
        return (char) (ch - 1);
    }

    /**
     * @return
     */
    @Override
    BiFunction<String,Integer,String> initialedConsumer() {
        return (in, i) -> {
            char prevChar = getPreviousChar(in.charAt(i));
            if (prevChar != ZERO) {
                return String.valueOf(prevChar);
            }
            return "";
        };
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
