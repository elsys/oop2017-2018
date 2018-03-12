#include <vector>
#include <cstdlib>
#include "turtle.hh"

using namespace std;

enum Direction {
	NONE = 0,
	UP = 1, 			 // 0001
	RIGHT = 1 << 1,// 0010 
	DOWN = 1 << 2, // 0100
	LEFT = 1 << 3, // 1000
};

class Cell {
	unsigned walls_; // 1101
	bool visited_;
	//? Board board_;
	unsigned col_, row_;

	static const int CELL_SIZE = 20;

public:

	Cell(unsigned row, unsigned col)
			: row_(row),
			  col_(col),
			  visited_(false),
			  walls_(UP | RIGHT | DOWN | LEFT) {}

	unsigned col() const {
		return col_;
	}
	
	unsigned row() const {
		return row_;
	}
	
	void visit() {
		visited_ = true;
	}
	
	bool is_visited() const {
		return visited_;
	}
	
	unsigned walls() const {
		return walls_;
	}

	/*	
						direc: 0100
						walls: 1101
						~direc:1011
		walls & ~direc:1001
	*/
	void drill(Direction direction) {		
		walls_ &= ~direction;
	}
	
	bool has_wall(Direction dir) {
		return walls_ & dir;
	}
	/*
				direc: 0100
				walls: 1000
				|		 : 1100
	*/
	void restore(Direction direction) {
		walls_ |= direction;
	}
	
	void draw(Turtle& t) {
		Point p((col_+1)*CELL_SIZE, (row_+1)*CELL_SIZE);
		t.set_pos(p).set_heading(0);
		
		Direction dirs[] = {DOWN,RIGHT,UP,LEFT};
		for(int i=0; i<4; ++i) {
			Direction d=dirs[i];
			if(has_wall(d)) {
				t.pendown();
			} else {
				t.penup();
			}
			t.forward(CELL_SIZE).left(90);
		}
		
	}
};

class BoardError {};

class Board {
	const static Direction DIRS[];

	vector<Cell> cells_;
	unsigned width_, height_;

	unsigned index(Cell& cell) {
		return cell.row() * width_ + cell.col();
	}
	unsigned index(int row, int col) {
		return row*width_ + col;
	}
	
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
		return &at(row, col);
	}

	vector<Direction> get_unvisited_neighbours(Cell* c) {
		vector<Direction> result = vector<Direction>();
		for(int i=0; i<4; ++i) {
			Direction dir = DIRS[i];
			Cell* n = get_neighbour(c, dir);
			if(n != NULL) {
				if(!n -> is_visited()) {
					result.push_back(dir);
				}
			}
		}
		return result;
	}
	
	bool is_border(Cell& cell) const {
		return cell.row() == 0 || cell.row() == height_ - 1 || cell.col() == 0 || cell.col() == width_ - 1;
	}

public:

	Board(unsigned width, unsigned height)
			: width_(width), height_(height) {
		for (unsigned row = 0; row < width_; row++) {
			for (unsigned col = 0; col < height_; col++) {
				cells_.push_back(Cell(row, col));
			}
		}	
	}
	
	Cell& drill(Cell& cell, Direction direction) {
		cell.drill(direction);
		Cell* neighbour = get_neighbour(&cell, direction);
		assert(neighbour!=NULL);
		
		neighbour->drill(opposite(direction));
		return *neighbour;
	}
	
	Cell& at(int row, int col) {
		return cells_[index(row, col)];
	}
	
	static Direction opposite(Direction direction) {
		switch (direction) {
			case UP: return DOWN;
			case DOWN: return UP;
			case LEFT: return RIGHT;
			case RIGHT: return LEFT;
		}
	}
	
	void draw(Turtle& t) {
		for(vector<Cell>::iterator it = cells_.begin();
			it != cells_.end(); ++it) {
		
			(*it).draw(t);	
		}
	}
	
	bool has_neighbour(Cell& cell, Direction dir) const {
		int row = cell.row();
		int col = cell.col();
		switch (dir) {
			case UP:
				row++;
				break;
			case RIGHT:
				col++;
				break;
			case DOWN:
				row--;
				break;
			case LEFT:
				col--;
				break;
		}
		if (row >= height_ || row < 0 || col >= width_ || col < 0) {
			return false;
		}
		return true;
	}
		
	
	void generate_maze(Cell& cell) {
		cell.visit();
		while(true) {
			vector<Direction> ns = get_unvisited_neighbours(&cell);
			if(ns.empty()) {
				break;
			}
			int r = rand() % ns.size();
			Direction rd = ns[r];
			
			Cell& n = drill(cell, rd);
			
			generate_maze(n);
		}
	}
};

const Direction Board::DIRS[] =  {DOWN, RIGHT, UP, LEFT};

int main() {
	Board b(48,48);
	
	PSTurtle t(1000, 1000);
	t.setup();
	
	Cell c = b.at(0,0);
	
	b.generate_maze(c);
	
	b.draw(t);

	return 0;
}











