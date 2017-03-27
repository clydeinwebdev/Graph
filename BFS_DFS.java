/*
Sample Input
2
8 9 A
A B
A D
A G
B E
B F
C H
C F
E G
H C
8 9 B
A B
A D
A G
B E
B F
C H
C F
E G
H C

Sample Output
A B E G F C H D 
A B D G E F C H 
B A D G E F C H 
B A E F D G C H 

*/

package Problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BFS_DFS {
    public static void main(String [] args)throws FileNotFoundException{
        Scanner get = new Scanner(new File("A.in"));
        String[] vertices = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        int counter = get.nextInt();        
        while(counter-->0){            
            int V = get.nextInt();
            int E = get.nextInt();
            int start = getIndex(get.next(),vertices);
           
            int[][]G = new int[V][V];
            while(E-->0){
                int v1 = getIndex(get.next(),vertices);
                int v2 = getIndex(get.next(),vertices);
                G[v1][v2]=1;
                G[v2][v1]=1;                
            }
                        
            //displayAdjacencyMatrix(V,G);
            
            //DFS Traversal
            dfs(G,start,V,vertices);         
            //BFS Traversal
            bfs(G,start,V,vertices);
        }
    }
 
    //This method search the letter inside vertices array and returns the index
    public static int getIndex(String letter, String[] vertices){
        int index = 0;
        for(int i=0;i<vertices.length;i++){
            if(vertices[i].equals(letter)){
                index = i;
                break;
            }
        }
        return index;
    }
    //This method display the adjacency matrix representation of the Graph
    public static void displayAdjacencyMatrix(int V, int[][]G){
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                System.out.print(G[i][j] + " ");
            }
            System.out.println();
        }
    }
    //Depth First Search implements Stack ADT
    public static void dfs(int[][] G, int start, int V, String[] vertices){
        boolean[] visited = new boolean[V];
        Stack stack = new Stack();
        int vertex = start;
        stack.push(vertex);
        visited[vertex] = true;
        System.out.print(vertices[vertex]+" ");            
        while(!stack.isEmpty()){
            vertex = (int)stack.peek();
            boolean isFound = false;
            for(int i=0;i<V;i++){
                if(G[vertex][i]==1 && !visited[i]){
                    isFound = true;
                    stack.push(i);
                    visited[i] = true;
                    System.out.print(vertices[i]+" ");
                    break;
                }
            }
            if(!isFound){
                stack.pop();
            }
        }
        System.out.println("");
    }
    
    public static void bfs(int[][] G, int start, int V, String[] vertices){
        boolean[] visited = new boolean[V];            
        int cwv = start;
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.offer(cwv);
        visited[start] = true;
        while(!Q.isEmpty()){
            cwv = Q.poll();
            System.out.print(vertices[cwv]+" ");
            for(int i=0;i<V;i++){
                if(G[cwv][i]==1 && !visited[i]){
                    Q.offer(i);
                    visited[i]=true;
                }
            }                
        }
        System.out.println("");
    }
}
