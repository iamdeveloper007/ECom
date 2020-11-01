package com.ecom.ecom;

import com.ecom.ecom.util.ProducerConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomApplication {

	public static void main(String[] args) {

		ProducerConsumer producerConsumer = new ProducerConsumer();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run()
			{
				try {
					producerConsumer.consume();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		thread.start();
		SpringApplication.run(EcomApplication.class, args);
	}

}
