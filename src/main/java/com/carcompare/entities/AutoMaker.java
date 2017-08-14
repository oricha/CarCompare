package com.carcompare.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="AUTOMAKER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutoMaker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;

}
