import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Search {


     static public void searchFromKeyword(String key) throws ParserConfigurationException, IOException, SAXException {
//      在指定xml中查找指定字符串内容并打印所有包含的标签内的TextContent
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
//      路径的位置是项目文件夹下，并不是src下
//      而且xml里如果有&会报错，需要在原始数据里替换成转义&amp；，不知道有没有更优雅一点的解决办法
        Document doc= builder.parse("45104-2018-11-4-13-49-7.xml");
        NodeList list=doc.getElementsByTagName("d");
        //用的是StringBuffer作为遍历容器
        StringBuffer s=new StringBuffer();
        for (int i=0;i<list.getLength();i++){
            Node no=list.item(i);
            s.append(no.getTextContent());
            if (s.indexOf(key)!=-1){
                System.out.println(s);
            }
            s.delete(0,s.length()-1);
        }

    }
}
