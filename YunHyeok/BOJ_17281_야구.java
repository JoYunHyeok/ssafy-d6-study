import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17281_�߱� {
	static int size = 9;
	static boolean[] visited; // �湮�迭
	static int[][] gameList; // �̴��� ���� �迭
	static int[] orderList; // Ÿ���迭
	static int N; // �� �̴�
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		gameList = new int[N][size]; //  ���� ������ ���� ������� 1�� 4�� �ٲ� ���¿��� ����
		visited = new boolean[size]; // �湮üũ�� ���� ����Ʈ
		orderList = new int[size]; // ���������ϴ� ����Ʈ
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); // ������� �Է¹ޱ�
			for(int j=0; j<size; j++) {
				gameList[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		orderList[3] = 0; //4�� Ÿ�ڸ� 1�� Ÿ�ڿ� ����
		visited[3] = true; // 4�� ������ ������ ������
		
		dfs(1);
		System.out.println(max);
		
	}
	
	static void dfs(int start) {
		if(start == 9) {
			// �̴� ����
			int score = play();
			max = Math.max(max, score);
			return;
		}
		
		
		for(int i=0; i<9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				orderList[i] = start;
				dfs(start+1);
				visited[i] = false;
			}
		}
	}

	static int play() {
		int pIdx=0; // Ÿ��
		int score = 0; // �� ���� ��
		
		for(int i=0; i<N; i++) { // �� N�̴� �ݺ�
			boolean[] base = new boolean[3]; // 1��, 2��, 3�� �̴� ���� �ʱ�ȭ?
			int outCnt = 0; // �ƿ� ī��Ʈ
			inning : while(true) { // 3�ƿ� �ɶ�����..
				for(int j=pIdx; j<9; j++) {
					int player = gameList[i][orderList[j]];
					
					if(player == 0) { // �ƿ�
						outCnt++;
					}else if(player == 1) { // 1��Ÿ
						for(int b=2; b>=0; b--) {
							if(base[b]) {
								if(b==2) {
									base[b] = false; // 3�簡 Ȩ���� ��
									score++; // 1�� �÷��ְ�
									continue;
								}
								base[b+1] = true; // ���̽� ��ĭ�� �̵�
								base[b] = false; 
							}
						}
						base[0] = true; // 1��Ÿ ������ 1��� ����
					}else if(player == 2) { // 2��Ÿ
						for(int b=2; b>=0; b--) {
							if(base[b]) {
								if(b==1 || b==2) {
									base[b] = false; // 2, 3�簡 Ȩ���� ��
									score++; // 1�� �÷��ְ�
									continue;
								}
								base[b+2] = true; // ���̽� ��ĭ�� �̵�
								base[b] = false; 
							}
						}
						base[1] = true; // 2��Ÿ ������ 2��� ����
					}else if(player == 3) { // 3��Ÿ
						for(int b=2; b>=0; b--) {
							if(base[b]) {
								base[b] = false; // 1, 2, 3�簡 Ȩ���� ��
								score++; // 1�� �÷��ְ�
							}
						}
						base[2] = true; // 3��Ÿ ������ 3��� ����
					}else { // Ȩ��
						for(int b=2; b>=0; b--) {
							if(base[b]) {
								base[b] = false; // 1, 2, 3�簡 Ȩ���� ��
								score++; // 1�� �÷��ְ�
							}
						}
						score++; // 0�翡 �ִ� ��� Ȩ��
					}
					if(outCnt == 3) {
						pIdx = j+1; // ���� Ÿ�� �����ϱ�
						if(pIdx == 9) pIdx = 0;
						break inning;
					}
				}
				pIdx = 0; // ���� �ݺ��� ���� �ƿ��� ���°��?
			}
		}
		
		return score;
	}
	
}
