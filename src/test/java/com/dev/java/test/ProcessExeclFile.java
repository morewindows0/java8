package com.dev.java.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSONObject;
import com.dev.java.test.po.HcbGasDataImportInput;
import com.dev.java.test.po.POI;
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
//        processExcel();
//        processData();

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

    // poi
    public static void processData() throws Exception {
        InputStream inputStream = new FileInputStream("C:\\Users\\dengxin.chen\\Desktop\\input.xlsx");

        List<POI> pois = readExcel(inputStream, POI.class);
        String result = JSONObject.toJSONString(pois).replaceAll("\"cellStyleMap\":\\{\\},", "");

        try {
            File file = new File("D:/result.txt");
            file.delete();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/result.txt"));
            bufferedWriter.write(result);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    private static <T extends BaseRowModel> List<T> readExcel(InputStream inputStream, Class<T> clazz) {
        Objects.requireNonNull(inputStream, "InputStream must be not null");
        List<T> result = Lists.newArrayList();
        EasyExcelFactory.readBySax(inputStream, new Sheet(3, 1, clazz), new AnalysisEventListener<T>() {
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
