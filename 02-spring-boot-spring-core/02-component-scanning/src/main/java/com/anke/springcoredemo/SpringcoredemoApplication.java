package com.anke.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"com.anke.springcoredemo", // springcoredemo package'ının altındaki tüm paketler taranır
							"com.anke.util"}) // util package'ının altındaki tüm paketler taranır
//	Hangisinde @SpringBootApplication varsa onun scanBasePackages'ı geçerli olur ve o çalıştırılır.
//	scanBasePackages parametresi ile yalnızca com.anke.springcoredemo ve com.anke.util paketlerindeki bileşenler taranır
//	ve Spring IoC container'a kaydedilir.
//@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
