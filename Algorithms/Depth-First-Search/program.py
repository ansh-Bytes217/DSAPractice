def dfs_ai(graph, start, goal):
    # Stack stores tuples of (current_node, path_taken)
    stack = [(start, [start])]
    visited = set()

    while stack:
        current_node, path = stack.pop()

        if current_node == goal:
            return f"Success! Path: {' -> '.join(path)}"

        if current_node not in visited:
            visited.add(current_node)
            
            # Reverse neighbors to maintain a standard left-to-right exploration
            for neighbor in reversed(graph.get(current_node, [])):
                if neighbor not in visited:
                    stack.append((neighbor, path + [neighbor]))
                    
    return "Goal not reachable."

# Example State Space Graph Graph
ai_graph = {
    'A': ['B', 'C'],
    'B': ['D', 'E'],
    'C': ['F'],
    'D': [], 'E': [], 'F': []
}

print(dfs_ai(ai_graph, 'A', 'F'))
