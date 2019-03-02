package com.legend.analysis.reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static List readRawFile(String name,String encoding) {
        List<String> arrayList = new ArrayList<>();
        try {
            File file = new File(name);
            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file),encoding);
            BufferedReader bf = new BufferedReader(inputReader);
            String str;
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            inputReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private static void splitFileEqualy(String src, String endsrc, int num) {
        FileInputStream fis = null;
        File file = null;
        try {
            fis = new FileInputStream(src);
            file = new File(src);
            byte[] b = new byte[num];
            int len = 0;
            int seq = 1;
            String rawName = file.getName();
            int lastIndexOf = rawName.lastIndexOf(".");
            String prefix = rawName.substring(0, lastIndexOf);
            String suffix = rawName.substring(lastIndexOf, rawName.length());
            while ((len = fis.read(b)) != -1) {
                FileOutputStream fos = new FileOutputStream(endsrc + "\\\\"+ prefix + "-" + seq + suffix);
                fos.write(b, 0, len);
                fos.close();
                seq++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void splitFileByLine(String path,int maxline) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String fileName = path.substring(0, path.indexOf("."));
        String endName = path.substring(path.lastIndexOf("."));
        try {
            int i = 0;
            boolean end = false;
            while (true) {
                if (end)
                    break;
                StringBuffer sb = new StringBuffer();
                sb.append(fileName);
                sb.append("_data");
                sb.append(i);
                sb.append(endName);
                FileOutputStream fos = new FileOutputStream(new File(
                        sb.toString()));
                OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                BufferedWriter bw = new BufferedWriter(osw);
                String line;
                int m = 1;
                while((line = br.readLine())!=null ){
                    bw.write(line+"\t\n");
                    if(m>=maxline){
                        break;
                    }
                    m++;
                }
                if(m<maxline)
                    end = true;
                i++;
                bw.close();
                osw.close();
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            br.close();
            isr.close();
            fis.close();
        }
    }

    public static int getTotalLines(File file) throws IOException {
        FileReader in = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(in);
        reader.skip(Long.MAX_VALUE);
        int lines = reader.getLineNumber();
        reader.close();
        return lines;
    }
}
