#include <iostream>

using namespace std;

int main()
{
    int a = 0, b = 0, c = 0;

    while( (cin >> a >> b >> c) && !cin.eof() ) {

        if( a == b && a == c )
            cout << '*' << endl;
        else {
            if( a == c )
                cout << 'B' << endl;
            else if( a == b )
                cout << 'C' << endl;
            else
                cout << 'A' << endl;
        }

    }


    return 0;
}
