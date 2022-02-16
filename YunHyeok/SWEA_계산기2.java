import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_����2 {
	static int N;
	static Stack<Character> op = new Stack<>(); // ������ ��� ����
	static Stack<Integer>  opNum = new Stack<>(); // �ǿ����� ��� ����
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc=1; tc<=10; tc++) {
			N = Integer.parseInt(br.readLine());
			String preOreder = br.readLine();
			String postOrder = "";
			
			for(int i=0; i<preOreder.length(); i++) {
				char ch = preOreder.charAt(i);
				if(ch - '0' > 0 && ch - '0' < 10) { // ���� �ֱ�
					postOrder += ch;
				}else { // ������ �ֱ�
					if(ch=='+') { // ���ϱ� �� ���, op���ÿ� *�� �ִ��� Ȯ���ؾ� �Ѵ�.
						while(!op.isEmpty()) postOrder += op.pop();
						op.push(ch);
					}else op.push(ch);// ���ϱ��� ���� �׳� op���ÿ� �ִ´�.
				}
			}// ����ǥ��� ����� ����
			while(!op.isEmpty()) postOrder += op.pop(); //�����ִ� ������ �� �ֱ�
			
			for(int i=0; i<postOrder.length(); i++) {
				char ch = postOrder.charAt(i);
				if(ch - '0' > 0 && ch - '0' < 10) { // ������ ��� opNum���ÿ� �ִ´�.
					opNum.push(ch-'0');
				}else { // �������� ���
					if(ch == '+') opNum.push(opNum.pop() + opNum.pop());
					else opNum.push(opNum.pop() * opNum.pop());
				}
			}
			
			System.out.println("#"+tc+" "+opNum.pop());
			
		}//tc����
		
	}

}
