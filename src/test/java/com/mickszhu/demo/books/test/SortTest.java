package com.mickszhu.demo.books.test;

import com.mickszhu.demo.books.BaseTest;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

@Slf4j
public class SortTest  extends BaseTest {

    @Test
    public void selectSort(){
        int arr[] = {6, 5, 3, 2, 4};

        //选择
        for (int i = 0; i < arr.length; i++) {
            //默认第一个是最小的。
            int min = arr[i];
            //记录最小的下标
            int index = i;
            //通过与后面的数据进行比较得出，最小值和下标
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            //然后将最小值与本次循环的，开始值交换
            int temp = arr[i];
            arr[i] = min;
            arr[index] = temp;
            //说明：将i前面的数据看成一个排好的队列，i后面的看成一个无序队列。每次只需要找无需的最小值，做替换
        }
        for (int i : arr) {
            log.info("输出：{}",i);
        }
    }
}
