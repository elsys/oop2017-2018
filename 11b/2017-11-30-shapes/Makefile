all: shapes

point.o: point.cc

circle.o: circle.cc

shapes.o: shapes.cc

shapes: point.o circle.o shapes.o
	g++ -o shapes point.o circle.o shapes.o

clean:
	rm -f *.o shapes

