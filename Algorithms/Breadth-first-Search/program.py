from collections import deque

def bfs_shortest_path(graph, start, goal):
    # Track the path to each node using a queue of paths
    queue = deque([[start]])
    visited = set([start])
    
    while queue:
        # Get the first path from the queue
        path = queue.popleft()
        current_node = path[-1]
        
        # Condition check for goal state
        if current_node == goal:
            return path
            
        # Explore adjacent neighbors
        for neighbor in graph.get(current_node, []):
            if neighbor not in visited:
                visited.add(neighbor)
                # Construct new path and append to queue
                new_path = list(path)
                new_path.append(neighbor)
                queue.append(new_path)
                
    return None # Return None if no path exists

# Example graph representation (Adjacency List)
ai_graph = {
    'A': ['B', 'C'],
    'B': ['D', 'E'],
    'C': ['F'],
    'D': [],
    'E': ['F'],
    'F': []
}

# Find path from A to F
print("Shortest Path:", bfs_shortest_path(ai_graph, 'A', 'F'))
