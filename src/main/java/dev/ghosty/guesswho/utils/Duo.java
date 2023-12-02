package dev.ghosty.guesswho.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Duo<A, B> {
	
	A a;
	B b;
	
}
