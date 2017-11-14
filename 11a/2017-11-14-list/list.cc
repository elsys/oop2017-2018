#include <iostream>
using namespace std;

class ListError{};

class List {
	struct Node {
		int data_;
		Node* next_;
		Node* prev_;
	
		Node(int val)
		: data_(val),
		  next_(0),
		  prev_(0)
		{}
	
	};

	Node* head_;

public:
	List()
	: head_(new Node(0))
	{
		head_->next_ = head_;
		head_->prev_ = head_;
	}
	
	~List() {
		while(!empty()) {
			pop_back();
		}
		delete head_;
	}
	class iterator {
		friend class List;
		
		List* list_;
		Node* current_;
		
		iterator(List* list, Node* current)
		: list_(list),
		  current_(current)
		{}
	public:
		
		iterator& operator++() {
			current_ = current_->next_;
			return *this;
		}
	
		int& operator*() {
			return current_ -> data_;
		}
		
		bool operator==(const iterator& other) {
			return list_ == other.list_ && 
				current_ == other.current_;
		}
		
		bool operator!=(const iterator& other) {
			return ! operator==(other);
		}
	};
	
	iterator begin() {
		return iterator(this,head_->next_);
	}
	
	iterator end() {
		return iterator(this,head_);
	}
	
	bool empty() const {
		return head_ -> next_ == head_;
	}
	
	void push_back(int val) {
		Node* ptr = new Node(val);
		Node* back = head_-> prev_;
		
		back->next_ = ptr;
		ptr->next_ = head_;
		
		head_->prev_ = ptr;
		ptr-> prev_ = back;
	}
	
	int front() const {
		if(empty()) {
			throw ListError();
		}
		return head_->next_->data_;
	}
	
	int back() const {
		if(empty()) {
			throw ListError();
		}
		return head_->prev_->data_;
	}
	
	void pop_back() {
		if(empty()) {
			throw ListError();
		}
		Node* back = head_ -> prev_;
		Node* new_back = back -> prev_;
		
		new_back -> next_ = head_;
		head_ -> prev_ = new_back;
		
		delete back;
	}
	
	
};


int main() {

	List l1;
	
	cout << l1.empty() << endl;
	l1.push_back(1);
	cout << l1.back() << " " << l1.front() << endl;
	l1.push_back(2);
	cout << l1.back() << " " << l1.front() << endl;
	
	l1.pop_back();
	cout << l1.back() << " " << l1.front() << endl;
	l1.pop_back();
	cout << l1.empty() << endl;
	
	/*
	int a = 0;
	int b = ++a;
	*/
	
	l1.push_back(1);
	l1.push_back(2);
	cout << "iterator for: " << endl;
	for(List::iterator it = l1.begin(); it!=l1.end(); ++it) {
		cout << *it << endl;
	}
	return 0;
}

