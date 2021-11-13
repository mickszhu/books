package com.mickszhu.demo.books.test;

import com.mickszhu.demo.books.BaseTest;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

@Slf4j
public class SortTest  extends BaseTest {

    /**
     * 每次遍历的时候，将前面找出的最小值，看成一个有序的列表，
     * 后面的看成无序的列表，然后每次遍历无序列表找出最小值。
     */
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

    /**
     * 默认将第一数据看成有序列表，后面无序的列表循环每一个数据，如果比前面的数据小则插入（交换）。否则退出
     */
    @Test
    public  void insertSort() {

        int arr[] = {7, 5, 3, 2, 4};

        //插入排序
        for (int i = 1; i < arr.length; i++) {
            //外层循环，从第二个开始比较
            for (int j = i; j > 0; j--) {
                //内存循环，与前面排好序的数据比较，如果后面的数据小于前面的则交换
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    //如果不小于，说明插入完毕，退出内层循环
                    break;
                }
            }
        }
        for (int i : arr) {
            log.info("输出：{}",i);
        }
    }

    /**
     * 股票的最大利润
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     */
    @Test
    public void maxProfitTest(){
        int prices[] = {4, 2, 4, 9, 1,7,5,6};
        int res = 0, min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] <= min) {
                min = prices[i];
            }else {
                res = Math.max(res, prices[i] - min);
            }
        }

        log.info("打印结果：{}",res);
        //log.info("max:{},maxIndex:{},mix:{},mixIndex:{},diffren;{}",max,maxIndex,mix,mixIndex,diffren);
    }
}
