import copy

def answer(population, x, y, strength):
    clonedPopulation = copy.deepcopy(population)
    if x >= len(clonedPopulation) or y >= len(clonedPopulation):
        return clonedPopulation
    visited = []
    infect(clonedPopulation, x, y, strength, visited)
    return clonedPopulation

def infect(population, x, y, strength, visited):
    visited.append((x, y,))
    if population[x][y] <= strength:
        population[x][y] = -1
        if x > 0 and (x-1, y,) not in visited:
            infect(population, x-1, y, strength, visited)
        if x < len(population) - 1 and (x+1, y,) not in visited:
            infect(population, x+1, y, strength, visited)
        if y > 0 and (x, y-1,) not in visited:
            infect(population, x, y - 1, strength, visited)
        if y < len(population[x]) - 1 and (x, y+1,) not in visited:
            infect(population, x, y + 1, strength, visited)
            


if __name__ == '__main__':
    population = [
        [6, 7, 2, 7, 6], 
        [6, 3, 1, 4, 7], 
        [0, 2, 4, 1, 10], 
        [8, 1, 1, 4, 9], 
        [8, 7, 4, 9, 9]
    ]
    x = 2
    y = 1
    strength = 5
    result = answer(population, x, y, strength)
    print result

    population =  [[1, 2, 3], [2, 3, 4], [3, 2, 1]]
    x = 0
    y = 0
    strength = 2
    result = answer(population, x, y, strength)
    print result

