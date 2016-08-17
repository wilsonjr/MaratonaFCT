#include <cstdio>
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

const int MAX = 300;

string vet;

inline bool ispossible(int i, int j)
{
    if( i < 0 || j >= (int) vet.size() ) return false;
    if( (vet[i] == 'C' && vet[j] == 'F') || (vet[i] == 'F' && vet[j] == 'C') ) return true;
    if( (vet[i] == 'S' && vet[j] == 'B') || (vet[i] == 'B' && vet[j] == 'S') ) return true;
    return false;
}

int main()
{

    while( cin >> vet ) {
        int contagem = 0;
        while( true ) {
            int maior = 0, k = 0, indMaior = -1;

            for( int i = 1; i < (int)vet.size(); ++i ) {
                int x = i-1;
                int y = i;
                k = 0;

                while( ispossible(x, y) ) {
                    x--; y++; k++;
                }

                if( k > maior ) {
                    indMaior = i;
                    maior = k;
                }
            }
            if( maior ) {
                contagem += maior;
                vet.erase(vet.begin()+(indMaior-maior), vet.begin()+(indMaior+maior));
            } else
                break;

        }
        printf("%d\n", contagem);

    }






    return 0;
}
