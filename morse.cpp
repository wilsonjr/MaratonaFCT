#include <vector>
#include <string>
#include <iostream>
#include <sstream>
#include <cstdlib>

using namespace std;

#define SSTR( x ) static_cast< std::ostringstream & >( \
        ( std::ostringstream() << std::dec << x ) ).str()

int map_to_int(char c)
{
	switch( c ) {
		case '.':
			return 1;
		case '-':
			return 5;
		case ':':
			return 2;
		case '=':
			return 10;
		case ' ':
			return 0;

	}

	return 0;
}

int main()
{
	int n;
	string expr;
	vector<string> lExp;
	int valor = 0;

	cin >> n;
	cin.get();
	getline(cin, expr);

	int number = 0;
	for( int i = 0; i < expr.size(); ++i ) {
		if( expr[i] == '+' ) {
			lExp.push_back(SSTR(number));

//			cout << "adicionando " << number << endl;;
			number = 0;			
		} else if( expr[i] == '*' ) {
			if( !number ) {
				number = atoi(lExp[lExp.size()-1].c_str());
				lExp.erase(lExp.begin()+(lExp.size()-1));
			}

			int j = i+1;
			int number2 = 0;

			for( ; j < expr.size() && (expr[j] != '+' && expr[j] != '*'); ++j )
				number2 += map_to_int(expr[j]);
		
			int mult = number2*number;
//			cout << "adicionando mult: " << mult << ", " << number2 << "*" << number << endl;
			lExp.push_back(SSTR(number2*number));
			i = j-1;
			number = 0;
		} else 
			number += map_to_int(expr[i]);
	}
	if( number ) {
//		cout << "adicionando " << number << endl;
		lExp.push_back(SSTR(number));
	}

	int soma = 0;
	for( int i = 0; i < lExp.size(); ++i ) {
//		cout << lExp[i] << " ";
		soma += atoi(lExp[i].c_str());
	}
	cout << soma << endl;




	return 0;
}