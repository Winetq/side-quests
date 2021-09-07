package com.epam.jap;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] a = {12, 35, 1, 10, 34, 1};
        int[] b = {44, 66, 99, 77, 33, 22, 55};
        int[] c = {1, 2, 5, 6, 3, 2};

        /**
         * Time Complexity = O(n + n * log(n)) = O(n * log(n))
         * Space Complexity = O(n)
         */
        System.out.println("Solution 1:");
        System.out.println(solution1(a, a.length));
        System.out.println(solution1(b, b.length));
        System.out.println(solution1(c, c.length));

        /**
         * Time Complexity = O(n + n) = O(n)
         * Space Complexity = O(1)
         */
        System.out.println("Solution 2:");
        System.out.println(solution2(a, a.length));
        System.out.println(solution2(b, b.length));
        System.out.println(solution2(c, c.length));

        /**
         * Time Complexity = O(n)
         * Space Complexity = O(1)
         */
        System.out.println("Solution 3:");
        System.out.println(solution3(a, a.length));
        System.out.println(solution3(b, b.length));
        System.out.println(solution3(c, c.length));
    }

    private static int solution1(int[] arr, int n) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = arr[i];
        }
        Arrays.sort(ans);
        return ans[n-2];
    }

    private static int solution2(int[] arr, int n) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i : arr) {
            first = Math.max(first, i);
        }
        for (int i : arr) {
            if (i != first) {
                second = Math.max(second, i);
            }
        }
        return second;
    }

    private static int solution3(int[] arr, int n) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > first) {
                second = first;
                first = i;
            }
            if (i > second && i != first) {
                second = i;
            }
        }
        return second;
    }
}

