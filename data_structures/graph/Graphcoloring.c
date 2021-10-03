#include<stdio.h>
#include <unistd.h>

int V, noOfWays = 0;
int graph[1000][1000];

int canbeColored(int graph[V][V], int nodeColors[V], int curretNode, int wantToColorWith) {

    for (int i = 0; i < V; i++)
    {
        if(i != curretNode && graph[i][curretNode] == 1 && nodeColors[i] == wantToColorWith) {
            return 0;
        }
    }

    return 1;
}

int solve(int graph[V][V], int currentNode, int mcolors, int nodeColors[mcolors]) {

    if(currentNode == V) {
        noOfWays++;
        printf("\n\n\n\nSolution %d\n=============================================================\n", noOfWays);
        for (int i = 0; i < V; i++)
        {
            printf("Color of Node: %d is =>  %d\n", i, nodeColors[i]);
        }
        //  sleep();
        
        return 1;
    }

    for (int color = 1; color <= mcolors; color++)
    {
        if(canbeColored(graph, nodeColors, currentNode, color)){
            nodeColors[currentNode] = color;

            // if(solve(graph, currentNode+1, mcolors, nodeColors)) {
            //     return 1;
            // }
            solve(graph, currentNode+1, mcolors, nodeColors);

            nodeColors[currentNode] = 0;
        }
        
    }

    return 0;
}

int main() {


    printf("Enter the number of Vertices: ");
    scanf("%d", &V);
    for (int i = 0; i < V; i++)
    {
        printf("Enter nodes for %d: ", i);
        for (int j = 0; j < V; j++)
        {
            scanf("%d", &graph[i][j]);
        }
    }

    int color;
    printf("Enter the number of Colors: ");
    scanf("%d", &color);
    int nodeColors[color];

    if(solve(graph, 0, color, nodeColors)) {
        printf("Can be colored\n");
    } else {
        printf("Cannot be colored!!\n");
    }

    return 0;
}

// 0 0 1 0 0
// 0 0 0 0 0
// 0 1 0 1 0
// 0 0 0 0 1
// 1 1 0 0 0