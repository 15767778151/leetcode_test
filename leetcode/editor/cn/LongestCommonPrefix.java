
//<p>编写一个函数来查找字符串数组中的最长公共前缀。</p>
//
//<p>如果不存在公共前缀，返回空字符串&nbsp;<code>""</code>。</p>
//
//<p>&nbsp;</p>
//
//<p><strong class="example">示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>strs = ["flower","flow","flight"]
//<strong>输出：</strong>"fl"
//</pre>
//
//<p><strong class="example">示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>strs = ["dog","racecar","car"]
//<strong>输出：</strong>""
//<strong>解释：</strong>输入不存在公共前缀。</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= strs.length &lt;= 200</code></li> 
// <li><code>0 &lt;= strs[i].length &lt;= 200</code></li> 
// <li><code>strs[i]</code>&nbsp;如果非空，则仅由小写英文字母组成</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>字典树</li><li>数组</li><li>字符串</li></div></div><br><div><li>👍 3427</li><li>👎 0</li></div>
package com.shuzijun.leetcode.editor.en;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String[] strs = {"dog","racecar","car"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 1) {
                return strs[0];
            }

            String resString = strs[0];
            for (int i = 1; i < strs.length; i++) {
                for (int j = 0; j < resString.length() && j < strs[i].length(); j++) {
                    if (resString.charAt(j) != strs[i].charAt(j)) {
                        resString = resString.substring(0, j);
                        break;
                    }
                }

                if(resString.length()>strs[i].length()){
                    resString=resString.substring(0,strs[i].length());
                }
            }
            return resString;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}