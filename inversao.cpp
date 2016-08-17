#include <cstdio>
#include <map>
#include <set>
#include <queue>
#include <vector>

using namespace std;

const int MAX = 100000;

int visitado[MAX];

struct estado {
    int valor;
    int distancia;
    int nivel;
};

int invert_number(int n)
{
    int k = 0;

    while( n ) {
        k *= 10;
        k += n % 10;
        n /= 10;
    }

    return k;
}


int astar(int inicial, int fim)
{

    for( int i = 0; i < MAX; ++i )
        visitado[i] = 0;
    map<int, int> m;
    queue<struct estado> q;
    visitado[inicial] = 1;
    m[inicial] = inicial;
    struct estado est;
    est.nivel = 0;
    est.valor = inicial;
    q.push(est);

    struct estado u;
    while( !q.empty() ) {
        u = q.front();
        q.pop();

        if( u.valor == fim )
            break;

        struct estado pp;
        pp.valor = invert_number(u.valor);
        pp.nivel = u.nivel+1;
        if( !visitado[pp.valor] ) {
            q.push(pp);
            visitado[pp.valor] = 1;
        }

        pp.valor = u.valor+1;
        if( !visitado[pp.valor] ) {
            q.push(pp);
            visitado[pp.valor] = 1;
        }
    }

    return u.nivel;
}


int main()
{
    int n = 0;
    int a, b;


    while( scanf("%d%d", &a, &b) != EOF ) {
        printf("%d\n", astar(a, b));

    }


    return 0;
}

