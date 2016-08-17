#include <iostream>
#include <cstdio>
#include <vector>

using namespace std;

int main()
{
    int n = 0, r = 0;

    while( scanf("%d%d", &n, &r) != EOF ) {
        vector<int> m(n, 0);
        for( int i = 0; i < r; ++i ) {
            int temp = 0;
            scanf("%d", &temp);
            m[temp-1] = 1;
        }
        bool f = false;
        for( int i = 0; i < n; ++i )
            if( !m[i] ) {
                printf("%d ", (i+1));
                f = true;
            }

        if( !f )
            printf("*");
         printf("\n");
    }


    return 0;
}


