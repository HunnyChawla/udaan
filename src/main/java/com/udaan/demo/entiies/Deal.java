package com.udaan.demo.entiies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "deal")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "item_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Item item;
    private Long endTime;
    private Long startTime;
    private boolean isEnded;
}
