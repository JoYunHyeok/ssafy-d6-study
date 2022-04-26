package ���ڿ�;

import java.util.Scanner;


public class BOJ_2607_����Ѵܾ� {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt()-1;
		
		int[] alpha = new int[26];
		String str1 = sc.next();
		int len = str1.length(); // ù��° �Է¹��� ���� ����
		for(int s=0; s<len; s++) {
			alpha[str1.charAt(s)-'A']++;
		}
		
		int ans = 0; // ��� ����
		while(N-- > 0) {
			int[] arr = alpha.clone(); // ���� ����
			String str = sc.next(); // ���� ����
			
			int cnt = 0;
			for(int i=0; i<str.length(); i++) {
				if(arr[str.charAt(i)-'A'] > 0) {
					cnt++;
					arr[str.charAt(i)-'A']--;
				}
			}
			
			int comp = len - str.length();
			if(comp == 0 && (cnt == len || cnt == len-1)) { // ������
				ans++;
			}else if(comp == -1 && cnt == len) { // �ѱ��� ������
				ans++;
			}else if(comp == 1 && cnt == len-1) { // �ѱ��� ������
				ans++;
			}
		}
		System.out.println(ans);

	}

}
