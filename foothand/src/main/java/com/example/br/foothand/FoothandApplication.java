package com.example.br.foothand;

import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.Current;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication(exclude =  DataSourceAutoConfiguration.class)
public class FoothandApplication {

	public static void main(String[] args) {


		long start = System.currentTimeMillis();
		log.info("===========================开始启动个人定制脚手架===================================");
		ConfigurableApplicationContext application = SpringApplication.run(FoothandApplication.class, args);

		long end = System.currentTimeMillis();
		System.out.println("");
		log.info("=============================启动个人定制脚手架成功，用时============================" + (end - start) + "ms===========");
		Environment env = application.getEnvironment();
        String ip = null;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        String port = env.getProperty("server.port");
		String path = env.getProperty("server.servlet.context-path");
		if (StringUtils.isEmpty(path)) {
			path = "";
		}
		log.info("\n----------------------------------------------------------\n\t" +
				"Application  is running! Access URLs:\n\t" +
				"Local访问网址: \t\thttp://localhost:" + port + path + "\n\t" +
				"External访问网址: \thttp://" + ip + ":" + port + path + "\n\t" +
				"----------------------------------------------------------");
	}

}
