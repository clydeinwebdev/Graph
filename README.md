# Graph
DSTA - Graph (BFS, DFS)

##DFS - Pseudocode

```{r, eval = FALSE}
  DFS-A(G,s)
  for all v in V[G] do
    visited[v] := false
  end for
  S := EmptyStack
  Push(S,s)
  while not Empty(S) do
    u := Pop(S)
    if not visited[u] then
      visted[u] := true
      for all w in Adj[u] do
        if not visited[w] then
          Push(S,w)
        end if
      end for
    end if
  end while
```

##DFS - Java

```java
dfs(G, start){
  boolean visited[] = new boolean[V];
  Stack<Integer> S = new Stack<Integer>();
  S.push(start);
  while(!S.isEmpty()){
      int u = (int)S.pop();
      System.out.print(vertices[u]);
      if(!visited[u]){
          visited[u] = true;
          for(int w = 0;w<V;w++){
              if(G[u][w]==1 && !visited[w]){
                  S.push(w);                            
              }
          }
      }
  }
}
```
