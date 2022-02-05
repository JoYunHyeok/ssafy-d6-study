class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCnt = 0;
        int equalCnt = 0;
        
        for(int i=0; i<6; i++){
            if(lottos[i] == 0) zeroCnt+=1; // 0 ī��Ʈ
            for(int j=0; j<6; j++){
                if(lottos[i] == win_nums[j]) equalCnt += 1; // �� �ζ� �� �� ���� ���
            }
        }
        
        int max = 7 - (equalCnt + zeroCnt);
        int min = 7 - equalCnt;
        if(max==7) max = 6; // lottos�迭�� 0�� ���� �� Ʋ�� ���
        if(min==7) min = 6; // lottos�迭�� �� 0�� ���
  
        return new int[] {max, min};
    }
}
