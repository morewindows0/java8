package com.dev.java.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dev.java.test.po.TrafficControlCity;
import com.google.common.collect.Sets;

/**
 * @author: dengxin.chen
 * @date: 2019-07-03 11:10
 * @description:
 */
public class DataProcess {

    public static void main(String[] args) throws Exception {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:/error.txt"))) {
//            List<String> ff = Arrays.asList("1", "2");
//            String failedString = Joiner.on(",\r\n").join(ff);
//            writer.write(failedString);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        TreeSet<Integer> longs = Sets.newTreeSet(Comparator.reverseOrder());
        longs.add(3);
        longs.add(2);
        longs.add(1);
        ArrayList<Integer> integers = new ArrayList<>(longs);
        List<Integer> integers1 = integers.subList(0, 3);
        process1();
    }

    public static void process() throws IOException {
        String uri = "http://dmptx.56qq.com/machine/query.do";

        HttpPost httpPost = new HttpPost(uri);
        List<NameValuePair> params = new ArrayList<>();
        // 请求头设置
        httpPost.addHeader("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
        // 数据库id
        params.add(new BasicNameValuePair("id", "133"));
        // 待执行sql
        params.add(new BasicNameValuePair("sql", "select order_no from t_orders"));
        httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
        // 必须设置cookie
        httpPost.addHeader("Cookie", "adminFlag=false;dbaFlag=false;JSESSIONID=EB0E187157AA0A006A7334414B922110;username=%E6%9D%8E%E5%86%9B;email=jun7.li@56qq.com;sid=undefined;st=undefined;admin_flag=false;dba_flag=false;prodId=4");

        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(httpPost);
        String entity = EntityUtils.toString(response.getEntity());

        JSONObject parseResult = (JSONObject) JSONObject.parse(entity);
        JSONArray content = JSONObject.parseArray(parseResult.get("content").toString());
    }

    public static void process1() throws Exception {
        try {
            String uri = "http://restapi.amap.com/v4/traffic/restriction/cities?key=551008fd722823c51290753166a95e8e&type=1";

            HttpGet httpGet = new HttpGet(uri);
//            List<NameValuePair> params = new ArrayList<>();
           /* String code = "429006";
            params.add(new BasicNameValuePair("where", "CITYCODE=\'" + code + "\'"));
            params.add(new BasicNameValuePair("geometryType", "esriGeometryEnvelope"));
            params.add(new BasicNameValuePair("spatialRel", "esriSpatialRelIntersects"));
            params.add(new BasicNameValuePair("returnGeometry", "true"));
            params.add(new BasicNameValuePair("returnIdsOnly", "false"));
            params.add(new BasicNameValuePair("returnCountOnly", "false"));
            params.add(new BasicNameValuePair("returnZ", "false"));
            params.add(new BasicNameValuePair("returnM", "false"));
            params.add(new BasicNameValuePair("returnDistinctValues", "false"));
            params.add(new BasicNameValuePair("f", "pjson"));
            httpGet.(new UrlEncodedFormEntity(params, HTTP.UTF_8));*/
           /* httpGet.addHeader("key", "551008fd722823c51290753166a95e8e");
            httpGet.addHeader("type", "1");*/
           /* BasicHttpParams params = new BasicHttpParams();
            params.setParameter("key", "2cd2969ab5c8d7d3695ddf9572f885ed");
            params.setParameter("type", "1");
            httpGet.setParams(params);*/

            CloseableHttpClient client = HttpClients.createDefault();
            CloseableHttpResponse response = client.execute(httpGet);
            String entity = EntityUtils.toString(response.getEntity());

            JSONObject parseResult = (JSONObject) JSONObject.parse(entity);
            JSONObject content = (JSONObject) JSONObject.parse(parseResult.get("data").toString());
            List<TrafficControlCity> cities = JSONArray.parseArray(content.get("cities").toString(), TrafficControlCity.class);
           /* JSONObject geometry = (JSONObject) ringArray.get("geometry");
            JSONArray rings = JSONArray.parseArray(geometry.get("rings").toString());
            JSONArray result = JSONArray.parseArray(rings.get(0).toString());
            List<CityLngLat> cityResult = result.parallelStream().map(e -> {
                JSONArray item = (JSONArray) e;
                return CityLngLat.builder()
                                 .lng(Double.valueOf(item.get(0).toString()))
                                 .lat(Double.valueOf(item.get(1).toString()))
                                 .build();
            }).collect(Collectors.toList());

            List<CityLngLat> collect = cityResult.stream().sorted(Comparator.comparingDouble(CityLngLat::getLng)).collect(Collectors.toList());
            List<CityLngLat> ascLatList = cityResult.stream().sorted(Comparator.comparingDouble(CityLngLat::getLat)).collect(Collectors.toList());*/
            System.out.println("fdasf");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
