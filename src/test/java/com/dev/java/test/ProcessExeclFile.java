package com.dev.java.test;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.dev.java.test.po.HcbGasDataImportInput;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: dengxin.chen
 * @date: 2019-06-06 15:41
 * @description:
 */
@Slf4j
public class ProcessExeclFile {

    public static void main(String[] args) throws Exception {

//        processAppend();
//        processOptionLevel();
//        partitionExcel();
//        processLocationData();
        processFirstOrder();

    }

    /**
     * 处理问句记录
     *
     * @throws FileNotFoundException
     */
    private static void processOptionLevel() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("D:/questionrecord.xlsx");
        List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 1));
        data.stream().forEach(e -> {
            StringBuilder selectSql = new StringBuilder();
            StringBuilder updateSql = new StringBuilder();
            selectSql.append("select question_record.id,question_record.question_option_id,question_record.question_option_level,question_option.id,question_option.option_level from question_record,question_option where question_record.question_option_id=question_option.id and question_record.id=");
            updateSql.append("UPDATE question_record set question_record.question_option_level=(select question_option.option_level from question_option where question_option.id=question_record.question_option_id) where question_record.id=");
            ArrayList dataItem = (ArrayList) e;
            String id = (String) dataItem.get(0);
            selectSql.append(id + " limit 1;");
            updateSql.append(id + " limit 1;");
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/processdata.txt", true));
                bufferedWriter.write(selectSql.toString());
                bufferedWriter.newLine();
                bufferedWriter.write(updateSql.toString());
                bufferedWriter.newLine();
                selectSql.setLength(0);
                updateSql.setLength(0);
                bufferedWriter.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        System.out.println("总共处理 " + data.size() + " 条数据");
    }

    /**
     * 处理司机追评
     *
     * @throws FileNotFoundException
     */
    private static void processAppend() throws FileNotFoundException {

        InputStream inputStream = new FileInputStream("D:/司机追评.xlsx");
        List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 1));
        data.stream().forEach(e -> {
            ArrayList dataItem = (ArrayList) e;
            String orderNo = (String) dataItem.get(0);
            Integer starLevel = Integer.valueOf((String) dataItem.get(1));
            StringBuilder selectSql = new StringBuilder();
            StringBuilder updateSql = new StringBuilder();
            selectSql.append("select order_no,star_level from evaluate where order_no=");
            selectSql.append("\"");
            selectSql.append(orderNo);
            selectSql.append("\"");
            selectSql.append(" limit 1;");

            updateSql.append("update evaluate set star_level=");
            updateSql.append(starLevel);
            updateSql.append(" where order_no=");
            updateSql.append("\"");
            updateSql.append(orderNo);
            updateSql.append("\"");
            updateSql.append(" limit 1;");

            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/processdata.txt", true));
                bufferedWriter.write(selectSql.toString());
                bufferedWriter.newLine();
                bufferedWriter.write(updateSql.toString());
                bufferedWriter.newLine();
                selectSql.setLength(0);
                updateSql.setLength(0);
                bufferedWriter.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
        System.out.println("总共处理 " + data.size() + " 条数据");
    }


    public static void partitionExcel() throws Exception {
        InputStream inputStream = new FileInputStream("D:/无标题.xlsx");
        List<HcbGasDataImportInput> dataList = readExcel(inputStream, HcbGasDataImportInput.class);
        List<List<HcbGasDataImportInput>> partitions = Lists.partition(dataList, 10000);
        int index = 0;
        for (List<HcbGasDataImportInput> partition : partitions) {
            export("D:/HcbGasData_" + index + ".xlsx", partition, HcbGasDataImportInput.class);
            index++;
        }

    }

    public static void processLocationData() throws Exception {
        InputStream inputStream = new FileInputStream("D:/合作油站属性.xlsx");
        List<Object> dataList = EasyExcelFactory.read(inputStream, new Sheet(1, 1));
        StringBuilder updateSql = new StringBuilder();
        dataList.stream().forEach(e -> {
            ArrayList dataItem = (ArrayList) e;
            Object location = StringUtils.isEmpty((String) dataItem.get(7)) ? "其他" : dataItem.get(7);
            updateSql.append("update hcb_gas_station_copy set location=\"" + location + "\" where id=" + dataItem.get(0) + ";");
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/processdata.txt", true));
                bufferedWriter.write(updateSql.toString());
                bufferedWriter.newLine();
                updateSql.setLength(0);
                bufferedWriter.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        System.out.println("总共处理 " + dataList.size() + " 条数据");
    }

    public static void processFirstOrder() throws Exception {
        InputStream inputStream = new FileInputStream("C:\\Users\\dengxin.chen\\Desktop\\18-24.xlsx");
        List<Object> dataList = EasyExcelFactory.read(inputStream, new Sheet(1, 1));
        List<String> data = Lists.newArrayList();
        dataList.forEach(e -> {
            ArrayList dataItem = (ArrayList) e;
            data.add((String) dataItem.get(2));

        });
        final List<String> collect = data.stream().distinct().collect(Collectors.toList());
        List<List<String>> partitions = Lists.partition(collect, 1000);
        int index = 0;
        for (List<String> partition : partitions) {
            String join = Joiner.on(",").join(partition);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT buyer_id,if(count(1)=1,\"是首单\",\"不是首单\") as '是否首单'" + " FROM t_orders WHERE buyer_id in ( ");
            sql.append(join + ")");
            sql.append("AND order_status IN (20, 25) AND is_test = 0 GROUP BY buyer_id;");
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/sql" + index + ".txt"));
                bufferedWriter.write(sql.toString());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            index++;
        }

    }


    private static <T extends BaseRowModel> List<T> readExcel(InputStream inputStream, Class<T> clazz) {
        Objects.requireNonNull(inputStream, "InputStream must be not null");
        List<T> result = Lists.newArrayList();
        EasyExcelFactory.readBySax(inputStream, new Sheet(1, 1, clazz), new AnalysisEventListener<T>() {
            @Override
            public void invoke(T object, AnalysisContext analysisContext) {
                result.add(object);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.warn("文件流关闭异常", e);
                }
            }
        });
        return result;
    }

    public static <T extends BaseRowModel> void export(String fileName,
                                                       List<T> data,
                                                       Class<T> tClass) throws Exception {
        Objects.requireNonNull(fileName, "fileName must be not null");
        try (FileOutputStream out = new FileOutputStream(fileName)) {

            ExcelWriter writer = EasyExcelFactory.getWriter(out, ExcelTypeEnum.XLSX, true);

            Sheet sheet = new Sheet(1, 0, tClass);
            writer.write(data, sheet);
            writer.finish();
        } catch (Exception e) {
            log.error("文件:[" + fileName + ".xlsx]导出失败", e);
            throw new Exception("文件导出失败");
        }
    }
}
