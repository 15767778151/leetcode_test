// 给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target。letters 里至少有两个不同的字符。 
//
// 返回 letters 中大于 target 的最小的字符。如果不存在这样的字符，则返回 letters 的第一个字符。 
//
// 
//
// 示例 1： 
//
// 
// 输入: letters = ['c', 'f', 'j']，target = 'a'
// 输出: 'c'
// 解释：letters 中字典上比 'a' 大的最小字符是 'c'。 
//
// 示例 2: 
//
// 
// 输入: letters = ['c','f','j'], target = 'c'
// 输出: 'f'
// 解释：letters 中字典顺序上大于 'c' 的最小字符是 'f'。 
//
// 示例 3: 
//
// 
// 输入: letters = ['x','x','y','y'], target = 'z'
// 输出: 'x'
// 解释：letters 中没有一个字符在字典上大于 'z'，所以我们返回 letters[0]。 
//
// 
//
// 提示： 
//
// 
// 2 <= letters.length <= 10⁴ 
// letters[i] 是一个小写字母 
// letters 按非递减顺序排序 
// letters 最少包含两个不同的字母 
// target 是一个小写字母 
// 
//
// Related Topics 数组 二分查找 👍 334 👎 0

package com.shuzijun.leetcode.editor.en;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        Solution solution = new FindSmallestLetterGreaterThanTarget().new Solution();
        
        char[] letters={'x','x','y','y'};
        char target='z';
        System.out.println(solution.nextGreatestLetter(letters, target));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
          
            int low=0;
            int high=letters.length-1;
            char minCharacter=Character.MAX_VALUE;
            while(low<=high){
                int current=(low+high)/2;
                if(letters[current]>target){
                    high=current-1;

                    //当个target大于当前遍历的元素是，记录它与target的差值，并记录当前元素为最小的元素
                    if(letters[current]-target<minCharacter){
                        minCharacter=letters[current];
                    }
                }else{
                    low=current+1;
                }
            }
            if(minCharacter==Character.MAX_VALUE){
                minCharacter=letters[0];
            }
            return minCharacter;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}