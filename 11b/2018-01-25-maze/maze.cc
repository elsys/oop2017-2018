#include <vector>

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
	
	/*
				direc: 0100
				walls: 1000
				|		 : 1100
	*/
	void restore(Direction direction) {
		walls_ |= direction;
	}
};

class BoardError {};

class Board {
	vector<Cell> cells_;
	unsigned width_, height_;

	unsigned index(Cell& cell) {
		return cell.row() * width_ + cell.col();
	}
	
	unsigned neighbour_index(Cell& cell, Direction direction) {
		int row = cell.row();
		int col = cell.col();
		switch (direction) {
			case UP:
				row--;
				break;
			case RIGHT:
				col++;
				break;
			case DOWN:
				row++;
				break;
			case LEFT:
				col--;
				break;
		}
		if (row >= height_ || row < 0 || col >= width_ || col < 0) {
			throw BoardError();
		}
		return row * width_ + col;
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
	
	void drill(Cell& cell, Direction direction) {
		if (is_border(cell)) {
			throw BoardError();
		}
		cell.drill(direction);
		Cell& neighbour = cells_[neighbour_index(cell, direction)];
		neighbour.drill(opposite(direction));
	}
	
	static Direction opposite(Direction direction) {
		switch (direction) {
			case UP: return DOWN;
			case DOWN: return UP;
			case LEFT: return RIGHT;
			case RIGHT: return LEFT;
		}
	}
	
};

int main() {
	return 0;
}











