import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

public class Graph_algo {
	
	private static EdgeWeightedDigraph buildGraph( String directory){
		File file = new File(directory);
		
		//System.out.println(file.isFile());   //check
		//System.out.println(file.exists());   //check
		
		FileReader fr;
		BufferedReader in;
		try {
			fr = new FileReader(file);
			in = new BufferedReader(fr);
			
			EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
			
			in.close();
			fr.close();
			
			return G;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void ex1(String dir_graph, String dir_paths, String dir_res){
		//Build the graph:
		EdgeWeightedDigraph G = buildGraph(dir_graph);                                  
		System.out.println(G.toString());    //check
		
		//Declare file for 'dir_paths', 'dir_res:
		File file_graph, file_res;
		FileReader file_reader_graph;
		BufferedReader reader;
		FileWriter  file_writer_res;
		BufferedWriter writer;
		

		try {
			//Opening 'dir_paths':
			file_graph = new File(dir_paths);
			file_reader_graph = new FileReader(file_graph);
			reader = new BufferedReader(file_reader_graph);
			
			//Opening 'dir_res':
			file_res = new File(dir_res);
			file_writer_res = new FileWriter(file_res);
			writer = new BufferedWriter(file_writer_res);
			
			//Get first line- number of paths to find:
			int numOfpaths = Integer.parseInt(reader.readLine());
			//System.out.println("paths: "+numOfpaths);   //check
			
			//Iterate over paths.
			//Each time - get src, dest vertexes and the blackList.
			//Use the Dijkstra algorithm to find pathLength. 
			for (int i = 0; i < numOfpaths; i++) {
				//Reading a line from file.
				String strLine = reader.readLine();                         //put first in string instead of StringTokenizer,
				StringTokenizer line = new StringTokenizer(strLine, " ");  //because I need to print this line into the res file later.
				
				//reading vertexes src, dest of  the path:
				int src =  Integer.parseInt(line.nextToken());
				int dest =  Integer.parseInt(line.nextToken());
				//System.out.println("src: "+ src+" dest: "+dest);     //check
				
				//reading blackList:
				int blacklist_length =  Integer.parseInt(line.nextToken());
			//	System.out.println("\t blacklist_length: "+ blacklist_length);     //check
				Vector<Integer> blackList = new Vector<Integer>();
				while(line.hasMoreTokens()){	
				//System.out.print(line.charAt(c)-'0'+", ");    //check
					blackList.add(Integer.parseInt(line.nextToken()));
				}
				
				//writing first the line from file  -  src, dest vertexes and the blackList.
				writer.write(strLine+" ");
				//Using DijkstraSP algorithm to calculate the distance: 
				//then writing that distance into the res file.
				DijkstraSP dijkstra = new DijkstraSP(G, src,blackList);
				if(dijkstra.hasPathTo(dest)){
					Double pathLength = dijkstra.distTo(dest);
				//	System.out.println("pathLength: "+pathLength);    //check
					writer.write(pathLength.toString());
				}
				else writer.write("inf");
				writer.newLine();
						
			//	System.out.println();    //check
			}
						
			
			//Closing all files:
			writer.close();
			file_writer_res.close();
			reader.close();
			file_reader_graph.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		String src = "C:\\Users\\akiva\\Desktop\\largeEWD.txt";
		String test = "C:\\11\\3333\\test1.txt";
		String dest = "C:\\11\\3333\\dest.txt";
		System.out.println("start");
		ex1(src , test, dest);
		System.out.println("end");
	}

}
