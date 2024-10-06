def solution(bandage, health, attacks):
    #bandage = [시전시간, 초당 회복량, 추가 회복량]
    #health = 최대 체력
    #attacks = [공격시간, 피해량]
    
    t,x,y = bandage[0], bandage[1], bandage[2]
    print("t: {}, x: {}, y: {}".format(t,x,y))
    
    if t < 1 or t > 50 or x > 100 or x < 1 or y <1 or y > 100 or health < 1 or health > 1000 or len(attacks) < 1 or len(attacks) > 100:
        return -1
    
    latest_attack = attacks.pop(0)
    latest_at, latest_dmg = latest_attack[0], latest_attack[1]
    hp = health - latest_dmg
    if hp <= 0:
            return -1
    print("first hp: {}".format(hp))
    
    for attack in attacks:
        at, dmg = attack[0], attack[1]
        tmp = at - latest_at - 1
        hp += tmp*x
        if tmp >= t:
            hp += (tmp//t)*y
        if hp > health:
            hp = health
        hp -= dmg
        
        if hp <= 0:
            return -1
        
        latest_at = at
    
    return hp
