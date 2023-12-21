import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("romeo");
        String str = "";
        String str1 = "";
        int i;
        while((i=fr.read()) != ' '){
            str += (char)i;
        }
        System.out.println(str);
        while((i = fr.read())!=-1){
            if(i == ' '|| i == ',' || i=='.'|| i == '?'||i=='\n'||i=='\r'){
                if(str1.length() > str.length()){
                    str = str1;
                    str1 = "";
                }
                else{
                    str1="";
                    continue;
                }
            }
            str1 += (char)i;
        }
        System.out.println(str);
        FileWriter fw = new FileWriter("long");
        fw.write(str);
        fw.flush();
    }
}