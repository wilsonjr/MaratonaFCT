#include <cstdio>
#include <cstdlib>
#include <limits>
#include <list>
#include <vector>
#include <queue>

using namespace std;

#define MAX 200001

typedef unsigned long long _uint;

typedef struct prox
{
    long v;
    _uint p;
    prox(int vv, _uint pp): v(vv), p(pp) {}
} prox;

typedef struct
{
    _uint ordem;
    long id;
    int visitado;
    list<prox> adj;
} vertice;

struct comp
{
    bool operator()(const vertice& a, const vertice& b)
    {
        return a.ordem > b.ordem;
    }
};

vertice grafo[MAX];

void init_grafo(int n)
{
    for( int i = 0; i < n; ++i )
        grafo[i].adj.clear();
}

int prim(int n)
{
    for( int i = 0; i < n; ++i )
    {
        grafo[i].visitado = 0;
        grafo[i].ordem = numeric_limits<_uint>::max();
        grafo[i].id = i;
    }

    grafo[0].ordem = 0;
    _uint total = 0;
    priority_queue<vertice, vector<vertice>, comp> q;
    q.push(grafo[0]);

    while( !q.empty() )
    {
        vertice u = q.top();
        q.pop();
        if( !grafo[u.id].visitado )
            total += grafo[u.id].ordem;


        grafo[u.id].visitado = 1;

        list<prox>::iterator it = grafo[u.id].adj.begin();
        for( ; it != grafo[u.id].adj.end(); ++it )
        {
            if( !grafo[it->v].visitado && grafo[it->v].ordem > it->p )
            {
                grafo[it->v].ordem = it->p;
                q.push(grafo[it->v]);
            }
        }
    }
    return total;
}

int main()
{
    long m, n;
    while( ~scanf("%ld%ld", &m, &n) )
    {
        if( !m && !n )
            break;
        init_grafo(m);
        _uint total = 0;
        for( long i = 0; i < n; ++i )
        {
            long a, b;
            _uint c;
            scanf("%ld%ld%lld", &a, &b, &c);
            grafo[a].adj.push_back(prox(b, c));
            grafo[b].adj.push_back(prox(a, c));
            total += c;
        }

        _uint k = prim(m);
        printf("%lld\n",total-k);
    }


    return 0;
}
