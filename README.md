[牛客剑指专题](https://www.nowcoder.com/ta/coding-interviews)
## 分类及思路

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


# [《玩转算法面试》](https://coding.imooc.com/class/82.html)

慕课一个很棒的算法课程，针对算法面试，每一章对应一个类算法题，每一集解决一道leetcode题，并给出类似leetcode题。直接刚刷leetcode吃力可以先看这个视频。下面是我的笔记及通过的代码。

## 第3章 数组

[移动零](https://leetcode-cn.com/problems/move-zeroes) 

思路：将所有非零元素移到数组前面，index记录下标，index后的元素全置为0.

if(i!=index)不傻傻的自己和自己交换，针对数组没有0这种情况做的优化判断，如果遍历的元素一直不为零，则只是index++。

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



### ？[两数相加 II](https://leetcode-cn.com/problems/add-two-numbers-ii) 

```

```



### [长度最小的子数组](https://leetcode-cn.com/problems/minimum-size-subarray-sum/)  滑动窗口

与下一题无重复字符的最长子串很相似可以对比来看。

> 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
>
> 示例: 输入: s = 7, nums = [2,3,1,2,4,3]
> 输出: 2
> 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。

从开始位置滑动窗口，大于s则左边指针加一，小于s则右边指针加一，这个过程中不断刷新最小值。

min = Math.min(min, r - l + 1);看看的历史最小值小还是当前滑动窗口长度小。

但凡有数组下标就需要考虑越界问题。注意r是从-1开始的。



```
 public static int minSubArrayLen(int s, int[] nums) {
      
        int r = -1;
        int l = 0;
        int sum = 0;
        int min = nums.length+1;//一个永远取不到的长度作为初始值
        while (l < nums.length) {
            if (r+1 < nums.length && sum < s) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }
            if (sum >= s) {
                min = Math.min(min, r - l + 1);
            }
        }
        return min == nums.length+1 ? 0 : min;
    }
```





#### [无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

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

查找表就用一个容器储存所以出现过的字符，容器的作用就遍历数组的时候可以查出这个数之前有没出现过。

### [两个数组的交集](https://leetcode-cn.com/problems/intersection-of-two-arrays)

使用 set是因为只要知道有无就好了，关键在于JDK的set有retainAll（）方法，可以把该set赋为与set的交集。

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
        int[] a1 = new int[set.size()];
        int ind = 0;
        for (Integer integer : set) {
            a1[ind++] = integer;
        }
        return a1;
    }
```



### [两个数组的交集 II](https://leetcode-cn.com/problems/intersection-of-two-arrays-ii)

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



### [两数之和](https://leetcode-cn.com/problems/two-sum)

```
 /**
     * 解法一：将元素去全放入查找表中，之后遍历每一个元素i，查找target-i。
     * 因为要返回的是索引，所以不能简单的使用set，得使用map，key是这个i，map是索引
     */
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



### [四数相加 II](https://leetcode-cn.com/problems/4sum-ii)

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

注意一下两点：

- *i* 和 *j* 之间的差的绝对值最大为 *ķ*的数组有k+1个数，比如j=2，i=5，k=3，下标i到j有k+1个数。因此set的大小是k+1时，才需要移除元素。
- 移除的下标是i-k，比如i=5，k=3，要移除的下标是i-k=2

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

根据题目可以得出一个重要的结论：我们要数组中找两个数，他们的差小于t。在遍历数组时，对于元素nums[i]，哪一个数的差会是最小?答案是，**比nums[i]大的数中最小的那一个和nums[i]小的中数最大的那一个。**因此我们应该：

在 set 上查找大于等于x的最小的数，如果s−x≤t则返回 true
在 set 上查找小于等于x的最大的数，如果x−g≤t则返回 true

TreeSet的ceiling和floor方法可以方便的找着两种数。

- floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.
- ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.

![1571772195634](C:\Users\home.11\AppData\Roaming\Typora\typora-user-images\1571772195634.png)

此外为了防止整型溢出

- ceiling-t<=v要写成ceiling<=t+v
- v-floor<=t要写成v<=t+floor

```
 public static boolean containsNearbyDuplicate3(int[] nums, int k,int t) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                // if (set.contains(nums[i])) return true;
                int v=nums[i];
                Integer ceiling = set.ceiling(v);
                //v-ceiling v都比ceiling小是还减，会减出一个负数来
                if (ceiling != null && ceiling<=t+v)return true;
                Integer floor = set.floor(v);
                if (floor != null &&v<=t+floor)return true;
                set.add(v);
                if (set.size() == k +1) {
                    set.remove(nums[i-k]);
                }

            }
            return false;
        }

```



## 第5章 链表

### [删除链表中的节点](https://leetcode-cn.com/problems/delete-node-in-a-linked-list)

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

如果要处理的元素也包括头结点，但头结点是没有前一个结点的，可以要人为构造头结点的前一个结点，**即设立链表的虚拟头结点。**如果这样做了，头结点就是**newHead.next;**而不是head了，因为原来的头结点可能已经被处理掉了。

```
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode end = head;
        ListNode node = newHead;
        while (n > 1) {
            if (end==null)return newHead.next;
            end = end.next;
            n--;
        }
        while (end.next!=null){
            end = end.next;
            node=node.next;
        }
        node.next=node.next.next;
        return newHead.next;
    }

```



### [两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs)

![1571773566363](C:\Users\home.11\Desktop\小a笔记\images\2.png)



- n1->next

- n2->n1

- pre->n2

  一轮三步调整后n1 = n1.next;而pre = pre.next.next。**因为n1交换后相当已经往后移了一位，而pre没有。**所以要切换到下一组交换的话，指针n1移一次，pre移两次。

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



### [删除链表中的节点](https://leetcode-cn.com/problems/delete-node-in-a-linked-list)

```
  public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next=node.next.next;
    }

```



### [删除链表的倒数第N个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list)

```
public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode end = head;
        ListNode node = newHead;
        while (n > 1) {
            if (end==null)return newHead.next;
            end = end.next;
            n--;
        }
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





### Perfect Squares???

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



## 第7章 二叉树和递归

### [ 路径总和](https://leetcode-cn.com/problems/path-sum)

```
if (root == null) return sum==0;

```



这样写是错的，不可以用if (root == null)做为递归终止条件。

还需判断结点是否为叶子。就像这样

```
if(root.left==null&&root.right==null)return root.val==sum;

```



```
public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if(root.left==null&&root.right==null)return root.val==sum;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }

```



### [二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths)

```
 public static List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        if (root == null) return list;

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



### [电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)

### [全排列](https://leetcode-cn.com/problems/permutations)

### [组合](https://leetcode-cn.com/problems/combinations/)

### [单词搜索](https://leetcode-cn.com/problems/word-search)

### [岛屿数量](https://leetcode-cn.com/problems/number-of-islands)

### [N皇后](https://leetcode-cn.com/problems/n-queens/)



## 第9章 动态规划基础

很多同学听到“动态规划”的名称可能会望而生畏，觉得动态规划的问题都很复杂。但其实，动态规划本
质依然是递归算法，只不过是满足特定条件的递归算法。在这一章里，我们就来逐步解开动态规划的神
秘面纱
Climbing Stairs

### [整数拆分](https://leetcode-cn.com/problems/integer-break/)

使用一个memo数组达到记忆化搜索的目的。

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

首先看 n = 1 的情况，显然 
$$
 f(1) = A_1A 
1
​	
 。
$$
再看 n = 2，
$$
f(2) = max(A_1A 
1
​	
 , A_2A 
2
​	
 )。
$$
对于 n = 3，有两个选项:

抢第三个房子，将数额与第一个房子相加。不抢第三个房子，保持现有最大数额。显然，你想选择数额更大的选项。

此时就要对比（前一位数，前两位数加本位数）哪个更大，每一步都取最大值，最后的结果就会是最大值。

于是，可以总结出公式：
$$
f(k) = max(f(k – 2) + A_kA 
k
​	
 , f(k – 1))
$$

```
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



以最后一格为例子，在最后一格有两种情况，放与不放。不放就同列上上的情况，也就是它上面的（5，1）16。放就上一行，列是由是当前重量减去本物重量，也是（）

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


