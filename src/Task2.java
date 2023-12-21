import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) throws IOException {
        String reg = "\\bdocnum[A-Za-z0-9]{9}\\b";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher;
        String docnum = "\\bdocnum";
        Pattern patdoc = Pattern.compile(docnum);
        FileReader fr = new FileReader("docs");
        FileWriter fwv = new FileWriter("valid");
        FileWriter fwn = new FileWriter("notvalid");

        int i;
        String str = "";
        while((i = fr.read()) != -1){
            if(i == '\n'){
                matcher = pattern.matcher(str);
                if(matcher.find()){
                    fwv.write(str);
                    fwv.flush();
                    str = "";
                }
                else{
                    matcher = patdoc.matcher(str);
                    if(matcher.find()) {
                        fwn.write(str + " неверный формат символов\n");
                        fwn.flush();
                    }
                    else {
                        fwn.write(str + " отсутствует или неверно расположен doctype\n");
                        fwn.flush();
                    }
                    str = "";
                }
            }
            else{
                str += (char)i;
            }
        }
        matcher = pattern.matcher(str);
        if(matcher.find()){
            fwv.write(str);
            fwv.flush();
            str = "";
        }
        else{
            matcher = patdoc.matcher(str);
            if(matcher.find()) {
                fwn.write(str + " неверный формат символов\n");
                fwn.flush();
            }
            else {
                fwn.write(str + " отсутствует или неверно расположен docnum\n");
                fwn.flush();
            }
            str = "";
        }
    }
}
