def solution(numbers):
    answer = []
    
    for n in numbers:
        if n % 2 == 0:  # 짝수인 경우, 바로 다음 숫자가 조건을 만족
            answer.append(n + 1)
        else:
            n_beat = bin(n)[2:]  # 이진수 문자열로 변환
            if '0' not in n_beat:  # '0'이 없는 경우: 가장 앞에 '10'을 붙임
                n_beat = '10' + n_beat[1:]
            else:  # '0'이 있는 경우: 가장 오른쪽의 '0'을 '1'로 바꿈
                index = n_beat.rfind('0')  # 가장 오른쪽의 '0' 위치 찾기
                n_beat = n_beat[:index] + '10' + n_beat[index + 2:]
            answer.append(int(n_beat, 2))  # 이진수를 정수로 변환하여 결과에 추가
    
    return answer
