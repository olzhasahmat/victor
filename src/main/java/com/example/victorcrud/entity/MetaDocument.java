package com.example.victorcrud.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "meta_documents")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetaDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String fileName;


    @Column
    private Long fileSize;


    @Column
    private String fileOriginalName;


    @Column
    private String contentType;
}
