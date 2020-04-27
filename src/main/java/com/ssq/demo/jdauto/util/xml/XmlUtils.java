package com.ssq.demo.jdauto.util.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangshouyu
 * 微信XML辅助类
 */
public class XmlUtils {

    public static XStream xstream = null;

    private XmlUtils(){

    }

    static{

        /**
         * 扩展xstream，使其支持CDATA块
         */
        xstream = new XStream(new Xpp3Driver(new NoNameCoder()) {
            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {

                return new PrettyPrintWriter(out, getNameCoder()) {
                    // 对所有xml节点的转换都增加CDATA标记
                    boolean cdata = true;

                    @Override
                    public void startNode(String name, Class clazz) {
                        super.startNode(name, clazz);
                    }

                    @Override
                    protected void writeText(QuickWriter writer, String text) {
                        if (cdata) {
                            writer.write("<![CDATA[");
                            writer.write(text);
                            writer.write("]]>");
                        } else {
                            writer.write(text);
                        }
                    }
                };
            }
        }){
            // 反转对象多余列报错
            @Override
            protected MapperWrapper wrapMapper(MapperWrapper next){
                return new MapperWrapper(next) {
                    @Override
                    public boolean shouldSerializeMember(Class definedIn, String fieldName){
                        if (definedIn == Object.class){
                            try {
                                return this.realClass(fieldName) != null;
                            } catch (Exception e){
                                return false;
                            }
                        } else {
                            return super.shouldSerializeMember(definedIn, fieldName);
                        }
                    }
                };
            }

        };

        XStream.setupDefaultSecurity(xstream);
    }

    /**
     * 对象转xml
     * @param obj
     * @return
     */
    public static String object2Xml(Object obj) {
        xstream.processAnnotations(obj.getClass());
        return xstream.toXML(obj);
    }

    /**
     * 输入流转为Map
     * @param inputStream
     * @return
     */
    public static Map<String, String> stream2Map(InputStream inputStream)  {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<>(8);
        try{
            // 读取输入流
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            // 得到xml根元素
            Element root = document.getRootElement();
            // 得到根元素的所有子节点
            List<Element> elementList = root.elements();
            // 遍历所有子节点
            for (Element e : elementList){
                map.put(e.getName(), e.getText());
            }
        }catch (Exception e){

        }finally {
        }
        return map;
    }


    /**
     * 输入流转为Map
     * @param inputStream
     * @return
     */
    public static String stream2Xml(InputStream inputStream)  {
        // 将解析结果存储在HashMap中
        XMLWriter output = null;
        StringWriter writer = new StringWriter();
        String xml = "";
        try{
            // 读取输入流
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            OutputFormat format = OutputFormat.createCompactFormat();
            format.setEncoding("UTF-8");
            output = new XMLWriter(writer, format);
            output.write(document);
            xml = writer.toString();

        }catch (Exception e){

        }finally {
            try {
                writer.flush();
                writer.close();
                output.flush();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return xml;
    }

    /**
     * xml转map
     * @param xml
     * @return
     * @throws DocumentException
     * @throws IOException
     */
    public static Map<String, String> xml2Map(String xml){
        InputStream inputStream = null;
        try {
            inputStream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return stream2Map(inputStream);
    }

    /**
     * 对象转map
     * @param object
     * @return
     */
    public static Map<String, String> object2Map(Object object){
        return xml2Map(object2Xml(object));
    }

    /**
     * xml转bean
     * @param xml
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T xml2Bean(String xml, Class<T> tClass){
        // 设置允许转换类
        xstream.allowTypes(new Class[]{tClass});
        // xstream使用注解转换
        xstream.processAnnotations(tClass);
        // 转换bean
        return (T) xstream.fromXML(xml);
    }

    /**
     * xml转bean
     * @param xml
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T xml2Bean(InputStream xml, Class<T> tClass){
        return (T) xstream.fromXML(xml);
    }
}