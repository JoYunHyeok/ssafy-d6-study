import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18808_��ƼĿ���̱� {
	static int N,M,K;
	static int[][] sticker, map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // ���� 
		M = Integer.parseInt(st.nextToken()); // ����
		K = Integer.parseInt(st.nextToken()); // ��ƼĿ�� ����
		
		map = new int[N][M];
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken()); // ��
			int C = Integer.parseInt(st.nextToken()); // ��
			sticker = new int[R][C];

			for(int r=0; r<R; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<C; c++) {
					sticker[r][c] = Integer.parseInt(st.nextToken());
				}
			}// ��ƼĿ �Է¹ޱ�
			
			for(int i=0; i<4; i++) {
				if(check(sticker)) { // �󱸰��� �ִ��� üũ�ϰ� ���̱� ���� ����
					break; // �ٿ����� ���� ��ƼĿ�� �Ѿ��
				}
				rotate(sticker); // ���ٿ����� 90�� ȸ��
			}
			
		}
		count(); // ��ƼĿ�� ������ ���� ī��Ʈ
	}
	
	static boolean check(int[][] sticker) {

		for(int i=0; i<N-sticker.length+1; i++) { // ��ƼĿ �ε��� i����
			for(int j=0; j<M-sticker[0].length+1; j++) { // ��ƼĿ �ε��� j����
				boolean attachFlag = true;
				for(int si=0; si<sticker.length; si++) {
					for(int sj=0; sj<sticker[0].length; sj++) {
						if(sticker[si][sj] == 1 && map[i+si][j+sj] == 1) {
							attachFlag = false;
						}
					}
				}
				
				if(attachFlag) { // ��ƼĿ ���̱�
					for(int si=0; si<sticker.length; si++) {
						for(int sj=0; sj<sticker[0].length; sj++) {
							if(map[i+si][j+sj] == 1) continue;
							map[i+si][j+sj] = sticker[si][sj];
						}
					}
					
					return true; // ��ƼĿ�� �ٿ���.
				}
				
			}
		}
		
		return false; // ���ٿ���.
	}
	
	
	static void rotate(int[][] sticker2) { // 90�� ������
		sticker = new int[sticker2[0].length][sticker2.length];
		for(int i=0; i<sticker2[0].length; i++) {
			for(int j=sticker2.length-1; j>=0; j--) {
				sticker[i][sticker2.length-1-j] = sticker2[j][i];
			}
		}
		
	}
	
	static void count() { // ��ƼĿ ��ĭ��ĭ ����
		int ans=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) ans++;
			}
		}
		System.out.println(ans);
	}
}
