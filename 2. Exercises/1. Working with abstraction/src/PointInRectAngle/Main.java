package PointInRectAngle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[] coordinates = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] bottomLeftPoint = new int[2];
        bottomLeftPoint[0] = coordinates[0];
        bottomLeftPoint[1] = coordinates[1];

        int[] topRightPoint = new int[2];
        topRightPoint[0] = coordinates[2];
        topRightPoint[1] = coordinates[3];

    int n = Integer.parseInt(console.nextLine());

        for (int i = 0; i < n ; i++) {
            Point point = new Point(console.nextInt(),console.nextInt());
            System.out.println(Rectangle.contains(point));
        }
    }

}
