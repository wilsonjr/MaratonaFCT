#include <algorithm>
#include <iostream>
#include <cmath>

using namespace std;

int v[1010];

int main()
{
	int n = 0;

	while( cin >> n ) {
		for( int i = 0; i < n; ++i )
			cin >> v[i];

		sort(v, v+n);

		int dif1 = 0, dif2 = 0;

		for( int i = 1; i < n; i+=2 )
			dif1 += min(abs(v[i]-v[i-1]), 24-abs(v[i]-v[i-1]));

		dif2 += min(abs(v[0]-v[n-1]), 24-abs(v[0]-v[n-1]));
		for( int i = 2; i < n-1; i+=2 )
			dif2 += min(abs(v[i]-v[i-1]), 24-abs(v[i]-v[i-1]));

		cout << min(dif1, dif2) << endl;



	}


	return 0;
}
