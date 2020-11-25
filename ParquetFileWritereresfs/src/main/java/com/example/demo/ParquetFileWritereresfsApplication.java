package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.column.page.PageReadStore;
import org.apache.parquet.example.data.Group;
import org.apache.parquet.example.data.GroupFactory;
import org.apache.parquet.example.data.simple.SimpleGroup;
import org.apache.parquet.example.data.simple.convert.GroupRecordConverter;
import org.apache.parquet.format.converter.ParquetMetadataConverter;
import org.apache.parquet.hadoop.ParquetFileReader;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.example.GroupWriteSupport;
import org.apache.parquet.io.ColumnIOFactory;
import org.apache.parquet.io.MessageColumnIO;
import org.apache.parquet.io.RecordReader;
import org.apache.parquet.schema.MessageType;
import org.apache.parquet.schema.Type;

@SpringBootApplication
public class ParquetFileWritereresfsApplication {
    
	private static Path readPathFile = new Path("userdata1.parquet");
	private static Path writePathFile = new Path("my.parquet");

	public static MessageType schema;

	public static MessageType getSchema() {
		return schema;
	}

	public static void setSchema(MessageType schema) {
		ParquetFileWritereresfsApplication.schema = schema;
	}

	private static Group printGroup(Group g) {
		int count = 0;
		int fieldCount = g.getType().getFieldCount();
		for (int field = 0; field < fieldCount; field++) {
			int valueCount = g.getFieldRepetitionCount(field);
			Type fieldType = g.getType().getType(field);
			String fieldName = fieldType.getName();
			for (int index = 0; index < valueCount; index++) {
				if (fieldType.isPrimitive()) {
					System.out.println(fieldName + " " + g.getValueToString(field, index));
					count++;
				}
			}
		}
		
		return g;

	}

	
	public static List<Group> readParquetExample() {

		List<Group> groups = new ArrayList<>();
		Configuration conf = new Configuration();
		PageReadStore pages = null;
		try (ParquetFileReader r = new ParquetFileReader(conf, readPathFile, ParquetMetadataConverter.NO_FILTER)) {
			MessageType schema = r.getFileMetaData().getSchema();
			setSchema(schema);
			while (null != (pages = r.readNextRowGroup())) {
				long rows = pages.getRowCount();
				MessageColumnIO columnIO = new ColumnIOFactory().getColumnIO(schema);
				RecordReader<Group> recordReader = columnIO.getRecordReader(pages, new GroupRecordConverter(schema));
				for (int i = 0; i < rows; i++) {
					Group g = recordReader.read();
					Group group = printGroup(g);
					groups.add(group);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return groups;
	}

	public static void writeTo(List<Group> groups) {
		Configuration configuration = new Configuration();

		GroupWriteSupport.setSchema(getSchema(), configuration);
		try (ParquetWriter<Group> writer = new ParquetWriter<Group>(writePathFile, configuration,
				new GroupWriteSupport())) {
			System.out.println("Number of groups to write:" + groups.size());
			for (Group g : groups) {
				writer.write(g);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.setProperty("hadoop.home.dir", "C:\\Users\\DBR-1\\Downloads\\Microsoft.SkypeApp_kzf8qxf38zg5c!App\\All\\hadoop-winutils-2.6.0\\");
		writeTo(readParquetExample());
		SpringApplication.run(ParquetFileWritereresfsApplication.class, args);
	}

}
