package com.lj.novels.util;

import java.io.*;

public class BookParseUtil {

    public static void main(String[] args) throws Exception{
//        FileReader fileReader = new FileReader("D:\\System\\User\\Downloads\\《十方武圣》（校对版全本）作者：滚开.txt");
//        BufferedReader br = new BufferedReader(fileReader) ;
//        FileWriter fileWriter = null ;
//        BufferedWriter bw = null ;
//        String line = "" ;
//        String writerPath = "F:\\Git\\book\\" ;
//        int i = 1;
//        while ((line = br.readLine()) != null){
//
//            if (!line.equals("") && line.substring(0,1).equals("第")){
//                String _writerPath = writerPath + i++ + ".html";
//                fileWriter = new FileWriter(_writerPath) ;
//                bw = new BufferedWriter(fileWriter) ;
//            }
//            if(fileWriter!=null){
////                line = line.replaceAll("\\s*","");
//                fileWriter.write("<p>" + line + "</p>" + "\t\n");
//            }
//
//
//            if(line.equals("")){
//                if(fileWriter!=null){
//                    fileWriter.close();
//                    fileWriter = null ;
//                }
//                if(bw!=null){
//                    bw.close();
//                    bw = null;
//                }
//            }
//        }
//        br.close();
//        fileReader.close();


        FileReader fileReader = new FileReader("D:\\System\\User\\Downloads\\《十方武圣》（校对版全本）作者：滚开.txt");
        BufferedReader br = new BufferedReader(fileReader) ;
        FileWriter fileWriter = new FileWriter("F:\\Git\\book\\目录.html") ;
        BufferedWriter bw = new BufferedWriter(fileWriter) ;
        String line = "" ;
        int i = 1;
        while ((line = br.readLine()) != null){

            if (!line.equals("") && line.substring(0,1).equals("第")){
                bw.write("<li class=\"list-group-item\">"+ "<a th:href=\"@{/readBook?xsbh=11&xszj=" + i++ + "}\">" + line + "</a></li>" + "\t\n");
            }
        }
        bw.close();
        fileWriter.close();
        br.close();
        fileReader.close();
    }
}
