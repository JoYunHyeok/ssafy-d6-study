package �ùķ��̼�;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1547_�� {
	static boolean[] array = new boolean[4];
	static int M;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();

		array[1] = true;

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			if (array[a] || array[b]) { // ���߿� �ϳ��� true���
				array[a] = !array[a];
				array[b] = !array[b];
			}

		}

		for (int i = 1; i < 4; i++) {
			if (array[i])
				System.out.println(i);
		}
	}

}
