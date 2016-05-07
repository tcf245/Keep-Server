package test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3.计算文本中相同字符出现的次数
 */
public class Demo3 {

    //姓氏字符集合
    List<String> charList = new ArrayList<String>();
    //结果集存放Map
    Map<String,Integer> countMap = new HashMap<>();


    /**
     * 读取传入文件的数据，并且将姓氏字符提出出来放入charList集合中
     * @param file
     */
    public void getFirstName(File file){
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            boolean isEnd = false;
            while(!isEnd){
                String line= br.readLine();
                if(line == null){
                    isEnd = true;
                    break;
                }
                String s = getFirstChar(line);
                if(s != null){
                    charList.add(s);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历charList集合，将姓氏字符与出现次数分别放入<K,V> 键值对中
     */
    public void count(){
        for(String s : charList){
            if(countMap.containsKey(s)){
                countMap.put(s,countMap.get(s) + 1);
            }else{
                countMap.put(s,1);
            }
        }
    }

    /**
     * 根据空格拆分，并返回空格之前的姓氏字符
     * @param str
     * @return
     */
    public String getFirstChar(String str){
        String chars[] = str.split(" ");
        if(chars.length >=1){
            return chars[0];
        }
        return null;
    }

    public static void main(String[] args) {
        Demo3 demo = new Demo3();
        //传入File 地址
        demo.getFirstName(new File("etc/test.txt"));
        demo.count();

        //遍历结果集countMap 输出数据
        for(Map.Entry<String,Integer> entry : demo.countMap.entrySet()){
            System.out.println("the number of  " + entry.getKey() + "  is  " + entry.getValue());
        }

    }
}
