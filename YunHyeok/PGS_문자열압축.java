package ���α׷��ӽ�;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PGS_���ڿ����� {
	static String s = "aabbaccc";
	static String s0 = "abcdaaaa";
	static String s1 = "ababcdcdababcdcd";
	static String s2 = "abcabcdede";
	static String s3 = "abcabcabcabcdededededede";
	static String s4 = "xababcdcdababcdcd";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = s;
		int unit = str.length()/2; // ���� ������
		int min = str.length(); // �ּҰ� ����
		
		for(int i=1; i<= unit; i++) {
			StringBuilder list = new StringBuilder();
			int cnt = 1; // ���డ�� ī��Ʈ
			String strA = str.substring(0, i); //a aa aab aabb
			
			for(int j=i; j<=str.length(); j+=i) {
				String strB = ""; // ���� ��� ������ ����
				if(j+i > str.length()) { // #1. ������ �ʰ��ϸ� strB�� ������ ����. 
					strB = str.substring(j, str.length()); 
				}else { // �������� ���
					strB = str.substring(j, j+i); // ��
				}
				
//				System.out.println("j="+j +" " + strB); //#1
				
				if(strA.equals(strB)) { // ���ڿ��� ���� ��� 
					cnt+=1;
				}else { // ���ڿ��� �ٸ� ���, ���� ������ ���� �ô� cnt�� �ٽ� üũ
					if(cnt>1) { // 1�̻��� ���, aa -> 2a �� �ٲ��ش�.
						list.append(cnt + strA);
					}else {
						list.append(strA);
					}
					strA = strB; // ������ ���� ���� strA�� �ֱ�
					cnt=1; // �ʱ�ȭ!!
				}
			}//���� for��
			
			list.append(strA); // #2. �������� sb�� �߰����� �ʴ� ��찡 �ִ�
//			System.out.println(i + "�����϶� ���ڿ� "+list ); //#2 
			min = Math.min(min, list.length());
			
		}// unit for��
		System.out.println(min);
	}

}
