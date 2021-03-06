public static boolean kmp(String str, String dest) {
      int[] next =  generateNext(dest);
      
      //i 是 str 的索引，j 是 dest 的索引。
      for (int i = 0, j = 0; i < str.length(); i++) {
          //匹配发生错误时，在 next 数组中向前迭代找到匹配的结果。这是整个算法的核心位置！
          while (j > 0 && str.charAt(i) != dest.charAt(j))
              j = next[j - 1];

          //如果相等，dest 中的索引往后移动一位
          if (str.charAt(i) == dest.charAt(j))
              j++;
          
          //dest 数组所有位置均连续的匹配完成s
          if (j == dest.length())
              return true;
      }

      return false;
  }
  //生成 next 数组中向前迭代找到匹配的结果。这是整个算法的核心位置！
  private void generateNext(String str) {
      int[] next = new int[dest.length()];
        next[0] = 0;  //第一个元素的 next 值为 0。

        //i 是需要计算的 next 值的下标；在 for 循环的开始，j 记录了上一个元素的部分匹配值,即前缀串中公共部分的最后一位字符的下标。
        for (int i = 1, j = 0; i < str.length(); i ++) {
          //当 i 和 j 指向的字符不匹配时，在 next 中往前迭代，直到两字符相等或者 j 为 0.
            while(j > 0 && str.charAt(i) != str.charAt(j))
                j = next[j - 1];

            //如果 j 和 i 指向的字符相等，则 j 增加 1.
            if (str.charAt(i) == str.charAt(j))
                j ++;

            next[i] = j;
        }
    }