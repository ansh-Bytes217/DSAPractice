//BFS OF A GRAPH
//BREADTH FIRST SEARCH TECHNIQUE
//1 - BASED INDEXING AND 0 - BASED INDEXING

//     1  L1
//    2  6  L2
//  3  4  7 8  L3
//            5     L4
//move level wise
//eg : 1 2 6 3 4 7 8 5

//assuming start - 6
// 6 at level 0
// eg : 6 1 7 8 2 5 3 4

//initial - Queue (configuration)
  //in FIFO fashion

// visited Array
// size  = n;
// keep taking out elements until it gets empty

//Adajcency List - stores the neighbours
//0 - {}
// 1 - {2,6}
//2 - {1,3,4}
//3 - {2}
//4 - {2,5}
//5 - {4,8}
//6 - {1,7,9}
//7 - {6,8}
//8 - {5,7}
//9 - {6}

//iteration
//took out 1 = visit its neighbours i.e {2,6} put in the queue in FIFO fashion and then mark the visited array with 1 on respective elements
// took out 2 = visit neighbours i.e {1,3,4} = 1 is traversed instead go for 3 and 4 put it in queue  = mark in visited as 1
// took out 3 = visited
//took out 4 = visit neigbours i.e {2,5} put 5 in queue and mark as visited
//took out 5 = visit neighbours i,e {4,8} put 8 in queue and mark as visited
//took out 6 = visit neighbours i.e {1,7,9} put 7 and 9 in queue and mark visited
.
.
.
//took out 9 = visited

//bfs traversal = 1 2 6 3 4 7 9 5 8

  
