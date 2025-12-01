
//<p>给你一个 <strong>非严格递增排列</strong> 的数组 <code>nums</code> ，请你<strong><a href="http://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank"> 原地</a></strong> 删除重复出现的元素，使每个元素 <strong>只出现一次</strong> ，返回删除后数组的新长度。元素的 <strong>相对顺序</strong> 应该保持 <strong>一致</strong> 。然后返回 <code>nums</code> 中唯一元素的个数。</p>
//
//<p>考虑 <code>nums</code> 的唯一元素的数量为 <code>k</code>。去重后，返回唯一元素的数量 <code>k</code>。</p>
//
//<p><code>nums</code> 的前 <code>k</code> 个元素应包含 <strong>排序后</strong> 的唯一数字。下标&nbsp;<code>k - 1</code> 之后的剩余元素可以忽略。</p>
//
//<p><strong>判题标准:</strong></p>
//
//<p>系统会用下面的代码来测试你的题解:</p>
//
//<pre>
//int[] nums = [...]; // 输入数组
//int[] expectedNums = [...]; // 长度正确的期望答案
//
//int k = removeDuplicates(nums); // 调用
//
//assert k == expectedNums.length;
//for (int i = 0; i &lt; k; i++) {
//    assert nums[i] == expectedNums[i];
//}</pre>
//
//<p>如果所有断言都通过，那么您的题解将被 <strong>通过</strong>。</p>
//
//<p>&nbsp;</p>
//
//<p><strong class="example">示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [1,1,2]
//<strong>输出：</strong>2, nums = [1,2,_]
//<strong>解释：</strong>函数应该返回新的长度 <strong><code>2</code></strong> ，并且原数组 <em>nums </em>的前两个元素被修改为 <strong><code>1</code></strong>, <strong><code>2 </code></strong><span><code>。</code></span>不需要考虑数组中超出新长度后面的元素。
//</pre>
//
//<p><strong class="example">示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [0,0,1,1,1,2,2,3,3,4]
//<strong>输出：</strong>5, nums = [0,1,2,3,4,_,_,_,_,_]
//<strong>解释：</strong>函数应该返回新的长度 <strong><code>5</code></strong> ， 并且原数组 <em>nums </em>的前五个元素被修改为 <strong><code>0</code></strong>, <strong><code>1</code></strong>, <strong><code>2</code></strong>, <strong><code>3</code></strong>, <strong><code>4</code></strong> 。不需要考虑数组中超出新长度后面的元素。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li> 
// <li><code>-10<font size="1">0</font>&nbsp;&lt;= nums[i] &lt;= 10<font size="1">0</font></code></li> 
// <li><code>nums</code> 已按 <strong>非递减</strong>&nbsp;顺序排列。</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>双指针</li></div></div><br><div><li>👍 3882</li><li>👎 0</li></div>
package com.shuzijun.leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray{
    public static void main(String[] args) {
         Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
         int[] nums={1,2,3,4,5};
         System.out.println(solution.removeDuplicates(nums));
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int fast=1,slow=1;
        while(fast<nums.length){
            if(nums[fast]!=nums[fast-1]){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return  slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}