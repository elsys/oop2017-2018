#include <iostream>
using namespace std;


int main() {
    int answer;
    
    cin >> answer;
    
    if(cin.good()) {
        cout << "The answer is " << answer << "!" << endl;
    } else {
        cout << "Something went wrong!!!!" << endl;
    }
    return 0;
}

