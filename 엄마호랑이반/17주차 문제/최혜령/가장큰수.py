def solution(numbers):
    # 모든 숫자를 문자열로 변환
    numbers = [str(n) for n in numbers]
    
    # 정렬의 핵심: 각 숫자를 반복해서 이어붙인 형태로 비교
    # 예: "3"과 "30"을 비교할 때 "333..."과 "303030..." 형태로 비교
    # 이렇게 하면 길이가 다른 숫자 문자열도 공정하게 비교 가능
    # 최대 숫자 길이는 1000이므로 3번 반복하면 충분함
    numbers.sort(key=lambda x: x*3, reverse=True)
    print(numbers)
    # 모든 숫자가 0인 경우 예외 처리
    if numbers[0] == '0':
        return '0'
    
    # 정렬된 숫자들을 이어붙여 결과 반환
    return ''.join(numbers)
