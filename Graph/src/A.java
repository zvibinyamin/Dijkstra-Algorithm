import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

public class A {
	
	public static void test(String dir){
		File file = new File(dir);
		
		
		//System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		System.out.println(file.exists());
		
		FileReader fr;
		BufferedReader in;
		try {
			fr = new FileReader(file);
			in = new BufferedReader(fr);
			
		    System.out.println(in.readLine());	
			
		    in.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static EdgeWeightedDigraph buildGraph( String directory){
		File file = new File(directory);
		
		System.out.println(file.isFile());
		System.out.println(file.exists());
		
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
		
		//Declare file for 'dir_paths':
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
			String str = reader.readLine();
			int numOfpaths = Integer.parseInt(str);
			System.out.println("paths: "+numOfpaths);   //check
			
			//Iterate over paths.
			//Each time - get src, dest vertexes and the blackList.
			//Use the Dijkstra algorithm to find pathLength. 
			for (int i = 0; i < numOfpaths; i++) {
				//Reading a line from file.
				StringTokenizer line = new StringTokenizer(reader.readLine(), " ");
				//int c = 0; // c - a pointer on the line.
				
				//reading vertexes src, dest of  the path:
				int src =  Integer.parseInt(line.nextToken());
				//c += 2;
				int dest =  Integer.parseInt(line.nextToken());
				System.out.println("src: "+ src+" dest: "+dest);     //check
				
				//reading blackList:
				//c += 2;
				int blacklist_length =  Integer.parseInt(line.nextToken());
			//	System.out.println("\t blacklist_length: "+ blacklist_length);     //check
				Vector<Integer> blackList = new Vector<Integer>();
				//for (c += 2; c < line.length(); c += 2) {
				while(line.hasMoreTokens()){	
				//System.out.print(line.charAt(c)-'0'+", ");    //check
					//blackList.add(line.charAt(c)-'0');
					blackList.add(Integer.parseInt(line.nextToken()));
				}
				
				//Using DijkstraSP algorithm: 
				DijkstraSP dijkstra = new DijkstraSP(G, src,blackList);
				if(dijkstra.hasPathTo(dest)){
					Double pathLength = dijkstra.distTo(dest);
				//	System.out.println("pathLength: "+pathLength);    //check
					writer.write(pathLength.toString());
				}
				else writer.write("inf");
				writer.newLine();
						
				System.out.println();    //check
			}//for
						
			
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
	public static void main(String[] args) throws IOException {
		String src = "C:\\11\\3333\\bigGraph.txt";
		String test = "C:\\11\\3333\\test1.txt";
		String dest = "C:\\11\\3333\\dest.txt";
		test(src);
		//ex1(src , test, dest);
		
		


	}



}
