import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//������ ���������� �մ��� ���� ��� �����ϴ�. ���� ������������ �մ��� ���ٰ� �����ϰ� �ۼ��߾����ϴ�.
public class BOJ_19238_��ŸƮ�ý� {
	static int N, M, fuel, goal;
	static int[][] map;
	static int[][] goalMap; // �������� ���� ��
	static boolean flag = true;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	static class Point {
		int y, x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static Queue<Point> q = new LinkedList<>();
	static Queue<Point> goalQ = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // ���� ũ��
		M = Integer.parseInt(st.nextToken()); // �°��� ��
		fuel = Integer.parseInt(st.nextToken()); // ������ ��

		map = new int[N][N];
		goalMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // �� �Է� �ޱ�

		st = new StringTokenizer(br.readLine()); // �ý���ġ �Է¹ޱ�
		int ty = Integer.parseInt(st.nextToken()) - 1;
		int tx = Integer.parseInt(st.nextToken()) - 1;
		q.offer(new Point(ty, tx));

		for (int i = 2; i < M + 2; i++) {
			st = new StringTokenizer(br.readLine());
			int py = Integer.parseInt(st.nextToken()) - 1;
			int px = Integer.parseInt(st.nextToken()) - 1; // ���
			int gy = Integer.parseInt(st.nextToken()) - 1;
			int gx = Integer.parseInt(st.nextToken()) - 1; // ������

			map[py][px] = i;
			goalMap[gy][gx] = i;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		} // �� ���
		System.out.println("=================================");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(goalMap[i][j] + " ");
			}
			System.out.println();
		} // ��� ���

		while (flag) {
			if(M==0) {
				System.out.println(fuel);
				break;
			}
			
			
			
			personBfs(); // �¿� ��� ã��
			q = new LinkedList<>(); //�ý� ��� ť �ʱ�ȭ
			
			
			
			
			System.out.println("�ý� �¿� ��#########################################");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			} // �� ���
			System.out.println("�¿� �� ������ ���� ????" + fuel);
			
			
			
			
			goalBfs(); // �¿� ��� ������ ������ �ֱ�
			goalQ = new LinkedList<>(); // ������ ť �ʱ�ȭ
			
			
			
			
			System.out.println("������ ���� ��@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			} // �� ���
			System.out.println("���� �� ������ ���� ????" + fuel);
			System.out.println("������ ���� ������ �� $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(goalMap[i][j] + " ");
				}
				System.out.println();
			} // �� ���
			
			
		}
		if(!flag)
			System.out.println(-1);
	}

	static void personBfs() {// �¿� ��� ã��
		boolean[][] visited = new boolean[N][N];
		int distCnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point point = q.poll();
				visited[point.y][point.x] = true;
				
				if(map[point.y][point.x] >= 2) { // ���ã����
					System.out.println("***" + distCnt);
					goalQ.offer(new Point(point.y, point.x)); 
					goal = map[point.y][point.x]; // ������ ����
					map[point.y][point.x] = 0;//��ĭ�����
					fuel -= distCnt;
					if(fuel < 0) {
						flag = false;
					}
					
					return;
				}
				
				for (int d = 0; d < 4; d++) {
					int y = point.y + dy[d];
					int x = point.x + dx[d];
					if (y >= 0 && y < N && x >= 0 && x < N) {
						if(!visited[y][x] && map[y][x] != 1) {
							q.offer(new Point(y, x));
						}
					}
				}// for d
			}// for size
			distCnt++;
		}//while
		flag = false;
	}

	static void goalBfs() {// �¿� ��� ������ ������ �ֱ�
		boolean[][] visited = new boolean[N][N];
		int distCnt = 0;
		
		while(!goalQ.isEmpty()) {
			int size = goalQ.size();
			for(int s=0; s<size; s++) {
				Point point = goalQ.poll();
				visited[point.y][point.x] = true;
				
				if(goal == goalMap[point.y][point.x]) { // ���ã����
					System.out.println("***" + distCnt);
					q.offer(new Point(point.y, point.x)); 
					goalMap[point.y][point.x] = 0;
					goal = 0; // ������ �ʱ�ȭ
					fuel -= distCnt;
					
					if(fuel < 0) { // ���ᰡ ���������
						flag = false;
					}
					
					fuel += (distCnt*2); // ����ι�����
					M-=1; // ��� �Ѹ� �������� �������ָ� -1
					return;
				}
				
				for(int d=0; d<4; d++) {
					int y = point.y + dy[d];
					int x = point.x + dx[d];
					if(y >=0 && y<N && x>=0 && x<N) {
						if(!visited[y][x] && map[y][x] != 1) {
							goalQ.offer(new Point(y, x));
						}
					}
				} //for d
			} // for size
			distCnt++;
		}//while
		flag = false;
	}
}

//6 3 1
//0 0 0 0 1 0
//0 0 0 0 1 1
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 0 0 0 0
//1 1
//1 1 1 2
//1 2 1 3
//1 3 1 2
