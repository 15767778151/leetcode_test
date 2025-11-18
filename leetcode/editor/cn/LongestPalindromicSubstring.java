
//<p>给你一个字符串 <code>s</code>，找到 <code>s</code> 中最长的 <span data-keyword="palindromic-string">回文</span> <span data-keyword="substring-nonempty">子串</span>。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "babad"
//<strong>输出：</strong>"bab"
//<strong>解释：</strong>"aba" 同样是符合题意的答案。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "cbbd"
//<strong>输出：</strong>"bb"
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= s.length &lt;= 1000</code></li> 
// <li><code>s</code> 仅由数字和英文字母组成</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>双指针</li><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 7884</li><li>👎 0</li></div>
package src.main.java.leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        String s="abba";
        System.out.println(solution.longestPalindrome(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int pre=0;
            int after=s.length()-1;
            String maxLongestString="";


            if(s.length()==1){
                return s;
            }

            while(pre<after){
                int i=pre;
                int j=after;

                String currentLongestString="";
                while(i<j){
                    if(s.charAt(i)!=s.charAt(j)){

                    }else{
                        i++;

                    }
                    j--;

                    if(s.charAt(i)==s.charAt(j)){
                        currentLongestString=s.substring(i,j+1);
                        i++;
                        j--;
                    }else{
                        currentLongestString="";
                        j--;
                    }


                }
                if(currentLongestString.length()>maxLongestString.length()){
                    maxLongestString=currentLongestString;
                }

                pre++;
            }

            return maxLongestString;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}