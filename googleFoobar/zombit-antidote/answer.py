
def answer(meetings):
    visited = [False] * len(meetings)
    possibleMeetings = []
    maxMettingsAttened = 0
    
    for idx, val in enumerate(meetings):
        if visited[idx] != True:
            visited[idx] = True
            possibleMeetings = [val]
            for j, m2 in enumerate(meetings):
                if m2 != val:
                    confilict = False
                    for p in possibleMeetings:
                        if hasOverlap(p, m2):
                            confilict = True
                            break
                    if confilict == False:
                        visited[j] = True
                        possibleMeetings.append(m2)
            if len(possibleMeetings) > maxMettingsAttened:
                maxMettingsAttened = len(possibleMeetings)
    return maxMettingsAttened


def hasOverlap(m1, m2):
    return False if (m2[1] <= m1[0] or m2[0] >= m1[1]) else True

if __name__ == '__main__':

    #meetings = [[1,2]]
    #result = answer(meetings)
    #print result

    #meetings = [[1, 20], [19, 21], [20, 30]]
    #result = answer(meetings)
    #print result

    #meetings = [[1, 2], [2,3], [3,4]]
    #result = answer(meetings)
    #print result

    #meetings = [[0, 1], [1, 2], [2, 3], [3, 5], [4, 5]] 
    #result = answer(meetings)
    #print result

    #meetings = [[0, 1000000], [42, 43], [0, 1000000], [42, 43]]
    #result = answer(meetings)
    #print result

    #meetings = [[1, 10], [9, 12], [9, 13]]
    #result = answer(meetings)
    #print result
    
    #meetings = [[1, 20], [19, 21], [20, 30], [22, 23], [24, 25]]
    #result = answer(meetings)
    #print result
    
    #meetings = [[1,3], [2,4], [3, 4], [4,100], [1,2], [0, 1]]
    #result = answer(meetings)
    #print result

    meetings = [[1, 8],[7, 11],[8, 9],[10,20], [21,30], [19,22], [31, 40]]
    result = answer(meetings)
    print result

    meetings = [[33, 48], [4, 41], [1, 42], [15, 47], [25, 44], [26, 35], [11, 36]]
    result = answer(meetings)
    print result

    meetings = [[27, 36], [17, 42], [6, 10], [28, 47], [25, 42], [38, 45], [15, 41], [3, 47]]
    result = answer(meetings)
    print result
