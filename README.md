此仓库有四个部分：

- 《剑指offer》java代码实现，一本关于面试算法题经典的书。
- 《玩转算法面试》，慕课课程，对leetcode的题目分门别类进行讲解，讲的很好，力荐。
- 排序算法，快排，归并排序，堆排。
- 数据结构，目前有循环队列、AVL树。

[TOC]



# 剑指offer

[剑指offer在线刷题，不买书也可以直接在这个网站上刷题，讨论区可以看看其他人的思路](https://www.nowcoder.com/ta/coding-interviews)



## 链表

技巧：

***哑节点**。涉及头结点的操作，不妨创造一个哑节点，这样使得对头结点的操作，与其他节点无异，就不用考虑头接点是否为空的边界条件了。比如，链表重排序使得所有小于x的节点都在前面。*

***快慢指针**，比如，返回一个链表的中间节点，倒数第k个节点，有环结点，向右旋转的链表这些题目。*

*通常要分别选取列表**长度为奇数、偶数**的测试用例，以验证算法在一般情况下正确性。*

使用链表 Queue<String> queue=new LinkedList<>()**实现队列**，入队offer()和出队poll()

1. 删除重复节点  DummyNode
2. 反转链表 前后当前3个结点
3. 找出两个链表公共结点 Y型
4. 返回倒数第个k结点 快慢指针
5. 找出链表有环入口 快慢指针
6. 删除某结点 下下个
7. 链表分为2份 左头尾 右头尾 
8. 两个链表加法 传参进位 递归相连
9. 合并排序链表 主从复制5
10. 从尾到头打印 标准返参递归
11. 约瑟夫问题

## 树

技巧：
树是一种天然的递归问题。

1. 遍历
2. 变成镜像 标准递归
3. 序列化 标准递归
4. 是否对称 两参递归
5. 是否平衡 结果类
6. 深度 为0不算数
7. 重建二叉树 四个参数 前序左尾等于开始加长度
8. 二叉搜索树的后序遍历 序列
9. 树的子结构 先找头
10. （非本书题）非递归遍历 前序：栈集  中：栈栈  后序：栈集（前序调序反转） 
11. 上下打印二叉树：队集

## 数组

技巧：凡是下标都要考虑越界问题，应当对每一个变量有明确的定义——是开区间or闭区间（即变量是取的到还是取不到）

1. 数组中超过一半的数 开心消消乐
2. 矩阵覆盖
3. 顺时针打印矩阵
4. 构建乘积数组 一个存前一个存后
5. 把数组排成最小的数 转成字符串比较
6. 数字在排序数组出现的次数
7. 连续子数组的最大和 有损利益者放弃
8. 数组中重复的数字
9. 旋转数组的最小数字
10. 二维数组中的查找
11. 数组中最小的k个数

## 字符串

1. 字符串转整数 注意：为0、正负、非法的情况
2. 左旋字符串
3. 反转单词顺序列
4. 和为S的连续正数序列
5. 第一个只出现一次的字符 位数组，第一个循环放，第二个循环按字符顺序找

## 双指针

1. 和为S的两个数字
2. 整数中1出现的次数

## 二进制

1. 1的个数 减1与
2. 不用加减乘除做加法
3. 求1+2...+n

## 栈

1. 包含min的栈
2. 栈的压入弹出序列

## 其他

1. 跳台阶
2. 变态跳台阶
3. 数值的整数次方 注意负次方、0



## 未做题

- 字符串的排序
- 复杂链表的复制
- 旋转数组的最小数字
- 数组中只出现一次 位操作
- 数组中重复的数字
- 数组中的逆序对
- 正则表达式匹配
- 表示数值的字符串
- 二叉搜索树和双向链表
- 二叉树的下一个结点
- 按之字形顺序打印二叉树
- 把二叉树打印成多行
- 二叉搜索树的第k个结点
- 树中两个节点的最低公共祖先
- 数据流中的中位数
- 滑动窗口的最大值
- 矩阵中的路径
- 机器人的运动范围
- 扑克牌的顺子 


# 玩转算法面试

[玩转算法面试](https://coding.imooc.com/class/82.html)慕课一个很棒的算法课程，针对算法面试，每一章对应一个类算法题，每一集解决一道leetcode题，并给出类似leetcode题。直接刚刷leetcode吃力可以先看这个视频。下面是我的笔记及LeetCode通过的代码。


## 第3章 数组

[
移动零](https://leetcode-cn.com/problems/move-zeroes) 

题目：给定一个数组 `nums`，编写一个函数将所有 `0` 移动到数组的末尾，同时保持非零元素的相对顺序。

关键词：双指针、O(N)

思路：将所有非零元素移到数组前面，index记录下标，index后的元素全置为0。即一个指针遍历一个指针记录。

优化点：if(i!=index)不傻傻的自己和自己交换，针对数组没有0这种情况做的优化判断，如果遍历的元素一直不为零，则只是index++。

```
 public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if(i!=index){//针对数组没有0这种情况做的优化判断
                int t = nums[i];
                nums[i] = nums[index];
                nums[index++] = t;
                }else{
                    index++;
                }
            }
        }
    
```



### [颜色分类](https://leetcode-cn.com/problems/sort-colors)

题目：给定一个包含红色、白色和蓝色，一共 *n* 个元素的数组，**原地**对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

关键词：O(N)、双指针

常规解法：计数排序的两趟扫描算法。首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。

进阶解法：一次遍历，三指针一个遍历其余两个记录0和2的位置。

```
  public static void sortColors(int[] nums) {
        int z = -1;
        int t = nums.length - 1;
        int i=0;

        while (i < t) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                swap(nums,i++,z+1);
                z++;
            }else{
                swap(nums,i,t--);
            }
        }
    }

      static  void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
```



### [两数相加 II](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/) 

题目：给定一个已按照**升序排列** 的有序数组，找到两个数使得它们相加之和等于目标数。

解法一：暴力O（n^2）

拿每一个数（外层遍历），去找它的另一半（内层遍历）。

```
 public static int[] twoSum(int[] numbers, int target) {
        int sta = 0;
        int end = numbers.length - 1;
        int[] result = new int[2];
        while (sta <= numbers.length - 1 && end >= 0) {
          int  sum = numbers[sta] + numbers[end];
            if (sum == target) {
                result[0] = sta+1;
                result[1] = end+1;
                return result;
            }
            if (sum > target)
                end--;
            if (sum < target)
                sta++;
        }
        return result;
    }
```



解法二：利用查找表（HashMap）遍历数组两次，因为常数项忽略，所以该解法O（n）。

将元素去全放入查找表中，之后遍历每一个元素i，在map里查找这个元素的另一半。关键在于查找表表找一个数是不需要遍历的，get一下就行了。

细节：要返回的是索引，所以不能简单的使用set，得使用map，key是这个i，map是索引

```
public static int[] twoSum2(int[] nums, int target) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int[] ints = new int[2];
    for (int i = 0; i < nums.length; i++) {
        hm.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
        int j = target - nums[i];
        if (hm.containsKey(j) && hm.get(j) != i) {
            ints[0] = i;
            ints[1] = hm.get(j);
        }
    }
    return ints;
}
```



### [长度最小的子数组](https://leetcode-cn.com/problems/minimum-size-subarray-sum/)  

与下一题无重复字符的最长子串很相似可以对比来看。

题目：给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

示例: 输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。

**关键词：滑动窗口**

从开始位置滑动窗口，大于s则左边指针加一，小于s则右边指针加一，这个过程中不断刷新最小值。

min = Math.min(min, r - l + 1);这里是min是滑动窗口大小，r - l + 1当前滑动窗口长度，是比较历史滑动窗口长度最小值和当前滑动窗口长度哪个更小。

细节：但凡有数组下标就需要考虑越界问题。注意r是从-1开始的。



```
 public static int minSubArrayLen(int s, int[] nums) {
      
        int r = -1;
        int l = 0;
        int sum = 0;
        int min = nums.length+1;//滑动窗口大小，以它永远取不到的长度作为初始值
        while (l < nums.length) {
            if (r+1 < nums.length && sum < s) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }
            if (sum >= s) {
                min = Math.min(min, r - l + 1);//r - l + 1当前滑动窗口长度
            }
        }
        return min == nums.length+1 ? 0 : min;
    }
```





### [无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

题目：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。



**关键词：滑动窗口+查找表**

在滑动窗口中做记录 ，用一个byte数组做查找表。

- 如果该数之前没出现过，则查找表中的这个字符的次数加加，并且右指针往后移动；
- 如果该数之前出现过，则左指针往后移动，并且查找表中的这个字符的次数减减。

```
 public  static  int lengthOfLongestSubstring(String s) {
        byte[]abc=new byte[256];
        int r=-1;
        int l=0;
        int max=0;
        while(l<s.length()){
          if(r+1<s.length()&&abc[s.charAt(r+1)]==0){
              abc[s.charAt(++r)]++;
          }else{
              abc[s.charAt(l++)]--;
          }
          max=Math.max(max,r-l+1);
        }
        return max;
    }
```



## 第4章 查找表

查找表就用一个容器储存所以出现过的字符，容器的作用可以以O（1）查出这个数之前有没出现过。

### [两个数组的交集](https://leetcode-cn.com/problems/intersection-of-two-arrays)

题目：给定两个数组，编写一个函数来计算它们的交集。

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2]

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [9,4]

关键词：查找表set

解法一：把一个数组元素放入查找表，遍历另一个数组时查查找表，如果有则放入交集set。

```java
public static int[] intersection(int[] nums1, int[] nums2) {
	    Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                resultSet.add(i);
            }
        }
        int[] a1 = new int[resultSet.size()];
        int ind = 0;
        for (Integer integer : resultSet) {
            a1[ind++] = integer;
        }
        return a1;
    }
```



解法二：HashSet有求交集的API。retainAll（）方法，可以把调用该方法的set赋值为与参数set2的交集。

```
 public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        set.retainAll(set2);
        //此时set已经是交集了，但为了转成数组
        int[] a1 = new int[set.size()];
        int ind = 0;
        for (Integer integer : set) {
            a1[ind++] = integer;
        }
        return a1;
    }
```



### [两个数组的交集 II](https://leetcode-cn.com/problems/intersection-of-two-arrays-ii)



题目：给定两个数组，编写一个函数来计算它们的交集。

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]

关键词：查找表map

两个数组的交集1的解法一已经用不了了，因为解法一只能返回两个set之间的重复数字，而不能返回重复数字重复了多少次。

如果数组2中的元素在map中存在（出现次数大于0），该元素就是一个交集元素，我们就将其存入返回数组中并且将map中该元素的出现次数减一即可。

map的使用，是因为要计数，所以要多一个信息存储的位置。

```
public static int[] intersection2(int[] nums1, int[]
nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            Integer t = hm.get(nums1[i])==null?0:hm.get(nums1[i]);
            hm.put(nums1[i], t + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            Integer t = hm.get(nums2[i])==null?0:hm.get(nums2[i]);

            if (t != 0) {
                list.add(nums2[i]);
                hm.put(nums2[i], t - 1);
            }
        }int []result=new int[list.size()];
        int ind=0;
        for (Integer integer : list) {
            result[ind++]=integer;
        }
        return result;
    }

```



### [四数相加 II](https://leetcode-cn.com/problems/4sum-ii)

题目：给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

解法一：暴力四重循环，O（n^4）

将D中的元素放进查找表可以达到O（n^3）



```
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                Integer t = hm.get(A[i] + B[j]) == null ? 0 : hm.get(A[i] + B[j]);

                hm.put(A[i] + B[j], t + 1);
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int t = 0 - C[i] - D[j];
                if (hm.containsKey(t)) {
                    result+=hm.get(t);
                }
            }
        }
        return result;
    }

```



### ？[回旋镖的数量](https://leetcode-cn.com/problems/number-of-boomerangs)

不可写成

```
int d = (points[i][0] - points[j][0]) ^2 + (points[i][1] - points[j][1]) ^2


```



```
public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            hashMap.clear();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int d = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                if (hashMap.containsKey(d)) {
                    res += hashMap.get(d) * 2;
                    hashMap.put(d, hashMap.get(d) + 1);
                } else {
                    hashMap.put(d, 1);
                }
            }
        }
        return res;
    }


```



### [存在重复元素 II](https://leetcode-cn.com/problems/contains-duplicate-ii)

题目：给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

输入: nums = [1,2,3,1], k = 3
输出: true

思路：查找表储存之前遍历过的元素，以此找nums [i] = nums [j]。判断查找表的长度是否等于k+1，以此保证 i 和 j 的差的 绝对值 至多为 k。

注意以下两点：

- *i* 和 *j* 之间的差的绝对值最大为k， *ķ*的数组有k+1个数，比如i=2，j=5，k=3，下标i到j有k+1个数。因此set的大小是k+1时，才需要移除元素。
- 移除的下标是i-k，比如i=5，k=3，要移除的下标是i-k=2

tips：如果你觉得这种边界值很难想象，套几个具体的例子。

```
public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() == k +1) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }


```



### [ 存在重复元素 III](https://leetcode-cn.com/problems/contains-duplicate-iii)

题目：给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。

示例 1:输入: nums = [1,2,3,1], k = 3, t = 0
输出: true
示例 2:输入: nums = [1,0,1,1], k = 1, t = 2
输出: true



根据题目可以得出一个重要的结论：我们要数组中找两个数，他们的差小于t。在遍历数组时，对于元素nums[i]，哪两个数的差会是最小?答案是，**比nums[i]大的数中最小的那一个，nums[i]小的中数最大的那一个。**形象来说就是，巨人中挑个矮的，侏儒中挑个高的。因此我们应该：

在 set 上查找大于等于x的最小的数，如果s−x≤t则返回 true
在 set 上查找小于等于x的最大的数，如果x−g≤t则返回 true

TreeSet的ceiling和floor方法可以方便的找着两种数。

- floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.
- ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.

![1571772195634](C:\Users\home.11\AppData\Roaming\Typora\typora-user-images\1571772195634.png)

此外为了防止整型溢出

- ceiling-t<=num要写成ceiling<=t+num
- num-floor<=t要写成num<=t+floor

```java
    public static boolean containsNearbyDuplicate3(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // if (set.contains(nums[i])) return true;
            int num = nums[i];

            //巨人中挑个矮的
            Integer ceiling = set.ceiling(num);
            //ceiling-t<=num 写成ceiling<=t+num是为了防止整型溢出
            if (ceiling != null && ceiling <= t + num) return true;
            //侏儒中挑个高的
            Integer floor = set.floor(num);
            //num-floor<=t
            if (floor != null && num <= t + floor) return true;
            set.add(num);
            if (set.size() == k + 1) {
                set.remove(nums[i - k]);
            }

        }
        return false;
    }

```



## 第5章 链表

### [删除链表中的节点](https://leetcode-cn.com/problems/delete-node-in-a-linked-list)

题目：删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。

思考：删除一个链表节点一般做法是把它的上一个元素指向它的下一个元素，这样改元素就没有任何指向，永远也遍历不到了。问题在于，当遍历找到这个元素时候，该元素只有指向下一个的指针没有指向上一个元素的指针。

**思路：把下一个元素值复制到要删除结点，删除下一个元素。**

可以这样理解，复制的时候就是覆盖（也就是删除）了要删除元素的值，删除下一个元素是删除了一个重复的值。

细节：这种做法是没有办法删除没有下一个元素的尾结点的，题目也特意说明要删除的元素不是尾结点。

```
public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode n = head;
        ListNode pre = newHead;

        while (n != null) {
            if (n.val == val) {
                pre.next = n.next;
            } else {
                pre = pre.next;
            }
            n = n.next;

        }
        return newHead.next;
    }


```



### [移除链表元素](https://leetcode-cn.com/problems/remove-linked-list-elements)

题目：删除链表中等于给定值 **val** 的所有节点。

思路：遍历一遍元素删除指定val。

关键词：虚拟头结点

细节：要考虑到头结点等val这种情况。头结点是没有前一个结点的，可以要人为构造头结点的前一个结点，**即设立链表的虚拟头结点。**如果这样做了，头结点就是**newHead.next;**而不是head了，因为原来的头结点可能已经被处理掉了。



```
  public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next=node.next.next;
    }

```



### [两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs)



题目：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

思路：定义4个变量用来两两交换，n1与n2交换。

- n1->next
- n2->n1
- pre->n2

![1571773566363](C:\Users\home.11\Desktop\小a笔记\images\2.png)

如上经过这三步调整后n1 = n1.next;而pre = pre.next.next。**因为n1交换后相当已经往后移了一位，而pre没有。**所以要切换到下一组交换的话，指针n1移一次，pre移两次。

```
public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode n1 = head;
        ListNode pre = newHead;
        ListNode n2, next;
        while (n1 != null) {
            n2 = n1.next;
            next = n2.next;
            if (n2 != null) {
                n1.next = next;
                n2.next = n1;
                pre.next = n2;
            }
            n1 = n1.next;
            pre = pre.next.next==null?null:pre.next.next;
        }
        return newHead.next;
    }


```



### [删除链表的倒数第N个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list)

题目：给定一个链表，删除链表的倒数第 *n* 个节点，并且返回链表的头结点。

```
public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode end = head;
        ListNode node = newHead;
        //找到倒数第n个节点
        while (n > 1) {
            if (end==null)return newHead.next;
            end = end.next;
            n--;
        }
        //删除它
        while (end.next!=null){
            end = end.next;
            node=node.next;
        }
        node.next=node.next.next;
        return newHead.next;
    }


```



## 第6章 栈，队列

### [有效的括号](https://leetcode-cn.com/problems/valid-parentheses)

题目：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。有效字符串需满足：左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。

遇到左括号放进栈，遇到右括号弹出匹配。栈全匹配完则字符串判断有效，否则是有不匹配的符号。

```
public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                //防止“[”这种情况
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (c == ')' && pop != '(') {
                    return false;
                }
                if (c == '}' && pop != '{') {
                    return false;
                }
                if (c == ']' && pop != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


```

### [二叉树的层次遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal)

题目：返回二叉树其按 **层序遍历** 得到的节点值

口诀;(队列)弹一个，加N个。即弹一个root，就把它的所有孩子加进去。

层次遍历的秘诀在于有一个计数器，记录当前层的个数，按照个数弹出当前层的元素。

```
public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int cur = queue.size();
            List<Integer> list = new ArrayList<>();
            while (cur > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                cur--;
            }
            result.add(list);
        }
        return result;
    }


```





### ?Perfect Squares



6-5 BFS和图的最短路径

```
public static int numSquares(int n) {
        // write your code here
        int[] dp = new int[n+1];  //对应的角标分解成最小完全平方数的最小个数
        Arrays.fill(dp, Integer.MAX_VALUE); //dp[]数组中所有的数据都置Integer.MAX_VALUE（int可以表示的最大数据）
        for(int i = 0; i * i <= n; i++)
            dp[i * i] = 1;  //小于等于n的所有的完全平方数的最小个数都是1
        System.out.println(Arrays.toString(dp));
        for(int i = 1; i <= n; i++) //看成是一个普通数（i）+完美平方数(j*j)
        {  //选定第一个数为 i
            for(int j = 1; i + j * j <= n; j++)
            {  //选定另一个数为 j*j
                System.out.println("dp["+(i + j * j)+"]="+"min("+dp[i] + 1+","+ dp[i + j * j]+")");
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);  //从小到大查找
            }
        }
        System.out.println("dp[n]"+dp[n]);
        return dp[n];
    }


```



## 第7章  二叉树和递归

### [ 路径总和](https://leetcode-cn.com/problems/path-sum)

题目：给定一个二叉树，返回所有从根节点到叶子节点的路径。

示例: 
给定如下二叉树，以及目标和 sum = 22，

```
          5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1

```

返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。



细节：不可以用if (root == null)做为递归终止条件。还需判断结点是否为叶子。就像这样if(root.left==null&&root.right==null)return root.val==sum;



```
public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if(root.left==null&&root.right==null)return root.val==sum;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }


```



### [二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths)

题目：给定一个二叉树，返回所有从根节点到叶子节点的路径。

```
 public static List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        if (root == null) return list;
//叶子节点
        if (root.left == null && root.right == null) {
            list.add(String.valueOf(root.val));
            return list;
        }
        List<String> leftList = binaryTreePaths(root.left);
        for (String s : leftList) {
            list.add(String.valueOf(root.val) + "->" + s);
        }
        List<String> rightList = binaryTreePaths(root.right);
        for (String s1 : rightList) {
            list.add(String.valueOf(root.val) + "->" + s1);
        }
        return list;
    }


```



### [路径总和 III](https://leetcode-cn.com/problems/path-sum-iii)

题目：给定一个二叉树，它的每个结点都存放着一个整数值。找出路径和等于给定数值的路径总数。路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

路径和为sum有两情况：包含node的路径，和不包含node路径。即把node传入findPath（）方法查找和从左右节点开始findPath（）查找。

注意有负数的话，可能在当前节点已经等于sum，在后面加一个减一个数又等于sum，所以要继续计算。

```
 public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    public static int findPath(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        if (root.val == sum){
            res += findPath(root.left, sum - root.val);
            res += findPath(root.right, sum - root.val);
            return res+=1;
        }
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
    }



```



### [二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree)

题目：给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

只要不是p和q同时小于或者大于node，node就是最近的父节点

注意不是同时小于等于或者同时大于等于，因为可能p、q其中一个就是node

```
 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val<root.val&&q.val<root.val)
            return lowestCommonAncestor(root.left,p,q);
        if (p.val>root.val&&q.val>root.val)
            return lowestCommonAncestor(root.right,p,q);
        return root;
    }


```



## 第8章 递归和回溯法

回溯思路基本如下：当前局面下，我们有若干种选择，所以我们对每一种选择进行尝试。如果发现某种选择违反了限定条件，此时跳过，如果尝试某种选择到了最后，发现该选择是正确解，那么就将其加入到解集中。

回溯的三个要素：选择 (Options)，限制 (Restraints)，结束条件 (Termination)。





### [电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)

题目：给定一个仅包含数字 `2-9` 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/original_images/17_telephone_keypad.png)

```java
private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

public List<String> letterCombinations(String digits) {
    List<String> combinations = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
        return combinations;
    }
    doCombination(new StringBuilder(), combinations, digits);
    return combinations;
}

private void doCombination(StringBuilder prefix, List<String> combinations, final String digits) {
    if (prefix.length() == digits.length()) {
        combinations.add(prefix.toString());
        return;
    }
    int curDigits = digits.charAt(prefix.length()) - '0';
    String letters = KEYS[curDigits];
    for (char c : letters.toCharArray()) {
        prefix.append(c);                         // 添加
        doCombination(prefix, combinations, digits);
        prefix.deleteCharAt(prefix.length() - 1); // 删除
    }
}

```





### [全排列](https://leetcode-cn.com/problems/permutations)

题目：给定一个 **没有重复** 数字的序列，返回其所有可能的全排列。

```java
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> permutes = new ArrayList<>();
    List<Integer> permuteList = new ArrayList<>();
    boolean[] hasVisited = new boolean[nums.length];
    backtracking(permuteList, permutes, hasVisited, nums);
    return permutes;
}

private void backtracking(List<Integer> permuteList, List<List<Integer>> permutes, boolean[] visited, final int[] nums) {
    if (permuteList.size() == nums.length) {
        permutes.add(new ArrayList<>(permuteList)); // 重新构造一个 List
        return;
    }
    for (int i = 0; i < visited.length; i++) {
        if (visited[i]) {
            continue;
        }
        visited[i] = true;
        permuteList.add(nums[i]);
        backtracking(permuteList, permutes, visited, nums);
        permuteList.remove(permuteList.size() - 1);
        visited[i] = false;
    }
}

```





### [组合](https://leetcode-cn.com/problems/combinations/)

题目：给定两个整数 *n* 和 *k*，返回 1 ... *n* 中所有可能的 *k* 个数的组合。

```java
public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> combinations = new ArrayList<>();
    List<Integer> combineList = new ArrayList<>();
    backtracking(combineList, combinations, 1, k, n);
    return combinations;
}

private void backtracking(List<Integer> combineList, List<List<Integer>> combinations, int start, int k, final int n) {
    if (k == 0) {
        combinations.add(new ArrayList<>(combineList));
        return;
    }
    for (int i = start; i <= n - k + 1; i++) {  // 剪枝
        combineList.add(i);
        backtracking(combineList, combinations, i + 1, k - 1, n);
        combineList.remove(combineList.size() - 1);
    }
}

```





### [单词搜索](https://leetcode-cn.com/problems/word-search)

题目：给定一个二维网格和一个单词，找出该单词是否存在于网格中。

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false

```java
private final static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
private int m;
private int n;

public boolean exist(char[][] board, String word) {
    if (word == null || word.length() == 0) {
        return true;
    }
    if (board == null || board.length == 0 || board[0].length == 0) {
        return false;
    }

    m = board.length;
    n = board[0].length;
    boolean[][] hasVisited = new boolean[m][n];

    for (int r = 0; r < m; r++) {
        for (int c = 0; c < n; c++) {
            if (backtracking(0, r, c, hasVisited, board, word)) {
                return true;
            }
        }
    }

    return false;
}

private boolean backtracking(int curLen, int r, int c, boolean[][] visited, final char[][] board, final String word) {
    if (curLen == word.length()) {
        return true;
    }
    if (r < 0 || r >= m || c < 0 || c >= n
            || board[r][c] != word.charAt(curLen) || visited[r][c]) {

        return false;
    }

    visited[r][c] = true;

    for (int[] d : direction) {
        if (backtracking(curLen + 1, r + d[0], c + d[1], visited, board, word)) {
            return true;
        }
    }

    visited[r][c] = false;

    return false;
}

```



### [岛屿数量](https://leetcode-cn.com/problems/number-of-islands)



### [N皇后](https://leetcode-cn.com/problems/n-queens/)

题目：*n* 皇后问题研究的是如何将 *n* 个皇后放置在 *n*×*n* 的棋盘上，并且使皇后彼此之间不能相互攻击。

```java
private List<List<String>> solutions;
private char[][] nQueens;
private boolean[] colUsed;
private boolean[] diagonals45Used;
private boolean[] diagonals135Used;
private int n;

public List<List<String>> solveNQueens(int n) {
    solutions = new ArrayList<>();
    nQueens = new char[n][n];
    for (int i = 0; i < n; i++) {
        Arrays.fill(nQueens[i], '.');
    }
    colUsed = new boolean[n];
    diagonals45Used = new boolean[2 * n - 1];
    diagonals135Used = new boolean[2 * n - 1];
    this.n = n;
    backtracking(0);
    return solutions;
}

private void backtracking(int row) {
    if (row == n) {
        List<String> list = new ArrayList<>();
        for (char[] chars : nQueens) {
            list.add(new String(chars));
        }
        solutions.add(list);
        return;
    }

    for (int col = 0; col < n; col++) {
        int diagonals45Idx = row + col;
        int diagonals135Idx = n - 1 - (row - col);
        if (colUsed[col] || diagonals45Used[diagonals45Idx] || diagonals135Used[diagonals135Idx]) {
            continue;
        }
        nQueens[row][col] = 'Q';
        colUsed[col] = diagonals45Used[diagonals45Idx] = diagonals135Used[diagonals135Idx] = true;
        backtracking(row + 1);
        colUsed[col] = diagonals45Used[diagonals45Idx] = diagonals135Used[diagonals135Idx] = false;
        nQueens[row][col] = '.';
    }
}

```



## 第9章 动态规划基础

很多同学听到“动态规划”的名称可能会望而生畏，觉得动态规划的问题都很复杂。但其实，动态规划本
质依然是递归算法，只不过是满足特定条件的递归算法。在这一章里，我们就来逐步解开动态规划的神
秘面纱
Climbing Stairs

### [整数拆分](https://leetcode-cn.com/problems/integer-break/)

题目：给定一个正整数 *n*，将其拆分为**至少**两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

示例 1:输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。

示例 2:输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
说明: 你可以假设 n 不小于 2 且不大于 58。

思路：使用一个memo数组达到记忆化搜索的目的。

#### 循环版

- 第一层循环，每一步求解最大的memo[i]
- 第二层循环，每一次从1到i分解相乘，计算最大的乘法
- memo[i]之前计算出的最大值, j * i - j当前一步分解为j和i减j两个数, j * memo[i - j]不止两个数了，进一步分解。

```java
    //自底向上
    public int integerBreakBT(int n) {
        int[] memo = new int[n + 1];//因为是从1开始的
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                memo[i] = max3(memo[i], j * i - j, j * memo[i - j]);
            }
        }
        return memo[n];
    }
    public int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
   }


```



#### 递归版

递归函数调用其实就是完成第一层循环的任务。

```java
 public int integerBreak(int n) {
         int[] memo = new int[n + 1];
        f(n, memo);
        return memo[n];
    }
   public int f(int n, int[] memo) {
        if (n == 1) return 1;
        int res = -1;
        if (memo[n]!=0)return memo[n];
        for (int i = 1; i < n; i++) {
            res=max3(res,i*(n-i),i*f(n-i,memo));
        }
        memo[n]=res;
        return res;
    }

    public int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
   }


```



### [打家劫舍](https://leetcode-cn.com/problems/house-robber/)

题目：你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

示例 1:输入: [1,2,3,1]
输出: 4
解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。

示例 2:输入: [2,7,9,3,1]
输出: 12
解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。

首先看 n = 1 的情况，显然 
$$
 f(1) = A_1A 
1
	
 。
$$
再看 n = 2，
$$
f(2) = max(A_1A 
1
	
 , A_2A 
2
	
 )。
$$
对于 n = 3，有两个选项:

抢第三个房子，将数额与第一个房子相加。不抢第三个房子，保持现有最大数额。显然，你想选择数额更大的选项。

此时就要对比（前一位数，前两位数加本位数）哪个更大，每一步都取最大值，最后的结果就会是最大值。

于是，可以总结出公式：
$$
f(k) = max(f(k – 2) + A_kA 
k
	
 , f(k – 1))
$$

```java
  public int rob(int[] nums) {
    int prevMax = 0;
        int currMax = 0;
        for (int x : nums) {
            int t=currMax;
            currMax=prevMax+x>t?prevMax+x:t;
            prevMax=t;
        }
        return currMax;
    }


```

### 贪心问题

#### 递归版



以最后一格为例子，在最后一格有两种情况，放与不放。不放就同列上上的情况，也就是它上面的（5，1）16。放就上一行，列是由是当前重量减去本物重量，也是

|                    | 0    | 1    | 2    | 3    | 4    | 5      |
| ------------------ | ---- | ---- | ---- | ---- | ---- | ------ |
| 0（价值6，重量1）  | 0    | 6    | 6    | 6    | 6    | 6      |
| 1（价值10，重量2） | 0    | 6    | 10   | 16   | 16   | *16*   |
| 2（价值12，重量3） | 0    | 6    | 10   | 16   | 18   | **22** |





```
public static int knapsack01BT(int[] weight, int[] value, int c, int index) {
        if (c <= 0 || index < 0) return 0;
        //不放
        int res = knapsack01BT(weight, value, c, index - 1);
        if (weight[index] <= c) {
            //选择放入本物品，加价值并减重量
            res = Math.max(res, value[index]+knapsack01BT(weight, value, c - weight[index], index - 1));
        }
        return res;
}


```
