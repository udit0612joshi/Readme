package com.app.springboot;



import java.io.File;
import java.io.IOException;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;

public class TestParquet {
	public static void main(String[] args) throws IOException {
		System.setProperty("hadoop.home.dir", "C:\\Users\\DBR-1\\Downloads\\Microsoft.SkypeApp_kzf8qxf38zg5c!App\\All\\hadoop-winutils-2.6.0\\");
        Schema schema = new Schema.Parser().parse(new File("EmpSchema.avsc"));
        Path path = new Path("EmpRecord.parquet");
        ParquetWriter<GenericData.Record> writer = null;
        try {
            writer = AvroParquetWriter.
                <GenericData.Record>builder(path)
                .withRowGroupSize(1073741824)
                .withPageSize(ParquetWriter.DEFAULT_PAGE_SIZE)
                .withSchema(schema)
                .withConf(new Configuration())
                .withCompressionCodec(CompressionCodecName.SNAPPY)
                .withValidation(false)
                .withDictionaryEncoding(false)
                .build();
            
           
            for (int i =0;i<500;i++) {
            	GenericData.Record record = new GenericData.Record(schema);
            	 record.put("id", i);
                 record.put("Name", "Avul Pakir Jainulabdeen Abdul Kalam");
                 record.put("Dept", "aerospace scientist");
                 record.put("Address", "Mosque Street, Rameswaram, Ramanathapuram, Tamil Nadu");
                 record.put("Salary", "Six lakhs");
                 record.put("Expenditure", "One lakhs");
                 record.put("Hobbies", "	Reading Books, Watching Movies, Jogging, Playing Football");
                 record.put("LastName", "Jainulabdeen Abdul Kalam");
                writer.write(record);
            }
            
        }catch(IOException e) {
            e.printStackTrace();
        }finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
	
    
    
    

	}
