/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Algo.Graph;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zvika
 */
public class tests {

    public tests() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    static String file_in_1 = "c:/in1.txt";
    static String file_in_2 = "c:/in1.txt";
    static String file_out = "c:/in2.txt";

    static String file_out_two = "c:/out.txt";

    static FileReader File_Reader;
    static BufferedReader Buffered_Reader;

    static FileReader File_Reader_two;
    static BufferedReader Buffered_Reader_two;

    @Test(timeout = 1000)
    public void test_full_tree() throws IOException {
        file_in_1 = "C:/tests/test full tree/in1.txt";
        file_in_2 = "C:/tests/test full tree/in2.txt";
        file_out = "C:/tests/test full tree/out.txt";

        file_out_two = "c:/out.txt";

        String[] s = {file_in_1, file_in_2, file_out_two};
        Algo.Graph.main(s);

        open_file_out();
        open_file_out_two();

        String line1 = getline(Buffered_Reader);
        String line2 = getline(Buffered_Reader_two);

        while (line1 != null && line2 != null) {
            assertEquals(line1, line2);
            line1 = getline(Buffered_Reader);
            line2 = getline(Buffered_Reader_two);
        }

        CloseAllFiles();
    }

    @Test(timeout = 1000)
    public void test_MyTest() throws IOException {
        file_in_1 = "C:/tests/MyTest/a1.txt";
        file_in_2 = "C:/tests/MyTest/a2.txt";
        file_out = "C:/tests/MyTest/out.txt";

        file_out_two = "c:/out.txt";

        String[] s = {file_in_1, file_in_2, file_out_two};
        Algo.Graph.main(s);

        open_file_out();
        open_file_out_two();

        String line1 = getline(Buffered_Reader);
        String line2 = getline(Buffered_Reader_two);

        while (line1 != null && line2 != null) {
            assertEquals(line1, line2);
            line1 = getline(Buffered_Reader);
            line2 = getline(Buffered_Reader_two);
        }

        CloseAllFiles();
    }

    @Test(timeout = 1000)
    public void test_test2() throws IOException {
        file_in_1 = "C:/tests/test2/in1.txt";
        file_in_2 = "C:/tests/test2/in2.txt";
        file_out = "C:/tests/test2/out.txt";

        file_out_two = "c:/out.txt";

        String[] s = {file_in_1, file_in_2, file_out_two};
        Algo.Graph.main(s);

        open_file_out();
        open_file_out_two();

        String line1 = getline(Buffered_Reader);
        String line2 = getline(Buffered_Reader_two);

        while (line1 != null && line2 != null) {
            assertEquals(line1, line2);
            line1 = getline(Buffered_Reader);
            line2 = getline(Buffered_Reader_two);
        }

        CloseAllFiles();
    }

    @Test(timeout = 1000)
    public void test_undirected_graph_test() throws IOException {
        file_in_1 = "C:/tests/undirected_graph_test/undirected_graph.txt";
        file_in_2 = "C:/tests/undirected_graph_test/undirected_test.txt";
        file_out = "C:/tests/undirected_graph_test/undirected_dest.txt";

        file_out_two = "c:/out.txt";

        String[] s = {file_in_1, file_in_2, file_out_two};
        Algo.Graph.main(s);

        open_file_out();
        open_file_out_two();

        String line1 = getline(Buffered_Reader);
        String line2 = getline(Buffered_Reader_two);

        while (line1 != null && line2 != null) {
            assertEquals(line1, line2);
            line1 = getline(Buffered_Reader);
            line2 = getline(Buffered_Reader_two);
        }

        CloseAllFiles();
    }

    @Test(timeout = 1000)
    public void test_teacher1() throws IOException {
        file_in_1 = "C:/tests/teacher1/in1.txt";
        file_in_2 = "C:/tests/teacher1/in2.txt";
        file_out = "C:/tests/teacher1/out.txt";

        file_out_two = "C:/out.txt";

        String[] s = {file_in_1, file_in_2, file_out_two};
        Algo.Graph.main(s);

        open_file_out();
        open_file_out_two();

        String line1 = getline(Buffered_Reader);
        String line2 = getline(Buffered_Reader_two);

        while (line1 != null && line2 != null) {
            assertEquals(line1, line2);
            line1 = getline(Buffered_Reader);
            line2 = getline(Buffered_Reader_two);
        }

        CloseAllFiles();
    }

    @Test(timeout = 1000)
    public void test_teacher2() throws IOException {
        file_in_1 = "C:/tests/teacher2/in1.txt";
        file_in_2 = "C:/tests/teacher2/in2.txt";
        file_out = "C:/tests/teacher2/out.txt";

        file_out_two = "C:/out.txt";

        String[] s = {file_in_1, file_in_2, file_out_two};
        Algo.Graph.main(s);

        open_file_out();
        open_file_out_two();

        String line1 = getline(Buffered_Reader);
        String line2 = getline(Buffered_Reader_two);

        while (line1 != null && line2 != null) {
            assertEquals(line1, line2);
            line1 = getline(Buffered_Reader);
            line2 = getline(Buffered_Reader_two);
        }

        CloseAllFiles();
    }

    @Test(timeout = 1000)
    public void test_teacher3() throws IOException {
        file_in_1 = "C:/tests/teacher3/in1.txt";
        file_in_2 = "C:/tests/teacher3/in2.txt";
        file_out = "C:/tests/teacher3/out.txt";

        file_out_two = "C:/out.txt";

        String[] s = {file_in_1, file_in_2, file_out_two};
        Algo.Graph.main(s);

        open_file_out();
        open_file_out_two();

        String line1 = getline(Buffered_Reader);
        String line2 = getline(Buffered_Reader_two);

        while (line1 != null && line2 != null) {
            assertEquals(line1, line2);
            line1 = getline(Buffered_Reader);
            line2 = getline(Buffered_Reader_two);
        }

        CloseAllFiles();
    }

    @Test(timeout = 1000)
    public void test_teacher4() throws IOException {
        file_in_1 = "C:/tests/teacher4/in1.txt";
        file_in_2 = "C:/tests/teacher4/in2.txt";
        file_out = "C:/tests/teacher4/out.txt";

        file_out_two = "C:/out.txt";

        String[] s = {file_in_1, file_in_2, file_out_two};
        Algo.Graph.main(s);

        open_file_out();
        open_file_out_two();

        String line1 = getline(Buffered_Reader);
        String line2 = getline(Buffered_Reader_two);

        while (line1 != null && line2 != null) {
            assertEquals(line1, line2);
            line1 = getline(Buffered_Reader);
            line2 = getline(Buffered_Reader_two);
        }

        CloseAllFiles();
    }

    /**
     * open the open_file_out
     */
    public static void open_file_out() throws FileNotFoundException {
        File f = new File(file_out);
        File_Reader = new FileReader(f);
        Buffered_Reader = new BufferedReader(File_Reader);

    }

    /**
     * open the open_file_out
     */
    public static void open_file_out_two() throws FileNotFoundException {
        File f = new File(file_out);

        File_Reader_two = new FileReader(f);
        Buffered_Reader_two = new BufferedReader(File_Reader);

    }

    /**
     * give one line from Buffered_Reader
     */
    public static String getline(BufferedReader Buffered_Reader) {

        return null;
    }

    /**
     * Close the all File
     */
    public static void CloseAllFiles() {
        try {
            Buffered_Reader.close();
            File_Reader.close();

            Buffered_Reader_two.close();
            File_Reader_two.close();

        } catch (IOException ex) {
            Logger.getLogger(Graph.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
}
