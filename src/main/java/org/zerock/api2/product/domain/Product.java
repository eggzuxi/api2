package org.zerock.api2.product.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Table(name = "tbl_product") // table 생성
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    private String pname;

    private int price;

    private ProductStatus status;

    // tags는 불변
    @CollectionTable(name = "tbl_product_tag")
    @ElementCollection // 테이블 생성, pk가 없음, 수정이 불가능
    private Set<String> tags = new HashSet<>();

    public void addTag(String tag) {
        tags.add(tag);
    }

    public void removeTag(String tag) {
        tags.remove(tag);
    }

    public void clearTags() {
        tags.clear();
    }

}
