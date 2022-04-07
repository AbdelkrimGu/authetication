package com.example.userservice.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Signal {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;







}
