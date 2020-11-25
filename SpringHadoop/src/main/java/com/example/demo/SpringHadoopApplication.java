package com.example.demo;

import org.apache.hadoop.fs.FileStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.hadoop.fs.FsShell;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringHadoopApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringHadoopApplication.class, args);
	}

	@Autowired
	FsShell fsShell;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("*** HDFS content:");
		 for (FileStatus fs : fsShell.ls("/")) {
		 System.out.println(fs.getOwner() +
		 " " + fs.getGroup() + ": /" + fs.getPath().getName());
		 }
		
	}
	@Bean
	 FsShell fsShell() {
	 org.apache.hadoop.conf.Configuration hadoopConfiguration =
	 new org.apache.hadoop.conf.Configuration();
	 hadoopConfiguration.set("fs.defaultFS", "hdfs://192.168.99.101:8020");
	 return new FsShell(hadoopConfiguration);
	 }


}
