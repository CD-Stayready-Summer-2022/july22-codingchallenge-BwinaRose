package com.codedifferently;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Solution {
    /**
     * You will be given an integer called number and an array called possibleFamilyMembers
     * your jobs is to find the number's family members. A family member is any value that's with in
     * 1 of any other number in the family.
     *
     * So for example if the number = 4, and the possibleFamilyMembers is [1,4,3,5]
     * The actualFamilyMembers would be [3,4,5]
     * 3 is 1 away from 4
     * 4 is equal to 4
     * 4 is 1 away from 5
     * while
     * 1 is not included because the closest releation to 1 is 3 and that's 2 away.
     * @param number
     * @param possibleFamilyMembers
     * @return
     */
    public Integer[] numberFamily(Integer number, Integer[] possibleFamilyMembers){
        List<Integer> output = new ArrayList<>();
        Arrays.sort(possibleFamilyMembers);
        List<Integer> nums = new ArrayList<>(Arrays.asList(possibleFamilyMembers));
        int start = nums.indexOf(number);
        for (int i = start - 1; i < possibleFamilyMembers.length - 1; i++) {
            if (Math.abs(possibleFamilyMembers[i] - possibleFamilyMembers[i + 1]) <= 1) {
                output.add(possibleFamilyMembers[i + 1]);
            }
        }
        for (int i = start; i > 0; i--) {
            if (Math.abs(possibleFamilyMembers[i] - possibleFamilyMembers[i - 1]) <= 1) {
                output.add(possibleFamilyMembers[i - 1]);
                continue;
            }
            break;
        }
        Integer[] family = new Integer[output.size()];
        family = output.toArray(family);
        Arrays.sort(family);
        return family;
    }
}