#include <vector>
#include <iostream>
#include <list>
#include <algorithm>
#include <cmath>
const int MAX = 50005;

using namespace std;

typedef struct vertice {
    int u, p, gp;
    bool visited;
    list<int> adj;
    vector<int> pos;
} vertice;

int carta, max_altura;

void gran_p(vector<vertice>& grafo, int u, int p, int seg)
{
    grafo[u].gp = p;
    if( !(grafo[u].u % seg) )
        p = u;

    for( list<int>::iterator it = grafo[u].adj.begin(); it != grafo[u].adj.end(); ++it ) {
        if( !grafo[*it].gp )
            gran_p(grafo, *it, p, seg);
    }

}

void dfs(vector<vertice>& grafo, int i) {

    grafo[i].visited = true;
    for( list<int>::iterator it = grafo[i].adj.begin(); it != grafo[i].adj.end(); ++it )
        if( !grafo[*it].visited ) {
            grafo[*it].u = grafo[i].u+1;
            max_altura = max(max_altura, grafo[*it].u);
            grafo[*it].p = i;
            dfs(grafo, *it);
        }
}


void visita(vector<vertice>& grafo, int inicial) {
    for( int i = 0; i < grafo.size(); ++i ) {
        grafo[i].gp = grafo[i].u = grafo[i].p = 0;
        grafo[i].visited = false;
    }

    grafo[inicial].u = 0;
    grafo[inicial].p = inicial;
    dfs(grafo, inicial);
}

// precisa usar esses "atalhos", ou seja, pular mais de um nível para passar em tempo < 1s
int LCA(vector<vertice>& grafo, int u, int v)
{
    while( grafo[u].gp != grafo[v].gp )
        if( grafo[u].u > grafo[v].u )
            u = grafo[u].gp;
        else
            v = grafo[v].gp;

    while( u != v )
        if( grafo[u].u > grafo[v].u )
            u = grafo[u].p;
        else
            v = grafo[v].p;
    return u;
}


int main()
{
    int u,v,n;

    while( cin >> n ) {

        vector<vertice> grafo(n+1, vertice());
        for( int i = 1; i <= n; ++i ) {
            cin >> carta;
            grafo[carta].pos.push_back(i);
        }

        for( int i = 1; i < n; ++i ) {
            cin >> u >> v;
            grafo[u].adj.push_back(v);
            grafo[v].adj.push_back(u);
        }

        max_altura = 0;
        visita(grafo, 1);
        int seg = sqrt(max_altura);
        int q = 0;
        gran_p(grafo, 1, 1, seg);


        for( int i = 1; i <= n/2; ++i ) {
            int u = grafo[i].pos[0];
            int v = grafo[i].pos[1];
            int vlca = LCA(grafo, u, v);
            q += (grafo[u].u-grafo[vlca].u)+(grafo[v].u-grafo[vlca].u); // distancia entre u -> (X) + (X) -> v == u -> v


        }

        cout << q << endl;
    }

    return 0;
}
