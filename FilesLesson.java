// Files are Objects
// and they have to be imported
import java.io.File;

// we use Scanner to read from Files
import java.util.Scanner;

import java.io.IOException;
import java.io.PrintWriter;
public class FilesLesson
{
    public static void firstExample () throws IOException
    {
        File f = new File("primes.txt");
        // this looks in the SAME FOLDER as this .java
        // file.
        
        Scanner sc = new Scanner(f); // instead of System.in

        // now we can use Scanner's methods like nextInt, nextLine, nextDouble, next
        // to read either individual "tokens" or entire lines from the File
        int firstPrime = sc.nextInt();
        System.out.println(firstPrime);

        // how many times can we call nextInt?
        for (int i = 0; i < 10000; i++)
        {
            int prime = sc.nextInt();
            System.out.println(prime);
        }
        // um that's too many times
        // we got a NoSuchElementException and the program crashed
        // what we need is a way to figure out if the file
        // has anything for us to read
        // we can use Scanner's hasNext() method
        // (there is also hasNextInt, hasNextLine, etc)

    }
    
    public static void main2 () throws IOException
    {
        File myFile = new File("primes.txt");
        // this looks in the SAME FOLDER as this .java
        // file.
        File otherFile;
        // if we want to look elsewhere for a file,
        // such as H:\compsci\data.txt
        // you have to use \\ for each single \
        // because \ is used for String "escape" characters
        otherFile = new File("G:\\My Drive\\CompSci\\ICS4U\\blah.txt");
        
        // If you get the user to type a location
        // they DO NOT type the \\, just \
        // ex. "Please enter file location"
        // User: C:\whatever\stuff\filename.txt

        // now use Scanner with the file
        Scanner sc = new Scanner(myFile);

        // now that we've made the Scanner and addressed the
        // Exceptions, we can use regular Scanner methods
        // like nextInt, nextLine, next, nextDouble to read info

        int x = sc.nextInt();
        System.out.println(x);

        // Solution to knowing how many lines to read:
        // use Scanner methods: hasNext, hasNextLine,
        // hasNextInt...

        int size = 1000;
        int[] arr = new int[size]; // perhaps a big waste of space
        int i = 0;
        while (sc.hasNext()) // or hasNextInt
        {
            arr[i] = sc.nextInt();
            i++;
        }
        System.out.println(arr[i-1]);
        
        
        // Writing to files
        // We'll use PrintWriter objects
        PrintWriter pw = new PrintWriter ("output.txt");
        // you can use print and println like with System.out
        pw.append("buffer issue?");
        pw.close(); // safely close the file at the end.
        // we don't have to do this with the Scanner
        // because of the way File works.
        // PrintWriters should be closed.
    }
    
    public static void ex3() throws IOException
    {
        File cData = new File("countries.txt");
        Scanner fScan = new Scanner(cData);
        while (fScan.hasNextLine())
        {
            String oneLine = fScan.nextLine();
            String[] tokensOnThisLine = oneLine.split(" ");
            // python way

            //System.out.println("one line is done");   
            String country = tokensOnThisLine[0];
            int pop = Integer.parseInt(tokensOnThisLine[1]);
            // more verbose but exactly the same idea as
            // in Python: int(some string)
            
            // this type conversion is called "casting"
        }
    }

    
    public static void ex4() throws IOException
    {
        File cData = new File("countries.txt");
        Scanner fScan = new Scanner(cData);
        while (fScan.hasNextLine())
        {
            String country = fScan.next();
            // assumes the country is a single String
            // i.e. no space like in Burkina Faso or The Bahamas
            int pop = fScan.nextInt();

        }
    }
}