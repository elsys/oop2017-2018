#include <cstdlib>
#include <iostream>

using namespace std;

class Stack {

  const static int chunk_ = 2;
  int top_;
  int size_;
  int *data_;

  public:

  Stack() : top_(-1), size_(chunk_), data_(new int[chunk_]) {}

  Stack(const Stack& other)
  : top_(other.top_), 
    size_(other.size_), 
    data_(new int[size_]) {
  
  	cout << "copy constructor called..." << endl;
  	
  	for(int i=0; i<=top_; ++i) {
  		data_[i] = other.data_[i];
  	}
  }

  ~Stack() {
    cout << "destructing" << endl;
    delete [] data_;
  }
  
  Stack& operator=(const Stack& other) {
  	if(this != &other) {
	  	delete [] data_;
	  	top_ = other.top_;
	  	size_ = other.size_;
	  	data_ = new int[size_];
	  	for(int i=0; i<=top_; ++i) {
	  		data_[i] = other.data_[i];
	  	}
  	}
  	return *this;
  }
  
  int length() const {
    return top_ + 1;
  }

  bool empty() const {
    return top_ == -1;
  }

  void push(int v) {
    if (top_ == (size_ - 1)) {
      resize();
    }
    data_[++top_] = v;
  }

  int pop(void) {
    if ( top_ < 0 ) {
      throw exception();
    }
    return data_[top_--];
  }

  private:

  void resize() {
    cout << "resizing" << endl;
    int* tmp = data_;
    data_ = new int[size_ + chunk_];
    for( int i = 0; i < size_; i++ ) {
      data_[i] = tmp[i];
    }
    size_ += chunk_;
    delete [] tmp;
  }
};

int sum(Stack st) {
	int s = 0;
	while(!st.empty()) {
		s += st.pop();
	}
	return s;
}

int main(void) {
  Stack st;
  
  int a,b,c;
  a=(b=(c=0));
  
  a = a;
  
  for (int i = 0; i < 10; i++) {
    st.push(1);
  }
  
  cout << sum(st) << endl;
  
  Stack st2;
  st2 = st;
  cout << sum(st2) << endl;
  
  st2 = st2;
  cout << sum(st2) << endl;
  
  while(!st.empty()) {
  	cout << st.pop() << endl;
  }
  return 0;
}






