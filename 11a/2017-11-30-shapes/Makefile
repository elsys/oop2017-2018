all: shapes

point.o: point.cc point.hh

shapes.o: shapes.cc point.hh

shapes: point.o shapes.o
	g++ -o shapes point.o shapes.o

clean:
	rm -f *.o shapes

