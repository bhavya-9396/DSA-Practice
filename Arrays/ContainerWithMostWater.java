import java.util.*;
public class  ContainerWithMostWater{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // size of array
        int n = sc.nextInt();

        int[] height = new int[n];

        // input array elements
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        ContainerWithMostWater obj = new ContainerWithMostWater();
        System.out.println(obj.maxArea(height));
    }

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {

            int h = Math.min(height[left], height[right]);
            int width = right - left;

            int area = h * width;

            maxWater = Math.max(maxWater, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}

