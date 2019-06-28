import java.io.*;
import java.util.List;

public class txtload {
    private BufferedReader brr = null;
    private File writeName = null;
    private FileWriter writer = null;
    private BufferedWriter out = null;
    public txtload(){
        try {
            brr=new BufferedReader(new FileReader("C:\\Users\\zyc14588\\IdeaProjects\\nlp\\test2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            writeName = new File("C:\\Users\\zyc14588\\IdeaProjects\\nlp\\keyword2.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            writer = new FileWriter(writeName);
            out= new BufferedWriter(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public txtload(String readname,String writename){
        try {
            brr=new BufferedReader(new FileReader(readname));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            writeName = new File(writename);
            writeName.createNewFile();
            writer = new FileWriter(writeName);
            out= new BufferedWriter(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BufferedReader GetReadbuf(){
        final BufferedReader brr1 = this.brr;
        return brr1;
    }
    public BufferedWriter GetWritebuf(){
        final BufferedWriter out1 = this.out;
        return out1;
    }
    public void reloadread(String name){
        try {
            brr=new BufferedReader(new FileReader(name));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void reloadwrite(String name){
        try {
            writeName = new File(name);
            writeName.createNewFile();
            writer = new FileWriter(writeName);
            out= new BufferedWriter(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String Readln() throws IOException {
        final String s = brr.readLine();
        return s;
    }
    public void Write(String str) throws IOException {
        out.write(str+"\r\n");
        out.flush();
    }
    public void Write(List<String> con) throws IOException {
        out.write(con.toString()+"\r\n");
        out.flush();
        con.clear();
    }
}
