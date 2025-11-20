package com.shuzijun.leetcode.editor.en;
//<p>有两种特殊字符：</p>
//
//<ul> 
// <li>第一种字符可以用一比特&nbsp;<code>0</code> 表示</li> 
// <li>第二种字符可以用两比特（<code>10</code>&nbsp;或&nbsp;<code>11</code>）表示</li> 
//</ul>
//
//<p>给你一个以 <code>0</code> 结尾的二进制数组&nbsp;<code>bits</code>&nbsp;，如果最后一个字符必须是一个一比特字符，则返回 <code>true</code> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例&nbsp;1:</strong></p>
//
//<pre>
//<strong>输入:</strong> bits = [1, 0, 0]
//<strong>输出:</strong> true
//<strong>解释:</strong> 唯一的解码方式是将其解析为一个两比特字符和一个一比特字符。
//所以最后一个字符是一比特字符。
//</pre>
//
//<p><strong>示例&nbsp;2:</strong></p>
//
//<pre>
//<strong>输入：</strong>bits = [1,1,1,0]
//<strong>输出：</strong>false
//<strong>解释：</strong>唯一的解码方式是将其解析为两比特字符和两比特字符。
//所以最后一个字符不是一比特字符。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= bits.length &lt;= 1000</code></li> 
// <li><code>bits[i]</code> 为 <code>0</code> 或 <code>1</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li></div></div><br><div><li>👍 327</li><li>👎 0</li></div>


import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneBitAnd2BitCharacters {
    public static void main(String[] args) {
        Solution solution = new OneBitAnd2BitCharacters().new Solution();
        int[] bits = {0, 1, 1, 0};
        boolean oneBitCharacter = solution.isOneBitCharacter(bits);
        System.out.println(oneBitCharacter);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 0,1,0->false
         * 1,0,0->true
         * 1,1,0->true
         * 1,1,1,0->false
         * 0,1,1,0->true
         *
         * @param bits
         * @return
         */
        public boolean isOneBitCharacter(int[] bits) {
            int index = 0;
            boolean flag = false;

            while (index <= bits.length - 1) {
                if (index == bits.length - 1 && bits[index] == 0) {
                    flag = true;
                }

                if (bits[index] == 0) {
                    index++;
                    continue;
                } else {
                    index += 2;
                }
            }

            return flag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}