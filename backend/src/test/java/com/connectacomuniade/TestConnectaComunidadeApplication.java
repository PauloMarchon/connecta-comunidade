package com.connectacomuniade;

import org.springframework.boot.SpringApplication;

public class TestConnectaComunidadeApplication {

	public static void main(String[] args) {
		SpringApplication.from(ConnectaComunidadeApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
