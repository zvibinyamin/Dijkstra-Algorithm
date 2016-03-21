hello!

This code uses Dijkstra's algorithm.

Explain how the code works is the link: Https://www.youtube.com/watch?v=gdmfOwyQlcI

We used open source located at the following link: Http://www.cswiki.org/wiki/index.php?title=Dijkstra

We took the open source informing and added it "wrapper" which takes two files: In_file_edegs and in_file_queries
And returns the solution (if available) of each track

Complexity -o(w*v*e*log|V|)
w=number of queries; v=number of nodes; e=number of edges.

----------------------------------------------------------------------------------------
**before you run the program you must make sure that you have all the .txt files in the location(defult is: c:\)
the text files is base on 2 files.
in1.txt - this file contains the graph(all the edges and vertex)
in2.txt - this file contains the test we do in order to check what is the shortest from vertex to vertex without spesific vertex(AKA "black list")
----------------------------------------------------------------------------------------
to change the input and output paths, you can call the main function like that:
"main(pathin1_name, pathin2_name, fileout)"
or
"main(pathin1_name, pathin2_name, fileout, "showTrack")" - Output will track
or
"main(pathin1_name, pathin2_name, fileout, "notdirected")" - the graph will be not directed.
or
"main(pathin1_name, pathin2_name, fileout, "showTrack", "notdirected")" - Output will track and the graph will be not directed.
----------------------------------------------------------------------------------------
Download the folder and put it in the path:
1. To run the unit test you need to download the folder "ex1/tests".
2. put the folder path "C:\tests".
3. run the file "ex1/Graph/test/tests.java" on your computer.


How to open the project:
1.go to "ex1/Graph" And download it to your computer
2.open the project with netbeans
3.run the program

----------------------------------------------------------------------------------------

This work was written by:
daniel fuchs, sapir ankri, akiva gubbay and zvika binyamin.
