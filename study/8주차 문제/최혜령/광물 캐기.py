def solution(picks, minerals):
    dia_pick, iron_pick, stone_pick = picks
    pick_tireness = {"dia": dia_pick, "iron": iron_pick, "stone": stone_pick}
    pick_cost = {
        "dia": {"diamond": 1, "iron": 1, "stone": 1},
        "iron": {"diamond": 5, "iron": 1, "stone": 1},
        "stone": {"diamond": 25, "iron": 5, "stone": 1}
    }
    
    def calculate(all_minerals):
        answer = 0
        #stone 기준으로 하여 가장 비싼 순서대로 나열 (재정렬)
        calculated = {}
        for minerals in all_minerals:
            tmp = minerals["diamond"]*25 + minerals["iron"] * 5 + minerals["stone"]
            if tmp not in calculated.keys():
                calculated[tmp] = [minerals]
            else:
                calculated[tmp].append(minerals)
        expensive = dict(sorted(calculated.items(), reverse=True))

        for key, value in expensive.items():
            for elem in value:
                found = False
                for pick in ["dia", "iron", "stone"]:
                    if pick_tireness[pick] > 0 and found == False:
                        cost = (pick_cost[pick]["diamond"] * elem["diamond"] + pick_cost[pick]["iron"] * elem["iron"] + pick_cost[pick]["stone"] * elem["stone"])
                        pick_tireness[pick] -= 1
                        answer += cost
                        found = True
        return answer
    
    def identify(all_minerals):
        # 곡괭이 갯수가 광물 세트 갯수보다 적을 경우, 부족한 세트만큼은 계산식에서 제외되어야 함.
        if len(all_minerals) <= sum(picks):
            return calculate(all_minerals)
        else:
            while sum(picks) < len(all_minerals):
                all_minerals.pop(-1)
            return calculate(all_minerals)
                        

    all_minerals = []
    for i in range(0, len(minerals), 5):
        mineral_count = {"diamond": 0, "iron": 0, "stone": 0}

        for j in range(i, min(i + 5, len(minerals))):
            mineral_count[minerals[j]] += 1
        
        all_minerals.append(mineral_count)
        
    return identify(all_minerals)
