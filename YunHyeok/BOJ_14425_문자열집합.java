import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_14425_���ڿ����� {
	static int N, M, cnt;
	static Map<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			String str = br.readLine(); // N���� ���ڿ� �Է� �ޱ�
			map.put(str, 1); // map�� �־��ֱ�
		}
		
		for(int i=0; i<M; i++) { // M���� ���ڿ� �Է� �ޱ�
			String str = br.readLine();
			if(map.containsKey(str)) cnt++; //N���� ���ڿ��� ������ �Ǹ� cnt++
		}
		
		System.out.println(cnt);
	}

}
