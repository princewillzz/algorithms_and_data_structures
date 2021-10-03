#include<stdio.h>
#include<stdlib.h>

const int INF = (int)1e8;

struct Edge {
    int src, dest, weight;
};

struct Graph {
    int V, E;
 
    struct Edge* edge;
};

struct Graph* createGraph(int V, int E)
{
    printf("%lu %lu\n", sizeof(struct Graph), sizeof(struct Edge));

    int size = sizeof(struct Graph);
    struct Graph* graph = (struct Graph*) malloc(size + 10000);
    graph->V = V;
    graph->E = E;

    size = sizeof(struct Edge);
    graph->edge = (struct Edge*) malloc(size+10000);
    return graph;
}

void BellmanFord(struct Graph* graph, int src, int dest) {
 printf("\n\n");
    int verticesLength = graph->V;
    int dist[verticesLength];

    for (int i = 0; i < verticesLength; i++)
    {
        dist[i] = INF;
    }dist[src] = 0;

    int parent[verticesLength];
    parent[src] = -1;

    int edgesLength = graph->E;
    for (int i = 0; i < verticesLength; i++)
    {
        for (int edgeIndex = 0; edgeIndex < edgesLength; edgeIndex++)
        {
                
            int u = graph->edge[edgeIndex].src;
            int v = graph->edge[edgeIndex].dest;
            int weight = graph->edge[edgeIndex].weight;

            // trying to relax edges
            if( dist[u] != INF && dist[u] + weight < dist[v]) {
                int beforeRelaxWeight = dist[v];
                dist[v] = dist[u] + weight;

                // update parent
                parent[v] = u;

                beforeRelaxWeight != INF? printf("Relaxing Edges source(%d) --- dest(%d) from weight %d to %d\n", u, v, beforeRelaxWeight, dist[v])
                : printf("Relaxing Edges source(%d) --- dest(%d) from weight INF to %d\n", u, v, dist[v]);
            }
        }
        
    }
    
    printf("\n\n");
    // Printing distance between each and source
    for (int i = 0; i < verticesLength; i++)
    {
        printf("Distance form %d -> %d == %d\n", src, i, dist[i]);
        printf("parent of %d is %d\n", i, parent[i]);
    }

    printf("\n\npath==> \n");
    while (dest != -1)
    {
        printf("%d <--- ", dest);
        dest = parent[dest];
    }+
    printf("\n");
    
    

}




int main() {
     int V = 5;
    int E = 8;
    

    printf("Enter the number of Vertices: ");
    scanf("%d", &V);
    printf("Enter the Number of Edges: ");
    scanf("%d", &E);

    struct Graph* graph = createGraph(V, E);
    for(int i = 0; i < E; i++)
    {
        printf("Enter Source, destination and weight (space separated): ");
        int u, v, w;
        scanf("%d%d%d", &u, &v, &w);

        graph->edge[i].src = u;
        graph->edge[i].dest = v;
        graph->edge[i].weight = w;
        
    }

    int src, dest;

    printf("Enter Source and Destination whose path you want to see: ");
    scanf("%d%d", &src, &dest);
 
    
 
    BellmanFord(graph,src, dest);
 
    return 0;
}

// 0 1 5
// 0 2 1
// 1 3 3
// 1 0 2
// 2 3 6
// 3 0 -1