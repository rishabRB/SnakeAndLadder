import java.io.*;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        run();
    }

    public static void run() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("sample_input_output/input.txt"));
        System.setOut(new PrintStream(new File("sample_input_output/output.txt")));
        System.out.println("hello");
        try(br){
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}