#include <iostream>
#include <cstdio>

using namespace std;

int main()
{
    int n = 0;
    int vec[5005];

    scanf("%d", &n);
    int ini_zero = 0;
    bool um = false;

    for( int i = 0; i < n; ++i ) {

        scanf("%d", &vec[i]);
        if( vec[i] )
            um = true;
        if( !vec[i] && !um )
            ini_zero++;
    }
    int cercas = 0, qtd = 0;

    for( int i = ini_zero; i < n; ++i ) {
        if( !vec[i] ) {
            cercas++;

        } else
            cercas = 0;
        if( cercas >= 2 ) {
                vec[i] = 2;
            qtd++;
            cercas  = 0;
        }
    }

    for( int i = 0; i < ini_zero; ++i ) {
        cercas++;
        if( cercas >= 2 ) {
                vec[i] = 2;
            qtd++;
            cercas  = 0;
        }
    }
    if( n > 2 && !vec[0] && !vec[n-1] )
        qtd++;
    printf("%d\n", qtd);
    


    return 0;
}


