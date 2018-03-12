#include <iostream>
#include <vector>
#include "turtle.hh"

using namespace std;

enum Direction {
	DOWN = 0,
	RIGHT = 1,
	UP = 2,
	LEFT = 3,
	ALL = 4
};

class Cell {

	static const int STEP = 20;

	bool visited_;
	bool walls_[ALL];
	int row_;
	int col_;
public:
	
	Cell(int row, int col)
	: visited_(false),
	  row_(row),
	  col_(col)
	{
		for(int i=0; i<ALL; i++) {
			walls_[i] = true;
		}
	}
	
	bool is_visited() const {
		return visited_;
	}
	
	void visit() {
		visited_ = true;
	}
	
	bool has_wall(Direction dir) const {
		return walls_[dir];
	}

	void drill_wall(Direction dir) {
		walls_[dir] = false;
	}
	void build_wall(Direction dir) {
		walls_[dir] = true;
	}
	
	void draw(Turtle& t) {
		t.set_pos(Point((col_ + 1)*STEP, (row_ + 1)*STEP));
		t.set_heading(0);
		for(int i=0; i<ALL; ++i) {
			if(has_wall((Direction)i)) {
				t.pendown();
			} else {
				t.penup();
			}
			t.forward(STEP);
			t.left(90);
		}
	} 
};

class Board {
	const int height_;
	const int width_;
	vector<Cell> board_;

public:
	Board(int height, int width)
	: height_(height),
	  width_(width)
	{
		for(int row=0; row< height_; ++row) {
			for(int col=0; col< width_; ++col) {
				board_.push_back(Cell(row, col));
			}
		}
	}
	
	Cell& get_cell(int row, int col) {
		int index = row*width_ + col;
		return board_.at(index);
	}
	
	void draw(Turtle& t) {
		for(vector<Cell>::iterator it=board_.begin();
			it!= board_.end(); ++it) {

			it->draw(t);	
		}
	}

};





int main() {
	Board b(30, 30);

	PSTurtle t(1000, 1000);
	t.setup();
	t.penup();
	
	b.draw(t);
	
	
	return 0;
}

