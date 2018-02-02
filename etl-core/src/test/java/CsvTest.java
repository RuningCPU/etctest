import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

        public class CsvTest {
            public static void main(String[] args) {
                System.out.println("kaishi");
                read();

    }

    public static void read(){

        String filePath = "C:/Users/Administrator/Desktop/cesi_data/tongji.csv";

        try {
            // 创建CSV读对象
            FileReader fReader = new FileReader(filePath);
            CsvReader csvReader = new CsvReader(fReader);

            // 读表头
            csvReader.readHeaders();
            while (csvReader.readRecord()){
                // 读一整行
                System.out.println(csvReader.getRawRecord());
                // 读这行的某一列
                System.out.println(csvReader.get("PRODUCT_NAME"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(){

        String filePath = "/Users/dddd/test.csv";

        try {
            // 创建CSV写对象
            CsvWriter csvWriter = new CsvWriter(filePath,',', Charset.forName("GBK"));
            //CsvWriter csvWriter = new CsvWriter(filePath);

            // 写表头
            String[] headers = {"编号","姓名","年龄"};
            String[] content = {"12365","张山","34"};
            csvWriter.writeRecord(headers);
            csvWriter.writeRecord(content);
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}