#include<stdio.h>
int visited_all;
int n = 4;
int dist[400][400];//= { { 0, 20, 42, 25 }, { 20, 0, 30, 34 }, { 42, 30, 0, 10 }, { 25, 34, 10, 0 } };


int tsp(int currentVisited, int currentCity) {
    if(currentVisited == visited_all) {
        return dist[currentCity][0];
    }
    int minimumCost = (int) 1e6;
    for (int city = 0; city < n; city++)
    {
        if(((1 << city) & currentVisited) == 0) {
            int temp = tsp(currentVisited | (1 << city), city) + dist[currentCity][city];
            minimumCost = temp < minimumCost? temp: minimumCost;
        }
    }
    
    return minimumCost;
}

int main() {

    printf("Enter Size of matrix: ");
    scanf("%d",  &n);

    printf("Enter the distance Matrix:\n");
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            scanf("%d", &dist[i][j]);
        }
        
    }
    
    visited_all = (1 << n) - 1;


    int ans = tsp(1, 0);
    printf("optimal Cost: %d\n", ans);

    return 0;
}
