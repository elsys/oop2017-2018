#include <iostream>
#include <vector>
#include <cassert>
#include <cstdlib>

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
	
	int row() const {
		return row_;
	}
	int col() const {
		return col_;
	}
};

class Board {
	const int height_;
	const int width_;
	vector<Cell> board_;

	Cell* get_neighbour(Cell* c, Direction dir) {
		int row = c->row();
		int col = c->col();
		
		switch(dir) {
		case UP:
			row ++;
			break;
		case DOWN:
			row --;
			break;
		case LEFT:
			col --;
			break;
		case RIGHT:
			col ++;
			break;
		default:
			assert(false);
		}
		if(row<0 || row>=height_ || col <0 || col >= width_) {
			return NULL;
		}
		return &get_cell(row, col);
	}
	
	vector<Direction> get_unvisited_neighbours(Cell* c) {
		vector<Direction> result = vector<Direction>();
		for(int i=0; i<ALL; ++i) {
			Cell* n = get_neighbour(c, (Direction)i);
			if(n != NULL) {
				if(!n -> is_visited()) {
					result.push_back((Direction)i);
				}
			}
		}
		return result;
	}

	Cell* drill(Cell* c, Direction dir) {
		Cell* n = get_neighbour(c, dir);
		assert(n != NULL);
		
		c -> drill_wall(dir);
		n -> drill_wall((Direction)((dir + 2) % 4));
		return n;
	}
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
	
	void generate_maze(Cell& c) {
		c.visit();
		
		while(true) {
			vector<Direction> ns = get_unvisited_neighbours(&c);
			if(ns.empty()) {
				break;
			}
			int r = rand() % ns.size();
			Direction rd = ns[r];
			
			Cell* n = drill(&c, rd);
			
			generate_maze(*n);
		}
	}

};





int main() {
	Board b(48, 48);

	PSTurtle t(1000, 1000);
	t.setup();
	t.penup();
	
	Cell& start = b.get_cell(0,0);
	b.generate_maze(start);
	
	b.draw(t);
	
	
	return 0;
}

