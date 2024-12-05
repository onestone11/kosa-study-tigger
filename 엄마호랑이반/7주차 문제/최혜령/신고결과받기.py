def solution(id_list, report, k):
    ids = {}
    reports = {}
    for elem in id_list:
        ids[elem] = 0
        reports[elem] = []
    
    
    for elem in report:
        reporter, reported = elem.split(" ")
        if reporter not in reports[reported]:
            reports[reported].append(reporter)
    
    for key, value in reports.items():
        if len(value) >= k:
            for elem in value:
                ids[elem] += 1
    
    answer = list(ids.values())
        
    return answer
