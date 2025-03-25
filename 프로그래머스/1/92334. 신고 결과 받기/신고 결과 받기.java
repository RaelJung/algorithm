// 신고 기록 바탕으로 '정지' 사용자 집계
// 동일 신고자에 대해서는 1회만 처리(중복 제거)
// 사용자 별 신고 받은 횟수 필요 -> Map<String, Integer> (이름, 횟수)
// 사용자가 신고한 사람 목록도 필요(알림 발송 용)

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 중복 신고 제거 -> Set
        Map<String, Set<String>> reports = new HashMap<>();
        for(String r : report){
            String[] id = r.split(" "); //0: 신고 한 사람, 1: 신고 당한 사람
            String reporter = id[0];
            String trol = id[1];
            
            // 신고 목록에 추가
            reports.putIfAbsent(trol, new HashSet<>());
            reports.get(trol).add(reporter);    //신고자 목록에 추가(중복 방지를 위해 Set)
        }
        
        //신고 횟수 계산
        Map<String, Integer> reportCnt = new HashMap<>();
        for(String trol : reports.keySet()){
            reportCnt.put(trol, reports.get(trol).size());
        }
        
        //정지 사용자 목록 생성(k개 이상)
        Set<String> banList = new HashSet<>();
        for(String trol: reportCnt.keySet()){
            if(reportCnt.get(trol) >= k){
                banList.add(trol);
            }
        }
        
        //유저에게 전송될 알림 횟수 계산
        Map<String, Integer> mailCnt = new HashMap<>();
        // 0으로 초기화
        for(String id : id_list){
            mailCnt.put(id, 0);
        }
        //밴 목록 보고 세기
        for(String ban : banList){
            for(String reporter : reports.get(ban)){
                mailCnt.put(reporter, mailCnt.get(reporter)+1);
            }
        }
        
        //결과 배열 
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length;i++){
            answer[i] = mailCnt.get(id_list[i]);
        }
        
        return answer;
    }
}