#include <cstdio>
#include <cmath>
#include <algorithm>

using namespace std;


int main()
{
 	long gols = 0, jogos = 0, pontos = 0;
	int saldo[100001], a, b;

	while( ~scanf("%ld%ld", &jogos, &gols) ) {
		for( long i = 0; i < jogos; ++i ) {
			scanf("%d%d", &a, &b);
			saldo[i] = a-b;
		}

		pontos = 0;
		stable_sort(saldo, saldo+jogos);
		for( long i = jogos-1; i >= 0; --i ) {
			if( saldo[i] > 0 )
				pontos += 3;
			else if( saldo[i] == 0 && gols > 0 ) {
				pontos += 3;
				gols--;
			} else if( saldo[i] < 0 && (gols-abs(saldo[i]-1)) >= 0 ) {
				pontos += 3;
				gols -= abs(saldo[i]-1);
			} else if( saldo[i] < 0 && !(gols-abs(saldo[i])) ) {
				gols -= abs(saldo[i]);
				pontos++;
			} else if( saldo[i] == 0 )
				pontos++;

		}
		printf("%ld\n", pontos);
	}

	return 0;
}
