package com.green.jpaexam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing// 이 어노테이션을 입력해야 상속받은 데이트 값이 입력됨
public class JapAuditingConfiguration {
}
