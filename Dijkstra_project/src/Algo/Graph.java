package Algo;

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

import java.util.logging.Level;
import java.util.logging.Logger;

public class Graph {

    static String file_in1 = "c:/in1.txt";
    static String file_in2 = "c:/in2.txt";
    static String file_out = "c:/out.txt";
    static boolean showTrack = false;
    static boolean isdirected = true;

    static FileWriter File_Writer;
    static BufferedWriter Buffered_Writer;

    static FileReader File_Reader;
    static BufferedReader Buffered_Reader;

    Vertex[] vertices;

    /**
     * Builds Vertex[] vs
     */
    public Graph(Vertex[] vs) {
        vertices = new Vertex[vs.length];
        for (int i = 0; i < vs.length; i++) {
            vertices[i] = vs[i];
        }
    }

    public Vertex getVertex(int index) {
        return vertices[index];
    }

    /**
     * Checks can be used at v to Others
     */
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

    /**
     * Looking for the shortest track of s, not us at "int[] not_use"
     */
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

    /**
     * print the Pathes
     */
    public String printOnePathes(int j) {
        if (vertices[j].minDistance == Float.POSITIVE_INFINITY) {
            return " inf // there no such path in the graph + black-list";
        }
        if (showTrack == true) {
            return " " + vertices[j].minDistance + " - Track:" + getShortestPathTo(vertices[j]);
        } else {
            return " " + vertices[j].minDistance;
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous) {
            path.add(vertex);
        }
        Collections.reverse(path);
        return path;
    }

    /**
     * add the Edge to the Vertex[]
     */
    public static void addEdge(Vertex[] v, int jndex_IN, int jndex_OUT, float cost) {
        v[jndex_IN].adjacencies.add(new Edge(v[jndex_OUT], cost));
    }

    /**
     * add the all Edge to the Vertex[] and not directed
     */
    public static Vertex[] init1_notDirected() {

        Vertex[] v = null;

        String line;
        File f;
        FileReader file;
        BufferedReader Reader;
        StringTokenizer tok;
        int in, out;
        float r;

        try {
            f = new File(file_in1);

            file = new FileReader(f);
            Reader = new BufferedReader(file);

            int nodes = Integer.valueOf(Reader.readLine());
            int edges = Integer.valueOf(Reader.readLine());

            v = new Vertex[nodes];
            for (int i = 0; i < v.length; i++) {
                v[i] = new Vertex(String.valueOf(i));
            }

            line = Reader.readLine();

            while (line != null) {
                tok = new StringTokenizer(line, " ");

                in = Integer.valueOf(tok.nextToken());
                out = Integer.valueOf(tok.nextToken());
                r = Float.valueOf(tok.nextToken());
                if (r <= 0) {
                    new RuntimeException("the weight can't by <=0");
                }
                addEdge(v, in, out, r);
                addEdge(v, out, in, r);

                line = Reader.readLine();
//                if (num++ % 1000 == 999) {
//                    System.out.println(num++);
//                }
            }

            Reader.close();
            file.close();

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

        return v;
    }

    /**
     * add the all Edge to the Vertex[] and not directed
     */
    public static Vertex[] init1_Directed() {

        Vertex[] v = null;

        String line;
        File f;
        FileReader file;
        BufferedReader Reader;
        StringTokenizer tok;
        int in, out;
        float r;

        try {
            f = new File(file_in1);

            file = new FileReader(f);
            Reader = new BufferedReader(file);

            int nodes = Integer.valueOf(Reader.readLine());
            int edges = Integer.valueOf(Reader.readLine());

            v = new Vertex[nodes];
            for (int i = 0; i < v.length; i++) {
                v[i] = new Vertex(String.valueOf(i));
            }

            line = Reader.readLine();

            while (line != null) {
                tok = new StringTokenizer(line, " ");

                in = Integer.valueOf(tok.nextToken());
                out = Integer.valueOf(tok.nextToken());
                r = Float.valueOf(tok.nextToken());
                if (r <= 0) {
                    new RuntimeException("the weight can't by <=0");
                }
                addEdge(v, in, out, r);

                line = Reader.readLine();
//                if (num++ % 1000 == 999) {
//                    System.out.println(num++);
//                }
            }

            Reader.close();
            file.close();

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

        return v;
    }

    /**
     * open the WriterFile
     */
    public static void openWriterFile() {
        File f = new File(file_out);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }

            File_Writer = new FileWriter(f);
            Buffered_Writer = new BufferedWriter(File_Writer);
        } catch (IOException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * open the ReaderFile
     */
    public static void openReaderFile() {
        File f = new File(file_in2);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }

            File_Reader = new FileReader(f);
            Buffered_Reader = new BufferedReader(File_Reader);
        } catch (IOException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Close the all File
     */
    public static void CloseFile() {
        try {
            Buffered_Reader.close();
            File_Reader.close();
            Buffered_Writer.close();
            File_Writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * add line to Buffered_Writer
     */
    public static void addline(String line) {
        try {
            Buffered_Writer.write(line);
            Buffered_Writer.newLine();
        } catch (IOException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * reset the Graph data
     */
    public static void reset(Vertex[] init1) {
        for (int i = 0; i < init1.length; i++) {
            init1[i].minDistance = Float.POSITIVE_INFINITY;
            init1[i].previous = null;
        }
    }

    /**
     * the main: Calls on all functions
     */
    public static void main(String[] args) throws IOException {
        if (args != null && args.length != 0) {
            if (args.length > 0 && args[0].equals("null")) {
                //the default is file_in1 = "c:/in1.txt";
                file_in1 = args[0];
            }
            if (args.length > 1 && args[1].equals("null")) {
                //the default is file_in2 = "c:/in2.txt";
                file_in2 = args[1];
            }
            if (args.length > 2 && args[2].equals("null")) {
                //the default is file_out = "c:/out.txt";
                file_out = args[2];
            }
            if (args.length > 3 && args[3].equals("showTrack")) {
                //the default is showTrack= false;
                showTrack = true;
            }
            if ((args.length > 3 && args[3].equals("notdirected"))
                    || (args.length > 4 && args[4].equals("notdirected"))) {
                //the default is isdirected = true;
                isdirected = false;
            }

        }
        Vertex[] init1;
        String line;
        int in, out;
        int[] use = null;
        StringTokenizer tok;

        if (isdirected == true) {
            init1 = init1_Directed();
        } else {
            init1 = init1_notDirected();
        }

        Graph dsp;

        openWriterFile();
        openReaderFile();
        System.out.println("");
        addline(Buffered_Reader.readLine());
        line = Buffered_Reader.readLine();

        for (int i = 0; i < init1.length && line != null; i++) {
            tok = new StringTokenizer(line, " ");

            in = Integer.valueOf(tok.nextToken());
            out = Integer.valueOf(tok.nextToken());

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

            dsp = new Graph(init1);
            dsp.computePaths(dsp.getVertex(in), use);

            addline(line + dsp.printOnePathes(out));
            System.out.println(line + dsp.printOnePathes(out));
            line = Buffered_Reader.readLine();
            reset(init1);
        }
        CloseFile();
    }
}
