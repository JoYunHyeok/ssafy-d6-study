import java.util.Scanner;

public class Main {
	static int[] coin, D;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int tc=0; tc<TC; tc++) {
			int N = sc.nextInt();
			coin = new int[N]; // ���� ���� �迭
			for(int i=0; i<N; i++) { // ���� ���
				coin[i] = sc.nextInt();
			}
			
			int M = sc.nextInt();
			D = new int[M+1];
			D[0] = 1; // ������ ����
			
			for(int i=0; i<N; i++) { // ���� �ϳ��� ������
				for(int j=coin[i]; j<=M; j++) { //������ �� �ݾ� M����
					D[j] += D[j-coin[i]];
				}
			}
			
			System.out.println(D[M]);
			
		}
	}

}
