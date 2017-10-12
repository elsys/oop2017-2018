#include <iostream>
#include <list>

using namespace std;


void print_list(list<int>& li) {
	for(list<int>::iterator it=li.begin(); it!=li.end(); ++it) {
		cout << (*it) << " ";
	}
	cout << endl;
}

int main() {
	list<int> li;
	
	cout << "size=" << li.size() << endl;
	// cout << "cap =" << li.capacity() << endl;
	cout << "empty=" << li.empty() << endl;
		
	li.push_back(0);
	li.push_back(1);
	li.push_back(2);
	cout << "size=" << li.size() << endl;
	cout << "empty=" << li.empty() << endl;
	print_list(li);
	
	li.push_front(-1);
	li.push_front(-2);
	
	cout << "size=" << li.size() << endl;
	print_list(li);
	
	cout << "front: " << li.front() << "; back: " << li.back() << endl;
	print_list(li);

	li.insert(li.begin(), -10);
	li.insert(li.end(), 10);
	print_list(li);
	
	auto it = li.begin();
	it++;
	it = li.insert(it, -9);
	print_list(li);
	
	// cout << li[0] << endl;
	
	// it = li.begin();
	// it++;
	li.erase(it);
	print_list(li);
	
	// li.erase(li.begin(), li.end());
	
	
	list<int> l1(10);
	print_list(l1);
	
	list<int> l2(10, 42);
	print_list(l2);
	
	int a[] = {0,1,2,3,4,5,6,7,8,9};
	list<int> l3(a, a+10);
	print_list(l3);
	
	list<int> l4(li.begin(), li.end());
	print_list(l4);
	
	
	
	return 0;
}

