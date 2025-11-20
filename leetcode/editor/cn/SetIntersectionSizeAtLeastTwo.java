//给你一个二维整数数组 intervals ，其中 intervals[i] = [starti, endi] 表示从 starti 到 endi 的所有整数
//，包括 starti 和 endi 。 
//
// 包含集合 是一个名为 nums 的数组，并满足 intervals 中的每个区间都 至少 有 两个 整数在 nums 中。 
//
// 
// 例如，如果 intervals = [[1,3], [3,7], [8,9]] ，那么 [1,2,4,7,8,9] 和 [2,3,4,8,9] 都符合 包
//含集合 的定义。 
// 
//
// 返回包含集合可能的最小大小。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[3,7],[8,9]]
//输出：5
//解释：nums = [2, 3, 4, 8, 9].
//可以证明不存在元素数量为 4 的包含集合。
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,3],[1,4],[2,5],[3,5]]
//输出：3
//解释：nums = [2, 3, 4].
//可以证明不存在元素数量为 2 的包含集合。 
// 
//
// 示例 3： 
//
// 
//输入：intervals = [[1,2],[2,3],[2,4],[4,5]]
//输出：5
//解释：nums = [1, 2, 3, 4, 5].
//可以证明不存在元素数量为 4 的包含集合。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 3000 
// intervals[i].length == 2 
// 0 <= starti < endi <= 10⁸ 
// 
//
// Related Topics 贪心 数组 排序 👍 218 👎 0

package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SetIntersectionSizeAtLeastTwo{
    public static void main(String[] args) {
         Solution solution = new SetIntersectionSizeAtLeastTwo().new Solution();
         int[][] intervals ={{8,9},{4,21},{3,19},{5,9},{1,5}};
         System.out.println(solution.intersectionSizeTwo(intervals));
         
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 1.先对数据预处理，将完全包含的子集拿出来
         *      当前元素与下一位元素是超集关系，intervals[i][0]<=intervals[i+1][0] && intervals[i][1]>=intervals[i+1][1]，直接跳过
         *      当前元素与下一位元素是子集关系，intervals[i][0]>=intervals[i=1][0] && intervals[i+1][1]<=intervals[i][1]，用本元素代替下一位元素
        * 2.把第一个元素的最大两位元素放入nums
         * 3.遍历数组
         *      如果当前nums的最大值与当前遍历数组的最小值差值>=2，则直接跳过
         *      如果nums最大值与当前遍历数组的最小值差值=1
         *          nums的倒数第二大值与当前遍历数组的最小值差值>=1，直接跳过
         *          nums的倒数第二大值与当前遍历数组的最小值差值=0，则把数组的最大值放入nums
         *      如果nums最大值与当前遍历数组的最小值差值=0，则把数组的最大的1个值放入nums
         * 3.对nums排序
         * 4.返回nums.size()
         * @param intervals
         * @return
         */
    public int intersectionSizeTwo(int[][] intervals) {
        ArrayList<Integer> nums = new ArrayList<>();
       
        if(intervals.length==1){
            return 2;
        }
        //预处理，将大子集去掉
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]> numList = new ArrayList<>();
        for (int i = 0; i < intervals.length-1; i++) {
            if(intervals[i][0]<=intervals[i+1][0] && intervals[i][1]>=intervals[i+1][1]){
                continue;
            }else if(intervals[i][0]>=intervals[i+1][0] && intervals[i][1]<=intervals[i+1][1]){
                intervals[i+1][0]=intervals[i][0];
                intervals[i+1][1]=intervals[i][1];
            }
            else{
                numList.add(intervals[i]);
            }
        }

        //补充最后一个元素
        if(numList.size()==0){
            numList.add(intervals[intervals.length-1]);
        }else{
            if(numList.get(numList.size()-1)[0]<=intervals[intervals.length-1][0] && numList.get(numList.size()-1)[1]>=intervals[intervals.length-1][1]){

            }else if(numList.get(numList.size()-1)[0]>=intervals[intervals.length-1][0] && numList.get(numList.size()-1)[1]<=intervals[intervals.length-1][1]){

            }else{
                numList.add(intervals[intervals.length-1]);
            }
        }
        
        Collections.sort(numList,(a,b)->Integer.compare(a[0],b[0]));
        
        int i1 = numList.get(0)[1] - 1;
        nums.add(i1);
        nums.add(numList.get(0)[1]);
        
        for (int i = 1; i < numList.size(); i++) {
            int min_int=numList.get(i)[0];
            int max_int=numList.get(i)[1];
            if(nums.get(nums.size()-1)-min_int>=2){

            }else if(nums.get(nums.size()-2)-min_int==1){
                if(nums.get(nums.size()-2)-min_int>=1){

                }else{
                    nums.add(max_int);
                }
            }else if(nums.get(nums.size()-1)-min_int==0){
                nums.add(max_int);
            }else if(nums.get(nums.size()-1)-min_int<0){
                nums.add(max_int--);
                nums.add(max_int);
            }

            Collections.sort(nums);
        }
        
        // for (int i = 1; i < intervals.length; i++) {
        //     int min_int=intervals[i][0];
        //     int max_int=intervals[i][1];
        //     if(nums.get(nums.size()-1)-min_int>=2){
        //        
        //     }else if(nums.get(nums.size()-2)-min_int==1){
        //         if(nums.get(nums.size()-2)-min_int>=1){
        //            
        //         }else{
        //             nums.add(max_int);
        //         }
        //     }else if(nums.get(nums.size()-1)-min_int==0){
        //         nums.add(max_int);
        //     }else if(nums.get(nums.size()-1)-min_int<0){
        //         nums.add(max_int--);
        //         nums.add(max_int);
        //     }
        //
        //     Collections.sort(nums);
        // }
        return nums.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}