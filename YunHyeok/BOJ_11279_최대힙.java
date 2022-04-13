import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279_�ִ��� {
	static int N;
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //�ִ�������
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {//�Է¹��� ���� 0�̶�� 
				System.out.println(maxHeap.isEmpty() ? 0 : maxHeap.poll());
			}else maxHeap.add(num); // �Է¹��� ���� 0�� �ƴ϶�� add
		}
	}
}
