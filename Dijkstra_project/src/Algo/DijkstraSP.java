package Algo;
//לזרוק שגיאה בקודקדים שלילים

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class DijkstraSP {

    static String file_in1 = "c:/in1.txt";
    static String file_in2 = "c:/in2.txt";
    static String file_out = "c:/out.txt";

    static FileWriter File_Writer;
    static BufferedWriter Buffered_Writer;

    static FileReader File_Reader;
    static BufferedReader Buffered_Reader;

    Vertex[] vertices;

    public DijkstraSP(Vertex[] vs) {
        vertices = new Vertex[vs.length];
        for (int i = 0; i < vs.length; i++) {
            vertices[i] = vs[i];
        }
    }

    public Vertex getVertex(int index) {
        return vertices[index];
    }

    public boolean use(int[] not_use, Vertex v) {
        if (not_use == null) {
            return true;
        }
        for (int j = 0; j < not_use.length; j++) {
            if (v == vertices[not_use[j]]) {
                return false;
            }
        }
        return true;
    }

    public void computePaths(Vertex s, int[] not_use) {
        s.minDistance = 0;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(s);
        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();
            // Visit each edge exiting u
            for (Edge e : u.adjacencies) {
                Vertex v = e.vert;
                float weight = e.weight;
                float distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance && use(not_use, u) && use(not_use, v)) {//relaxation
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

//    public void computePaths(Vertex s) {
//        s.minDistance = 0.;
//        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
//        vertexQueue.add(s);
//        while (!vertexQueue.isEmpty()) {
//            Vertex u = vertexQueue.poll();
//            // Visit each edge exiting u
//            for (Edge e : u.adjacencies) {
//                Vertex v = e.vert;
//                double weight = e.weight;
//                double distanceThroughU = u.minDistance + weight;
//                if (distanceThroughU < v.minDistance) {//relaxation
//                    vertexQueue.remove(v);
//                    v.minDistance = distanceThroughU;
//                    v.previous = u;
//                    vertexQueue.add(v);
//                }
//            }
//        }
//    }
//    public void printPathes() {
//        for (Vertex v : vertices) {
//            if (v.minDistance == Double.POSITIVE_INFINITY) {
//                System.out.println("Distance to " + v + ": " + "inf // there no such path in the graph + black-list");
//                continue;
//            }
//            System.out.println("Distance to " + v + ": " + v.minDistance);
//            List<Vertex> path = getShortestPathTo(v);
//            System.out.println("Path: " + path);
//        }
//    }
    public String printOnePathes(int j) {

        if (vertices[j].minDistance == Float.POSITIVE_INFINITY) {
            return " inf // there no such path in the graph + black-list";
        }
        //List<Vertex> path = getShortestPathTo(vertices[j]);
        //return " " + vertices[j].minDistance + " - Track:" + getShortestPathTo(vertices[j]);
        return " " + vertices[j].minDistance;
    }

    public static List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous) {
            path.add(vertex);
        }
        Collections.reverse(path);
        return path;
    }

    public static void addEdge(Vertex[][] v, int jndex_IN, int jndex_OUT, float cost) {
        for (int i = 0; i < v.length; i++) {
            v[i][jndex_IN].adjacencies.add(new Edge(v[i][jndex_OUT], cost));
        }
    }

    public static Vertex[][] init1(String file_name1, int num_of_queries) {
        
        Vertex[][] v = null;

        String line;
        File f;
        FileReader file;
        BufferedReader Reader;
        StringTokenizer tok;
        int in, out;
        float r;
        int num = 0;

        try {
            f = new File(file_name1);

            file = new FileReader(f);
            Reader = new BufferedReader(file);

            int nodes = Integer.valueOf(Reader.readLine());
            int edges = Integer.valueOf(Reader.readLine());

            v = new Vertex[num_of_queries][nodes];
            for (int i = 0; i < v.length; i++) {
                for (int j = 0; j < v[i].length; j++) {
                    v[i][j] = new Vertex(String.valueOf(j));
                }
            }

            line = Reader.readLine();

            while (line != null) {
                tok = new StringTokenizer(line, " ");

                in = Integer.valueOf(tok.nextToken());
                out = Integer.valueOf(tok.nextToken());
                r = Float.valueOf(tok.nextToken());
                addEdge(v, in, out, r);
                //System.out.println("addEdge(v, " + in + ", " + out + ", " + r + ")");

                line = Reader.readLine();
                if (num++ % 1000 == 999) {
                    System.out.println(num++);
                }
            }

            Reader.close();
            file.close();

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

        return v;
    }

    public static int read_num_of_queries(String file_name1) {
        int length = 0;
        String line;
        File f;
        FileReader file;
        BufferedReader Reader;

        try {
            f = new File(file_name1);

            file = new FileReader(f);
            Reader = new BufferedReader(file);

            length = Integer.valueOf(Reader.readLine());

            Reader.close();
            file.close();

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

        return length;
    }

    public static void openWriterFile() {
        File f = new File(file_out);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }

            File_Writer = new FileWriter(f);
            Buffered_Writer = new BufferedWriter(File_Writer);
        } catch (IOException ex) {
            Logger.getLogger(DijkstraSP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void openReaderFile() {
        File f = new File(file_in2);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }

            File_Reader = new FileReader(f);
            Buffered_Reader = new BufferedReader(File_Reader);
        } catch (IOException ex) {
            Logger.getLogger(DijkstraSP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void CloseFile() {
        try {
            Buffered_Reader.close();
            File_Reader.close();
            Buffered_Writer.close();
            File_Writer.close();
        } catch (IOException ex) {
            Logger.getLogger(DijkstraSP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void addline(String line) {
        try {
            Buffered_Writer.write(line);
            Buffered_Writer.newLine();
        } catch (IOException ex) {
            Logger.getLogger(DijkstraSP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws IOException {
        String line;
        int in, out;
        int[] use = null;
        StringTokenizer tok;

        int num_of_queries = read_num_of_queries(file_in2);
        //int[] use = {1, 4};
        Vertex[][] init1 = init1(file_in1, num_of_queries);
        DijkstraSP[] dsp = new DijkstraSP[init1.length];

        openWriterFile();
        openReaderFile();
        System.out.println("");
        addline(Buffered_Reader.readLine());
        line = Buffered_Reader.readLine();

        for (int i = 0; i < init1.length; i++) {
            if (line == null) {
                System.out.println("Error");
                return;
            }
            tok = new StringTokenizer(line, " ");

            in = Integer.valueOf(tok.nextToken());
            out = Integer.valueOf(tok.nextToken());
            //Vector<Integer> use = new Vector();
            if (tok.hasMoreElements()) {
                int t = Integer.valueOf(tok.nextToken());
                if (t < 1) {
                    use = null;
                } else {
                    use = new int[t];
                    for (int j = 0; j < use.length && tok.hasMoreElements(); j++) {
                        use[j] = Integer.valueOf(tok.nextToken());
                    }
                }
            }

            dsp[i] = new DijkstraSP(init1[i]);
            dsp[i].computePaths(dsp[i].getVertex(in), use);

            addline(line + dsp[i].printOnePathes(out));
            System.out.println(line + dsp[i].printOnePathes(out));
            line = Buffered_Reader.readLine();
            dsp[i] = null;
            init1[i] = null;
        }
        CloseFile();

    }

//    public static void main(String[] args) {
//        DijkstraSP dsp = new DijkstraSP(init1("c:/in.txt"));
//        dsp.computePaths(dsp.getVertex(0));
//        dsp.printPathes();
//    }
}
