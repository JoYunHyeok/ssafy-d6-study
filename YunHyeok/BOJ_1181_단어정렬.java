package ���ڿ�;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1181_�ܾ����� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String[] arr = new String[n];
	
		for(int i=0; i<n; i++) {
			arr[i] = sc.next();
		}
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2); // �������� ������ ��������
				}
				return o1.length()-o2.length(); // �������� ������ ��������
			}
			
		});
		
		for(int i=0; i<n; i++) {
			if(i+1<n && arr[i].equals(arr[i+1])) continue;
			System.out.println(arr[i]);
		}
	}

}
