package org.huifeng.execise.match;

import java.util.function.BiFunction;

/**
 * @author jack.liang
 */
public abstract class AbstractCharacterMatch implements CharacterProcessor{

    String oldResult;

    protected int WORD_OFFSET = 3 ;

    protected BiFunction<String,Integer,String> postFunc;

    /**
     * 时间复杂度 时间复杂度 O(n) * postFunc = O(n postFunc)
     * 主要工作匹配重复字符串大于 {@link #WORD_OFFSET} 的substr
     * @param input
     * @return
     */
    @Override
    public String process(String input) {
        if (input == null){
            throw new NullPointerException("Input is not null!");
        }

        // 使用StringBuilder存储最终结果
        StringBuilder result = new StringBuilder();
        int n = input.length();

        for (int i = 0; i < n; ) {
            int j = i;
            // 找到从位置 i 开始的连续相同字符的最大区间
            while (j < n && input.charAt(j) == input.charAt(i)) {
                j++;
            }
            // 计算连续相同字符的数量
            int count = j - i;

            // 如果数量小于3，则将这些字符追加到结果中
            if (count < WORD_OFFSET) {
                result.append(input, i, j);
            }else {
                if (postFunc != null)  {
                    String prev = postFunc.apply(input, i);
                    result.append(prev);
                }
            }
            // 更新 i 指针，跳过已经处理的字符
            i = j;
        }

        oldResult = result.toString();

        //递归处理 时间复杂度(LOG N)
        if (!input.contentEquals(oldResult)) {
            this.process(result.toString());
        }

        return oldResult;
    }


    abstract BiFunction<String,Integer,String> initialedConsumer();
}
