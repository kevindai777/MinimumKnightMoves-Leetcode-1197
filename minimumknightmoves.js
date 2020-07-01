//Objective is to, given a knight starting at [0,0] and a coordinate of [x,y],
//to find the minimum number of knight moves to get to that coordinate

let x = 1
let y = 1


//O(n*m) solution that uses BFS, a queue, and a hashset.

let directions = [[-2,-1], [-2,1], [2,-1], [2,1], [1,2], [1,-2], [-1,2], [-1,-2]]
let visited = new Set()
let queue = [[0,0]]
let steps = 0

while (queue.length > 0) {
    //To hold the next queue
    let next = []
    while (queue.length > 0) {
        let curr = queue.pop()
        if (curr[0] == x && curr[1] == y) {
            return steps
        }

        //Try all 8 directions
        for (let [dx,dy] of directions) {
            let nextX = curr[0] + dx 
            let nextY = curr[1] + dy
            
            //Add all previously unvisited nodes to queue
            if (!visited.has(nextX + ',' + nextY)) {
                visited.add(nextX + ',' + nextY)
                next.push([nextX, nextY])
            }
        }
    }
    //Update queue and set
    queue = next 
    steps++
}