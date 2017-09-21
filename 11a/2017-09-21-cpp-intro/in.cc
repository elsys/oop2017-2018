#include <iostream>
using namespace std;

int main() {

	int ans=-1;
	
	cin >> ans;
	
	if(cin.good()) {
		cout << "The answer is " << ans << "!" << endl;
	} else {
		cout << "Something went wrong!!" << endl;
	}
	return 0;
}

