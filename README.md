hello!

This project finds the shortest/cheapest path between a pair vertexes, in an edge-weighted graph, by implementing the Dijkstra algorithm.

We took the open source and added a "wrapper" - the program receives two files. The first with information about the graph, The second with a list of vertex pairs, each pair

with a certain restriction(further information to follow). The program then calculates the shortest/cheapest path between each

pair and prints the result into a file. 

For an explanation on the Dijkstra algorithm, please refer to: Https://www.youtube.com/watch?v=gdmfOwyQlcI

We used an open source located at the following link: Http://www.cswiki.org/wiki/index.php?title=Dijkstra

Complexity - O(w*v*e*log|V|)

w=number of queries; v=number of nodes; e=number of edges.

*NOTE - We have an additional solution for the project in 'Graph_2' that works just as well. Graph_2 implements Dijkstra as well.
----------------------------------------------------------------------------------------
Before you run the program you must make sure that you have all the '.txt' files in the location(defult is: c:\)

the text files are based on two files.

in1.txt - contains the data to build an edge-weighted graph( vertexes edges and edge-weights).

in2.txt - contains a list of vertex pairs, witch shortest/cheapest paths between the algorithem is required to find.
          Each pair comes with a list of vertexes that the path cannot pass through(aka "black list"). 

----------------------------------------------------------------------------------------
How to run and open the project:

1.Go to "ex1/Graph" And download it to your computer.

2.Open the project with netbeans.

3.Run the program.

----------------------------------------------------------------------------------------
To change the input path or the output path, you can call the main function in the following ways:

1. "main(pathin1_name, pathin2_name, fileout)"

2. "main(pathin1_name, pathin2_name, fileout, "showTrack")" - print the path to file.

3. "main(pathin1_name, pathin2_name, fileout, "notdirected")" - For an undirected graph.

4. "main(pathin1_name, pathin2_name, fileout, "showTrack", "notdirected")" - Output will track and the graph will be not directed.

----------------------------------------------------------------------------------------
How to run the junit test:

1. you need to download the folder "ex1/tests", and the project.

2. Put the folder from "ex1/tests" in the path: "C:\tests".

3. Run the file "ex1/Graph/test/tests.java" on your computer.

----------------------------------------------------------------------------------------

This Project was created by:

Daniel Duchs, Sapir Ankri, Akiva Gubbay and Zvika Binyamin.
