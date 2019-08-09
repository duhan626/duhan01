package com.shujuniu.gwbmid.service.impl;

import com.shujuniu.gwbmid.dto.GwbmidDto;
import com.shujuniu.gwbmid.mapper.GwBMIDMapper;
import com.shujuniu.gwbmid.po.GwBMIDDao;
import com.shujuniu.gwbmid.service.GwBMIDService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class GwBMIDServiceImpl implements GwBMIDService {
    @Autowired
    private GwBMIDMapper gwBMIDMapper;

    /**
     * 往模板表插入模板数据
     *
     * @return
     */
    @Override
    public int insert() {
        String pathname = "D:\\ucopenmodel20190722.txt"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        try (
//                FileReader reader = new FileReader(pathname);
                InputStreamReader reader = new InputStreamReader(new FileInputStream(pathname), "GBK");
                BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言

        ) {
            String line = null;
            GwBMIDDao gwBMIDDao = null;
            while ((line = br.readLine()) != null) {
                gwBMIDDao = new GwBMIDDao();
                // 一次读入一行数据
                List<String> list = extractMessage(line); //line.trim()

                for (int i = 0; i < list.size(); i++) {
                    //模板号
//                    String mid = replace(line);//去各种空格回转tab
                    String mid = line.trim();//去头尾空格
                    String[] mess = mid.split(";");
                    gwBMIDDao.setMid(mess[0]);
                    System.out.println("mid=" + mess[0]);
                    String ms = mess[1];
                    gwBMIDDao.setMs(ms);
                    System.out.println("MS=" + ms);
                    //签名：
                    String qm = list.get(i);
                    System.out.println("qm=" + qm);
                    gwBMIDDao.setQm(qm);

                    gwBMIDDao.setGwid(267);
                    gwBMIDDao.setCretime(new Date());
                    gwBMIDDao.setLasttime(new Date());
                    gwBMIDDao.setOperator("lcy");
                    gwBMIDDao.setFlag((byte) 3);
                    gwBMIDMapper.insert(gwBMIDDao);
                }
            }
        } catch (IOException e) {

            e.printStackTrace();
        }


        return 0;
    }

    /**
     * 判断模板表是否存在已有模板，精确匹配
     *
     * @param dto
     * @return
     */
    @Override
    public boolean selectByMS(GwbmidDto dto) {
        boolean isok = false;
        GwBMIDDao gwBMIDDao = null;
        try {
            gwBMIDDao = gwBMIDMapper.selectByMS(dto.getMs());

        } catch (Exception e) {
            log.info("eee没有查到记录" + e.getMessage());
            e.printStackTrace();
        }
        if (dto.getMs().contains(gwBMIDDao.getMs())) {

            log.info("模板已重复");
            isok = true;
        }
        if (isok) {
            if (gwBMIDDao.getMs().contains(dto.getMs())) {
                log.info("模板已重复");
                isok = true;
            }
        }
        return isok;
    }

    @Override
    public int doTxt() {
        //读取要过滤的txt数据
        String pathname = "D:\\ucdataqc.txt";
        try {
             String line=null;
            InputStreamReader reader = new InputStreamReader(new FileInputStream(pathname), "GBK");
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            while ((line = br.readLine()) != null) {
                boolean isok = false;
                GwBMIDDao gwBMIDDao = null;
                try {
                    gwBMIDDao = gwBMIDMapper.selectByMS(line.trim().substring(0,line.length()-line.length()/5));

                } catch (Exception e) {
                    log.info("eee没有查到记录" + e.getMessage());
                    e.printStackTrace();
                }
                if(gwBMIDDao!=null) {
                    log.info("模板已重复!!!!!!"+line+"!!!!!!!!!!!!!!!!!"+gwBMIDDao.getMs());

                    if (line.trim().toString().contains(gwBMIDDao.getMs())||gwBMIDDao.getMs().equalsIgnoreCase(line.trim())|| gwBMIDDao.getMs().contains(line.trim())) {
                        isok = true;
                        log.info("模板已重复");

                    }
                }
                if (!isok) {
                    log.info("isok+++++++++++++++++++"+isok);
//                    writeFile(line);
                    //写入数据测试
                    String path = "D:\\test.txt";
                    String word = line;
                    BufferedWriter out = null;
                    try {
                        out = new BufferedWriter(
                                new OutputStreamWriter(new FileOutputStream(path, true)));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    try {
                        out.write(word + "\r\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }

        }catch(Exception ex){

            }

            //与表中查询是否存在表中数据


            //如果存在，则不写新的txt


            //如果不在了，则要写到新的txt


            return 0;
        }

        public static String replace (String str){
            String destination = "";
            if (str != null) {
                Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                Matcher m = p.matcher(str);
                destination = m.replaceAll("");
            }
            return destination;
        }


        /**
         * 提取中括号中内容，忽略中括号中的中括号
         *
         * @param msg
         * @return
         */

        public static List<String> extractMessage (String msg){
            List<String> list = new ArrayList<String>();
            int start = 0;
            int startFlag = 0;
            int endFlag = 0;
            for (int i = 0; i < msg.length(); i++) {
                if (msg.charAt(i) == '【') {
                    startFlag++;
                    if (startFlag == endFlag + 1) {
                        start = i;
                    }
                } else if (msg.charAt(i) == '】') {
                    endFlag++;
                    if (endFlag == startFlag) {
                        list.add(msg.substring(start + 1, i));
                    }
                }
            }
            return list;
        }

    /**
     * 写入TXT文件
     */
    public static void writeFile(String string) {
        try {
            File writeName = new File("outuc.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                out.write(string+"\r\n"); // \r\n即为换行

                out.flush(); // 把缓存区内容压入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    }
