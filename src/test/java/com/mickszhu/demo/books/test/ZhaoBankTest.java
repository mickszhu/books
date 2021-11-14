package com.mickszhu.demo.books.test;

import com.mickszhu.demo.books.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.zip.Inflater;

@Slf4j
public class ZhaoBankTest  extends BaseTest {

    @Test
    public void getValueTest(){
        //[1,3,5,2,4],[1,2,3,4,5]
        int[]  nums= {3,1,2,5,4};
        int[]  values = {5,4,3,2,1};
        //[1,100],[2,1]

        int maxValue = getMaxValue(nums, values);
        log.info("everyGetTotalValue:{}",maxValue);
    }

    public int getMaxValue (int[] nums, int[] values) {
        // write code here
        int everyGetTotalValue =  0;
        if(nums.length ==0 || values.length==0){
            return 0;
        }

        int numLength = nums.length;
        int starIndex =0;
        int endIndex=numLength-1;

        int[] numsNew = new int[numLength];
        //倒排还是顺排
        boolean sortDesc = false;
        if(values.length>=1){
            if(values[0]< values[1]){
                sortDesc = true;
            }
        }

        for (int i=0; i<numLength;i++){
            if( sortDesc && nums[starIndex] <= nums[endIndex]
            || !sortDesc && nums[starIndex] >= nums[endIndex]
            ){
                numsNew[i] = nums[starIndex];
                starIndex ++;
            }else{
                numsNew[i] = nums[endIndex];
                endIndex--;
            }
        }
        log.info("numNew:{}",numsNew);
        for (int i =0;i< numLength;i++) {
            everyGetTotalValue += numsNew[i]* values[i];
            log.info("num:{},numNew:{},values:{},total:{}",i+1,numsNew[i],values[i],everyGetTotalValue);
        }
        return everyGetTotalValue;
    }


    @Test
    public void  tranArrTest(){
        //        int[] arrA = {1,8};
        //         int[] arrA = {-1,9,9};
        int[] arrA = {-1,9,9};
        int K = 6;
        int[] tranArr = tranArr(arrA, K);
        log.info("tranArr:{}",tranArr);
    }

    public int[] tranArr (int[] arrA, int K) {
        // write code here
        int[] result = {0,0};
        if(arrA.length ==0){
            return result;
        }
        int maxArr = arrA[0];
        int mixArr =arrA[0];
        int mixArrNum =0;
        for (int i : arrA) {
            if(i>maxArr){
                maxArr = i;
            }
            if (mixArr>i){
                mixArr =i;
            }
            if(i>=0 && mixArrNum >i){
                mixArrNum = i;
            }
        }

        if(K ==0){
            result[0] = maxArr;
            result[1] =maxArr;
            return  result;
        }

        int maxLength = maxArr - mixArr;
        int runtNumMax = maxLength / 2;
        log.info("maxLength:{},runtNumMax:{}}",maxLength,runtNumMax);
        log.info("arrA:maxArr-{},mixArr-{}",maxArr,mixArr);
        if(runtNumMax > K){
            runtNumMax =K;
        }
        int[] arrB= new int[arrA.length];
        for (int i=0 ; i<arrA.length; i++) {
            if(arrA[i]<runtNumMax){
                arrB[i] = arrA[i] + runtNumMax;
            }
            if(arrA[i]> runtNumMax){
                arrB[i] = arrA[i] - runtNumMax;
            }
        }
        log.info("arrB:{}", arrB);
        maxArr = arrB[0];
        mixArr =arrB[0];
        for (int i : arrB) {
            if(maxArr < i){
                maxArr = i;
            }
            if(mixArr > i){
                mixArr = i;
            }
        }
        result[0] = mixArr;
        result[1] =maxArr;
        return result;
    }
}
