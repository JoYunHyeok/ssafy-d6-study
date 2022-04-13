import java.util.Scanner;

public class BOJ_1062_����ħ {
	static int N, K; 
	static boolean[] visited; // 26���� �ؾ���, ���ε����ϴ°� ����
	static int max = Integer.MIN_VALUE; 
	static String[] array; // anta tica ������ ���ڵ�
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		if(K<5) { 
			System.out.println(0);
		}else {
			array = new String[N];
			visited = new boolean[26];
			for(int i=0; i<N; i++) array[i] = sc.next(); // �ڸ��°� ����? ���߶� ���������
			visited['a'-97] = visited['c'-97] = visited['t'-97] = visited['i'-97] = visited['n'-97] = true;
			comb(0, 0);
			System.out.println(max);
		}

	}

	static void comb(int start, int cnt) {
		if(cnt == K-5) {
			max = Math.max(max, check());
			return;
		}
		
		for (int i = start; i < 26; i++) { //���� �۾Ƽ� 26���� �ص� �ɵ�
			if (!visited[i]) {
				visited[i] = true;
				comb(i, cnt+1);
				visited[i] = false;
			}
		}

	}

	static int check() {
		int cnt = 0;
		for(String str : array) {
			boolean flag = true;
			for(int s=0; s<str.length(); s++) {
				if(!visited[str.charAt(s)-97]) {
					flag = false;
					break;
				}
			}
			if(flag) cnt++;
		}
		return cnt;
	}
}