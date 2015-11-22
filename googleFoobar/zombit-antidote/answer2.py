def answer(meetings):
    I = []
    for i in meetings:
        I.append(Interval(i[0],i[1]))
    O = schedule_unweighted_intervals(I)
    size = len(O)
    return size

class Interval(object):
    def __init__(self, start, finish):
        self.start = int(start)
        self.finish = int(finish)
    def __repr__(self):
        return str((self.start, self.finish))

def schedule_unweighted_intervals(I):
    I.sort(lambda x, y: x.finish - y.finish)
    O = []
    finish = 0
    for i in I:
        if finish <= i.start:
            finish = i.finish
            O.append(i)
    return O

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
