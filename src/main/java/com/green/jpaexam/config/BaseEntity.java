package com.green.jpaexam.config;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    //@CreatedDate
    //@CreationTimestamp
    //@LastModifiedDate

    //같은 역

    @CreationTimestamp
    //@CreatedDate// 디테일한 시간 저장이 가능
    @Column(updatable = false)//수정 불가 설정
    private LocalDateTime createAt;

   // @LastModifiedDate
    @UpdateTimestamp
    private LocalDateTime updateAt;

}
