#기능정리
1) camp.nextstep.edu.missionutils.Randoms.pickNumberInRange()를 활용하여 3자리 숫자 생성, 아래 규칙에 어긋날 시 IllegalArgumentException 발생
	1-1) 1~9 사이의 숫자
	1-2) 중복 비허용
2) camp.nextstep.edu.missionutils.Console.readLine()을 통해 입력받은 값과 1)을 비교하여 결과 출력
	2-1) 같은 수가 같은 자리에 있으면 스트라이크 카운트 ++
	2-2) 같은 수가 다른 자리에 있으면 볼 카운트 ++
	2-3) 같은 수가 전혀 없으면 낫싱
3) 게임 상태 체크
	3-1) 2)의 결과값이 3스트라이크인 경우 상태 플래그 false
	3-2) 2)의 결과값이 3스트라이크가 아닌 경우 상태 플래그 true
4) 상태 플래그가 false인 경우 게임 종료 안내, 사용자에게 새 게임을 시작할 것인지 여부를 입력 받음
	4-1) 사용자의 입력값이 1 : 새 게임
	4-2) 사용자의 입력값이 2 : 게임 종료
	
#요구사항
1) JDK 8에서 정상 동작하여야 함
2) camp.nextstep.edu.missionutils package의 Random 및 Scanner API 사용
3) baseball.ApplicationTest의 테스트가 성공해야 함
	3-1) 필요한 경우 테스트 케이스 추가
4) 자바 코드 컨벤션 준수
5) indent depth 1까지 허용
6) stream API 사용 제한, 람다는 허용
7) else 사용 불가
8) 각 함수는 10줄을 넘지 않으며, 한 가지 일만 하도록 구현