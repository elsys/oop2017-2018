#include<vector>
#include<iostream>

using namespace std;


int main() {
	vector<int> vi;
	
	cout << "vi size=" << vi.size() << endl;
	cout << "vi cap =" << vi.capacity() << endl;
	cout << "vi empty=" << vi.empty() << endl;

	vi.push_back(0);
	cout << "vi size=" << vi.size() << endl;
	cout << "vi cap =" << vi.capacity() << endl;
	cout << "vi empty=" << vi.empty() << endl;

	vi.push_back(1);
	cout << "vi size=" << vi.size() << endl;
	cout << "vi cap =" << vi.capacity() << endl;

	vi.push_back(2);
	cout << "vi size=" << vi.size() << endl;
	cout << "vi cap =" << vi.capacity() << endl;

	vi.push_back(3);
	cout << "vi size=" << vi.size() << endl;
	cout << "vi cap =" << vi.capacity() << endl;

	for(int i=0; i< vi.size(); ++i) {
		cout << "vi[" << i << "]=" << vi[i] << endl;
		vi[i]=i*42;
	}


	vi.at(0) = -42;

	for(int i=0; i< vi.size(); ++i) {
		cout << "vi[" << i << "]=" << vi[i] << endl;
	}

	// cout << vi[42] << endl;
	
	// cout << vi.at(42) << endl;

	vi.pop_back();
	cout << "vi size=" << vi.size() << endl;
	cout << "vi cap =" << vi.capacity() << endl;
	
	
	vector<double> vd(100);
	cout << "vd size=" << vd.size() << endl;
	cout << "vd cap =" << vd.capacity() << endl;
	for(int i=0; i < vd.size(); ++i) {
		vd[i] = i*3.14;
	}
	vd.push_back(100*3.14);
	cout << "vd size=" << vd.size() << endl;
	cout << "vd cap =" << vd.capacity() << endl;
	
	
	for(vector<int>::iterator it=vi.begin(); it!=vi.end(); ++it) {
		cout << "*it=" << *it << endl;
	}
	return 0;
}


