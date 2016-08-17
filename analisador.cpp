#include <iostream>
#include <vector>
#include <string>
#include <cctype>
#include <algorithm>

using namespace std;

int lcs(const string& str1, const string& str2)
{
    vector<vector<int> > v(str1.size()+1, vector<int>(str2.size()+1, 0));

    for( int i = 1; i < v.size(); ++i )
        for( int j = 1; j < v[i].size(); ++j )
            if( str1[i-1] == str2[j-1] )
                v[i][j] = v[i-1][j-1]+1;
            else
                v[i][j] = max(v[i-1][j], v[i][j-1]);


    return v[v.size()-1][v[0].size()-1];
}

int main()
{
    int n;
    string str1, str2;

    while( cin >> n ) {
        cin.get();

        getline(cin, str1);
        getline(cin, str2);

        // remove espaços em branco
        str1.erase(std::remove_if(str1.begin(), str1.end(), ::isspace), str1.end());
        str2.erase(std::remove_if(str2.begin(), str2.end(), ::isspace), str2.end());
        int n_lcs = lcs(str1, str2);
        cout << ((n_lcs >= n) ? "copia" : "nao copia") << endl;

    }



    return 0;
}
